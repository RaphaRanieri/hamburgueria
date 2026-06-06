package com.hamburgueria.pedido;

import com.hamburgueria.model.ItemCardapio;
import com.hamburgueria.model.Pedido;

public class RemoverItemPedido implements Operacao {

    private final Pedido pedido;
    private final ItemCardapio item;

    public RemoverItemPedido(Pedido pedido, ItemCardapio item) {
        this.pedido = pedido;
        this.item = item;
    }

    @Override public void executar()  { pedido.removerItem(item); }
    @Override public void desfazer()  { pedido.adicionarItem(item); }
}
