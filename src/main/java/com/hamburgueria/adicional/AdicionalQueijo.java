package com.hamburgueria.adicional;

import com.hamburgueria.model.ItemCardapio;

public class AdicionalQueijo extends PersonalizacaoLanche {

    public AdicionalQueijo(ItemCardapio base) {
        super(base);
    }

    @Override public String getNome()  { return base.getNome() + " + Queijo Extra"; }
    @Override public double getPreco() { return base.getPreco() + 2.50; }
}
