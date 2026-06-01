package com.hamburgueria.cardapio;

import com.hamburgueria.model.Lanche;

public abstract class CriadorLanche {

    public abstract Lanche criar();

    public Lanche preparar() {
        Lanche lanche = criar();
        System.out.println("  Preparando lanche: " + lanche.getNome());
        return lanche;
    }
}
