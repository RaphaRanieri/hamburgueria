package com.hamburgueria.adicional;

import com.hamburgueria.model.ItemCardapio;

public class VersaoSemGluten extends PersonalizacaoLanche {

    public VersaoSemGluten(ItemCardapio base) {
        super(base);
    }

    @Override public String getNome()  { return base.getNome() + " (sem glúten)"; }
    @Override public double getPreco() { return base.getPreco() + 3.00; }
}
