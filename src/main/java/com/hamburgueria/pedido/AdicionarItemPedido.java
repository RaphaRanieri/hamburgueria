package com.hamburgueria.pedido;

import com.hamburgueria.model.ItemCardapio;
import com.hamburgueria.model.Pedido;

public class AdicionarItemPedido implements Operacao {

    private final Pedido pedido;
    private final ItemCardapio item;

    public AdicionarItemPedido(Pedido pedido, ItemCardapio item) {
        this.pedido = pedido;
        this.item = item;
    }

    @Override public void executar()  { pedido.adicionarItem(item); }
    @Override public void desfazer()  { pedido.removerItem(item); }
}
