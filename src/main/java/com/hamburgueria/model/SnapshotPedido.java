package com.hamburgueria.model;

import java.util.List;

public class SnapshotPedido {

    private final List<ItemCardapio> itens;
    private final StatusPedido status;

    public SnapshotPedido(List<ItemCardapio> itens, StatusPedido status) {
        this.itens = List.copyOf(itens);
        this.status = status;
    }

    public List<ItemCardapio> getItens() { return itens; }
    public StatusPedido getStatus()      { return status; }
}
