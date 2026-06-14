package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public class AtendimentoPresencial extends FluxoAtendimento {

    @Override
    protected void confirmarDados(Pedido pedido) {
        System.out.println("  [Presencial] Dados confirmados no balcão.");
    }

    @Override
    protected void processarCobranca(Pedido pedido) {
        System.out.printf("  [Presencial] Cobrando R$%.2f no caixa.%n", pedido.getTotal());
    }
}
