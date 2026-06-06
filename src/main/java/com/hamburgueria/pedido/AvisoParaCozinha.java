package com.hamburgueria.pedido;

import com.hamburgueria.model.ListenerPedido;
import com.hamburgueria.model.Pedido;
import com.hamburgueria.model.StatusPedido;

public class AvisoParaCozinha implements ListenerPedido {

    @Override
    public void onStatusAlterado(Pedido pedido) {
        if (pedido.getStatus() == StatusPedido.PREPARANDO) {
            System.out.println("  [Cozinha] Iniciando preparo do Pedido #" + pedido.getId());
        } else if (pedido.getStatus() == StatusPedido.CANCELADO) {
            System.out.println("  [Cozinha] Pedido #" + pedido.getId() + " cancelado — descartando.");
        }
    }
}
