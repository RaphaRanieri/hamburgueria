package com.hamburgueria;

import com.hamburgueria.adicional.AdicionalBacon;
import com.hamburgueria.adicional.AdicionalQueijo;
import com.hamburgueria.adicional.VersaoSemGluten;
import com.hamburgueria.calculo.TotalizadorImposto;
import com.hamburgueria.calculo.TotalizadorPreco;
import com.hamburgueria.cardapio.*;
import com.hamburgueria.comunicacao.*;
import com.hamburgueria.config.RestauranteConfig;
import com.hamburgueria.cozinha.AcessoCozinha;
import com.hamburgueria.entrega.IntegradorEntrega;
import com.hamburgueria.entrega.PlataformaLogistica;
import com.hamburgueria.fila.FilaPedidos;
import com.hamburgueria.fluxo.*;
import com.hamburgueria.model.*;
import com.hamburgueria.pagamento.*;
import com.hamburgueria.pedido.*;
import com.hamburgueria.precificacao.*;
import com.hamburgueria.sistema.Hamburgueria;

public class Main {

    public static void main(String[] args) {

        separador("HAMBURGUERIA DO SEU ZÉ");

        // Singleton
        separador("Singleton — RestauranteConfig");
        RestauranteConfig cfg1 = RestauranteConfig.getInstance();
        RestauranteConfig cfg2 = RestauranteConfig.getInstance();
        System.out.println("Mesma instância? " + (cfg1 == cfg2));
        System.out.println("Restaurante: " + cfg1.getNomeRestaurante());

        // Flyweight
        separador("Flyweight — IngredienteRepositorio");
        Ingrediente q1 = IngredienteRepositorio.queijo();
        Ingrediente q2 = IngredienteRepositorio.queijo();
        System.out.println("Mesmo objeto Queijo? " + (q1 == q2));

        // Builder
        separador("Builder — LancheBuilder");
        Lanche artesanal = new LancheBuilder("Artesanal", 22.00)
                .comQueijo().comBacon().comAlface().comTomate().comMolhoEspecial()
                .build();
        System.out.println("Lanche: " + artesanal);

        // Factory Method
        separador("Factory Method — CriadorLanche");
        Lanche classico = new LancheClassicoCriador().preparar();
        Lanche veggie   = new LancheVeggieCriador().preparar();
        Lanche premium  = new LanchePremiumCriador().preparar();
        System.out.println(classico);
        System.out.println(veggie);
        System.out.println(premium);

        // Abstract Factory
        separador("Abstract Factory — MontadorCombo");
        Combo comboClassico = new ComboClassicoMontador().montar();
        Combo comboVeggie   = new ComboVeggieMontador().montar();
        Combo comboPremium  = new ComboPremiumMontador().montar();
        System.out.println(comboClassico);
        System.out.println(comboVeggie);
        System.out.println(comboPremium);

        // Decorator
        separador("Decorator — PersonalizacaoLanche");
        ItemCardapio comExtras = new AdicionalQueijo(new AdicionalBacon(classico));
        System.out.println("Base:       " + classico.getNome() + " | R$" + classico.getPreco());
        System.out.println("Com extras: " + comExtras.getNome() + " | R$" + comExtras.getPreco());
        ItemCardapio semGluten = new VersaoSemGluten(comExtras);
        System.out.println("Sem glúten: " + semGluten.getNome() + " | R$" + semGluten.getPreco());

        // Observer + State
        separador("Observer + State — Pedido com listeners e estados");
        Cliente ana = new Cliente("Ana", true);
        Pedido pedido1 = new Pedido(ana);
        pedido1.adicionarListener(new AvisoParaCozinha());
        pedido1.adicionarListener(new AvisoParaCliente());
        pedido1.adicionarListener(new AvisoParaCaixa());
        pedido1.adicionarItem(classico);
        pedido1.adicionarItem(new Bebida("Refri", 6.0));
        System.out.println("Pedido: " + pedido1);
        pedido1.atualizarStatus(StatusPedido.PREPARANDO);
        pedido1.atualizarStatus(StatusPedido.PRONTO);
        pedido1.atualizarStatus(StatusPedido.ENTREGUE);

        // Memento
        separador("Memento — Snapshot do pedido");
        Pedido pedido2 = new Pedido(new Cliente("Beto"));
        pedido2.adicionarItem(veggie);
        pedido2.salvarEstado();
        pedido2.adicionarItem(new Acompanhamento("Fritas", 8.0));
        System.out.println("Antes de restaurar: " + pedido2.getItens().size() + " itens");
        pedido2.restaurarEstado();
        System.out.println("Após restaurar:     " + pedido2.getItens().size() + " item");

        // Command
        separador("Command — Histórico de operações");
        Pedido pedido3 = new Pedido(new Cliente("Carol"));
        HistoricoOperacoes historico = new HistoricoOperacoes();
        historico.executar(new AdicionarItemPedido(pedido3, premium));
        historico.executar(new AdicionarItemPedido(pedido3, new Acompanhamento("Batata G", 10.0)));
        System.out.println("Itens: " + pedido3.getItens().size());
        historico.desfazer();
        System.out.println("Após desfazer: " + pedido3.getItens().size() + " item");

        // Chain of Responsibility
        separador("Chain of Responsibility — CadeiaProcessamento");
        Pedido pedido4 = new Pedido(new Cliente("Diego"));
        pedido4.adicionarListener(new AvisoParaCozinha());
        pedido4.adicionarItem(comboClassico);
        boolean ok = CadeiaProcessamento.montar().processar(pedido4);
        System.out.println("Processado? " + ok);

        // Strategy
        separador("Strategy — RegraDesconto");
        double total = pedido4.getTotal();
        System.out.printf("Bruto: R$%.2f%n", total);
        System.out.printf("Sem desconto:   R$%.2f%n", new SemDesconto().aplicar(total));
        System.out.printf("Estudante -10%%: R$%.2f%n", new DescontoEstudante().aplicar(total));
        System.out.printf("Fidelidade -15%%:R$%.2f%n", new DescontoFidelidade().aplicar(total));

        // Bridge
        separador("Bridge — FormaPagamento + GatewayCobranca");
        double valorFinal = new DescontoFidelidade().aplicar(total);
        System.out.println(new PagamentoSimples(new CobrancaPix()).processar(valorFinal, "Pedido #" + pedido4.getId()));
        System.out.println(new PagamentoSimples(new CobrancaCartao()).processar(valorFinal, "Pedido #" + pedido4.getId()));
        System.out.println(new PagamentoParcelado(new CobrancaCartao(), 3).processar(valorFinal, "Pedido #" + pedido4.getId()));

        // Proxy
        separador("Proxy — AcessoCozinha");
        AcessoCozinha comum = new AcessoCozinha(false);
        AcessoCozinha admin = new AcessoCozinha(true);
        System.out.println(comum.cancelarPreparo(pedido4.getId()));
        System.out.println(admin.cancelarPreparo(pedido4.getId()));

        // Template Method
        separador("Template Method — FluxoAtendimento");
        Pedido pedido5 = new Pedido(new Cliente("Eva"));
        pedido5.adicionarItem(veggie);
        new AtendimentoPresencial().atender(pedido5);
        Pedido pedido6 = new Pedido(new Cliente("Fábio"));
        pedido6.adicionarItem(comboPremium);
        new AtendimentoDelivery().atender(pedido6);

        // Mediator
        separador("Mediator — CentralMensagens");
        CentralMensagens central = new CentralMensagens();
        SetorCaixa caixa     = new SetorCaixa();
        SetorCozinha cozinha = new SetorCozinha();
        SetorEntrega entrega = new SetorEntrega();
        SetorCliente cliente = new SetorCliente();
        central.registrar(caixa);
        central.registrar(cozinha);
        central.registrar(entrega);
        central.registrar(cliente);
        caixa.confirmarPagamento(pedido4.getId());
        cozinha.pedidoPronto(pedido4.getId());

        // Adapter
        separador("Adapter — IntegradorEntrega");
        IntegradorEntrega integrador = new IntegradorEntrega(new PlataformaLogistica());
        System.out.println(integrador.despachar(pedido4.getId(), "Rua das Flores, 123", pedido4.getItens()));

        // Visitor
        separador("Visitor — TotalizadorPreco / TotalizadorImposto");
        TotalizadorPreco preco     = new TotalizadorPreco();
        TotalizadorImposto imposto = new TotalizadorImposto();
        comboClassico.aceitar(preco);
        comboClassico.aceitar(imposto);
        System.out.println(preco.resultado());
        System.out.println(imposto.resultado());

        // Iterator
        separador("Iterator — FilaPedidos");
        FilaPedidos fila = new FilaPedidos();
        fila.enfileirar(pedido1);
        fila.enfileirar(pedido2);
        fila.enfileirar(pedido3);
        for (Pedido p : fila) {
            System.out.println("   • " + p);
        }

        // Facade
        separador("Facade — Hamburgueria");
        Hamburgueria loja = new Hamburgueria(new CobrancaPix());
        loja.definirRegraDesconto(new DescontoFidelidade());
        Pedido pedidoFinal = loja.abrirPedido(new Cliente("Gabi", true));
        loja.adicionarItem(pedidoFinal, loja.montarCombo(new ComboVeggieMontador()));
        loja.desfazerUltimaAcao();
        loja.adicionarItem(pedidoFinal, loja.montarCombo(new ComboPremiumMontador()));
        loja.processar(pedidoFinal);
        loja.cobrar(pedidoFinal);
        loja.despacharEntrega(pedidoFinal, "Av. Brasil, 500");
        loja.exibirFila();

        separador("FIM");
    }

    private static void separador(String titulo) {
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("  " + titulo);
        System.out.println("══════════════════════════════════════════════════");
    }
}
