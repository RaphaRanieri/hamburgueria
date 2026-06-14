package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public class VerificacaoEstoque extends EtapaProcessamento {

    @Override
    protected boolean executar(Pedido pedido) {
        System.out.println("  [Estoque] Ingredientes disponíveis ✓");
        return true;
    }
}
