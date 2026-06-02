package com.hamburgueria.calculo;

import com.hamburgueria.model.*;

public class TotalizadorPreco implements CalculadorItem {

    private double total = 0.0;

    @Override public void calcular(Lanche l)        { total += l.getPreco(); }
    @Override public void calcular(Bebida b)         { total += b.getPreco(); }
    @Override public void calcular(Acompanhamento a) { total += a.getPreco(); }

    @Override
    public void calcular(Combo combo) {
        combo.getItens().forEach(item -> item.aceitar(this));
    }

    public double getTotal() { return total; }

    public String resultado() {
        return String.format("Preço total: R$%.2f", total);
    }
}
