package com.hamburgueria.cardapio;

import com.hamburgueria.model.Acompanhamento;
import com.hamburgueria.model.Bebida;
import com.hamburgueria.model.Lanche;

public class ComboVeggieMontador implements MontadorCombo {

    @Override public Lanche criarLanche()           { return new LancheVeggieCriador().criar(); }
    @Override public Bebida criarBebida()           { return new Bebida("Suco Natural", 8.0); }
    @Override public Acompanhamento criarAcompanhamento() { return new Acompanhamento("Salada", 6.0); }
    @Override public String getNomeCombo()          { return "Combo Veggie"; }
    @Override public double getDesconto()           { return 2.0; }
}
