package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public class VerificacaoItens extends EtapaProcessamento {

    @Override
    protected boolean executar(Pedido pedido) {
        if (pedido.getItens().isEmpty()) {
            System.out.println("  [Itens] Pedido vazio — rejeitado.");
            return false;
        }
        System.out.println("  [Itens] Itens verificados ✓");
        return true;
    }
}
