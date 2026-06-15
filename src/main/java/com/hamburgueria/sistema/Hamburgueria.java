package com.hamburgueria.sistema;

import com.hamburgueria.cardapio.MontadorCombo;
import com.hamburgueria.config.RestauranteConfig;
import com.hamburgueria.entrega.IntegradorEntrega;
import com.hamburgueria.entrega.PlataformaLogistica;
import com.hamburgueria.fila.FilaPedidos;
import com.hamburgueria.fluxo.CadeiaProcessamento;
import com.hamburgueria.fluxo.EtapaProcessamento;
import com.hamburgueria.model.*;
import com.hamburgueria.pagamento.FormaPagamento;
import com.hamburgueria.pagamento.GatewayCobranca;
import com.hamburgueria.pagamento.PagamentoSimples;
import com.hamburgueria.pedido.*;
import com.hamburgueria.precificacao.RegraDesconto;
import com.hamburgueria.precificacao.SemDesconto;

public class Hamburgueria {

    private final RestauranteConfig config;
    private final FilaPedidos fila;
    private final EtapaProcessamento cadeia;
    private final HistoricoOperacoes historico;
    private RegraDesconto regraDesconto;
    private GatewayCobranca gateway;

    public Hamburgueria(GatewayCobranca gateway) {
        this.config        = RestauranteConfig.getInstance();
        this.fila          = new FilaPedidos();
        this.cadeia        = CadeiaProcessamento.montar();
        this.historico     = new HistoricoOperacoes();
        this.regraDesconto = new SemDesconto();
        this.gateway       = gateway;
    }

    public Pedido abrirPedido(Cliente cliente) {
        Pedido pedido = new Pedido(cliente);
        System.out.println("\n>> Novo pedido para " + cliente.getNome());
        return pedido;
    }

    public void adicionarItem(Pedido pedido, ItemCardapio item) {
        historico.executar(new AdicionarItemPedido(pedido, item));
    }

    public void desfazerUltimaAcao() {
        historico.desfazer();
    }

    public Combo montarCombo(MontadorCombo montador) {
        return montador.montar();
    }

    public boolean processar(Pedido pedido) {
        System.out.println("\n>> Processando " + pedido);
        boolean ok = cadeia.processar(pedido);
        if (ok) fila.enfileirar(pedido);
        return ok;
    }

    public void definirRegraDesconto(RegraDesconto regra) {
        this.regraDesconto = regra;
    }

    public String cobrar(Pedido pedido) {
        double valorFinal = regraDesconto.aplicar(pedido.getTotal());
        FormaPagamento pagamento = new PagamentoSimples(gateway);
        String resultado = pagamento.processar(valorFinal,
                "Pedido #" + pedido.getId() + " — " + regraDesconto.descricao());
        System.out.println("  " + resultado);
        return resultado;
    }

    public String despacharEntrega(Pedido pedido, String endereco) {
        IntegradorEntrega entrega = new IntegradorEntrega(new PlataformaLogistica());
        pedido.atualizarStatus(StatusPedido.PRONTO);
        String msg = entrega.despachar(pedido.getId(), endereco, pedido.getItens());
        pedido.atualizarStatus(StatusPedido.ENTREGUE);
        System.out.println("  " + msg);
        return msg;
    }

    public void exibirFila() {
        System.out.printf("%n>> Fila da cozinha (%d pedidos):%n", fila.tamanho());
        for (Pedido p : fila) {
            System.out.println("   • " + p);
        }
    }

    public RestauranteConfig getConfig() { return config; }
    public FilaPedidos getFila()         { return fila; }
}
