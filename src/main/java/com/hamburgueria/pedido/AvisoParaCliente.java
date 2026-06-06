package com.hamburgueria.pedido;

import com.hamburgueria.model.ListenerPedido;
import com.hamburgueria.model.Pedido;
import com.hamburgueria.model.StatusPedido;

import java.util.Map;

public class AvisoParaCliente implements ListenerPedido {

    private static final Map<StatusPedido, String> MENSAGENS = Map.of(
            StatusPedido.PREPARANDO, "Seu pedido está sendo preparado!",
            StatusPedido.PRONTO,     "Pedido pronto para retirada!",
            StatusPedido.ENTREGUE,   "Pedido entregue. Bom apetite!",
            StatusPedido.CANCELADO,  "Seu pedido foi cancelado."
    );

    @Override
    public void onStatusAlterado(Pedido pedido) {
        String msg = MENSAGENS.get(pedido.getStatus());
        if (msg != null) {
            System.out.printf("  [Notificação → %s] %s%n",
                    pedido.getCliente().getNome(), msg);
        }
    }
}
