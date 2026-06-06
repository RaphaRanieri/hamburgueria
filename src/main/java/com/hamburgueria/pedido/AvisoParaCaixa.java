package com.hamburgueria.pedido;

import com.hamburgueria.model.ListenerPedido;
import com.hamburgueria.model.Pedido;

public class AvisoParaCaixa implements ListenerPedido {

    @Override
    public void onStatusAlterado(Pedido pedido) {
        System.out.printf("  [Painel Caixa] Pedido #%d → %s%n",
                pedido.getId(), pedido.getStatus());
    }
}
