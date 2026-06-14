package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public abstract class FluxoAtendimento {

    public final void atender(Pedido pedido) {
        registrar(pedido);
        confirmarDados(pedido);
        processarCobranca(pedido);
        encaminharParaProducao(pedido);
        concluir(pedido);
    }

    protected void registrar(Pedido pedido) {
        System.out.println("  [Atendimento] Registrando: " + pedido);
    }

    protected abstract void confirmarDados(Pedido pedido);
    protected abstract void processarCobranca(Pedido pedido);

    protected void encaminharParaProducao(Pedido pedido) {
        System.out.println("  [Atendimento] Encaminhando para a cozinha…");
    }

    protected void concluir(Pedido pedido) {
        System.out.printf("  [Atendimento] Pedido #%d finalizado.%n", pedido.getId());
    }
}
