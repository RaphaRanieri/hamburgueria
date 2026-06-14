package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;
import com.hamburgueria.model.StatusPedido;

public class EnvioParaCozinha extends EtapaProcessamento {

    @Override
    protected boolean executar(Pedido pedido) {
        pedido.atualizarStatus(StatusPedido.PREPARANDO);
        System.out.println("  [Cozinha] Pedido enviado para preparo ✓");
        return true;
    }
}
