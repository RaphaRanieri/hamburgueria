package com.hamburgueria.model;

public interface CalculadorItem {
    void calcular(Lanche lanche);
    void calcular(Bebida bebida);
    void calcular(Acompanhamento acompanhamento);
    void calcular(Combo combo);
}
