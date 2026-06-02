package com.hamburgueria.calculo;

import com.hamburgueria.config.RestauranteConfig;
import com.hamburgueria.model.*;

public class TotalizadorImposto implements CalculadorItem {

    private double base = 0.0;

    @Override public void calcular(Lanche l)        { base += l.getPreco(); }
    @Override public void calcular(Bebida b)         { base += b.getPreco(); }
    @Override public void calcular(Acompanhamento a) { base += a.getPreco(); }

    @Override
    public void calcular(Combo combo) {
        combo.getItens().forEach(item -> item.aceitar(this));
    }

    public String resultado() {
        double aliquota = RestauranteConfig.getInstance().getAliquotaImposto();
        return String.format("Imposto (%.0f%%): R$%.2f", aliquota * 100, base * aliquota);
    }
}
