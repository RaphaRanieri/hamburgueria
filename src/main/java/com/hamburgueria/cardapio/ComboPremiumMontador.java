package com.hamburgueria.cardapio;

import com.hamburgueria.model.Acompanhamento;
import com.hamburgueria.model.Bebida;
import com.hamburgueria.model.Lanche;

public class ComboPremiumMontador implements MontadorCombo {

    @Override public Lanche criarLanche()           { return new LanchePremiumCriador().criar(); }
    @Override public Bebida criarBebida()           { return new Bebida("Milk Shake", 12.0); }
    @Override public Acompanhamento criarAcompanhamento() { return new Acompanhamento("Batata Frita G", 10.0); }
    @Override public String getNomeCombo()          { return "Combo Premium"; }
    @Override public double getDesconto()           { return 5.0; }
}
