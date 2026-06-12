package com.hamburgueria.entrega;

import com.hamburgueria.model.ItemCardapio;

import java.util.List;

public interface ServicoEntrega {
    String despachar(int pedidoId, String endereco, List<ItemCardapio> itens);
}
