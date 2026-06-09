package com.hamburgueria.comunicacao;

public class SetorCaixa extends Departamento {

    @Override public String getNome() { return "Caixa"; }

    @Override
    public void receberMensagem(String mensagem, String origem) {
        System.out.println("  [Caixa] ← " + origem + ": " + mensagem);
    }

    public void confirmarPagamento(int pedidoId) {
        central.enviar("Pagamento do Pedido #" + pedidoId + " confirmado.", "Caixa", "Cozinha");
        central.enviar("Pagamento do Pedido #" + pedidoId + " confirmado.", "Caixa", "Cliente");
    }
}
