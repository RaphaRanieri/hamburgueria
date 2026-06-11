package com.hamburgueria.cozinha;

import com.hamburgueria.model.ItemCardapio;

import java.util.List;

public class AcessoCozinha {

    private final CozinhaService cozinha = new CozinhaService();
    private final boolean perfilAdmin;

    public AcessoCozinha(boolean perfilAdmin) {
        this.perfilAdmin = perfilAdmin;
    }

    public String iniciarPreparo(int pedidoId, List<ItemCardapio> itens) {
        return cozinha.iniciarPreparo(pedidoId, itens);
    }

    public String cancelarPreparo(int pedidoId) {
        if (!perfilAdmin) {
            return "[Acesso negado] Somente administradores podem cancelar.";
        }
        return cozinha.cancelarPreparo(pedidoId);
    }
}
