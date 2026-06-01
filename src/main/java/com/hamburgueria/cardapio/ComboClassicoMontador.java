package com.hamburgueria.cardapio;

import com.hamburgueria.model.Acompanhamento;
import com.hamburgueria.model.Bebida;
import com.hamburgueria.model.Lanche;

public class ComboClassicoMontador implements MontadorCombo {

    @Override public Lanche criarLanche()           { return new LancheClassicoCriador().criar(); }
    @Override public Bebida criarBebida()           { return new Bebida("Refri 350ml", 6.0); }
    @Override public Acompanhamento criarAcompanhamento() { return new Acompanhamento("Batata Frita P", 8.0); }
    @Override public String getNomeCombo()          { return "Combo Clássico"; }
    @Override public double getDesconto()           { return 3.0; }
}
