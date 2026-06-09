package com.hamburgueria.comunicacao;

public class SetorCozinha extends Departamento {

    @Override public String getNome() { return "Cozinha"; }

    @Override
    public void receberMensagem(String mensagem, String origem) {
        System.out.println("  [Cozinha] ← " + origem + ": " + mensagem);
    }

    public void pedidoPronto(int pedidoId) {
        central.enviar("Pedido #" + pedidoId + " pronto para retirada.", "Cozinha", "Entrega");
        central.enviar("Pedido #" + pedidoId + " pronto para retirada.", "Cozinha", "Cliente");
    }
}
