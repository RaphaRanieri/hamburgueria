package com.hamburgueria.adicional;

import com.hamburgueria.model.CalculadorItem;
import com.hamburgueria.model.ItemCardapio;

public abstract class PersonalizacaoLanche implements ItemCardapio {

    protected final ItemCardapio base;

    protected PersonalizacaoLanche(ItemCardapio base) {
        this.base = base;
    }

    @Override public String getNome()    { return base.getNome(); }
    @Override public double getPreco()   { return base.getPreco(); }

    @Override
    public void aceitar(CalculadorItem calculador) {
        base.aceitar(calculador);
    }
}
