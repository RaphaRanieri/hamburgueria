package com.hamburgueria.adicional;

import com.hamburgueria.model.ItemCardapio;

public class AdicionalBacon extends PersonalizacaoLanche {

    public AdicionalBacon(ItemCardapio base) {
        super(base);
    }

    @Override public String getNome()  { return base.getNome() + " + Bacon Extra"; }
    @Override public double getPreco() { return base.getPreco() + 3.50; }
}
