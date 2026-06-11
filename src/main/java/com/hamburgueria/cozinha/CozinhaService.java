package com.hamburgueria.cozinha;

import com.hamburgueria.model.ItemCardapio;

import java.util.List;
import java.util.stream.Collectors;

public class CozinhaService {

    public String iniciarPreparo(int pedidoId, List<ItemCardapio> itens) {
        String nomes = itens.stream().map(ItemCardapio::getNome).collect(Collectors.joining(", "));
        return String.format("[Cozinha] Preparando Pedido #%d: %s", pedidoId, nomes);
    }

    public String cancelarPreparo(int pedidoId) {
        return String.format("[Cozinha] Pedido #%d cancelado.", pedidoId);
    }
}
