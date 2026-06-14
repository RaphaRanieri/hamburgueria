package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public class AtendimentoDelivery extends FluxoAtendimento {

    @Override
    protected void confirmarDados(Pedido pedido) {
        System.out.println("  [Delivery] Endereço e telefone confirmados.");
    }

    @Override
    protected void processarCobranca(Pedido pedido) {
        System.out.printf("  [Delivery] Cobrando R$%.2f online.%n", pedido.getTotal());
    }
}
