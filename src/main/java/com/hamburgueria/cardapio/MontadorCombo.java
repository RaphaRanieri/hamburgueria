package com.hamburgueria.cardapio;

import com.hamburgueria.model.Acompanhamento;
import com.hamburgueria.model.Bebida;
import com.hamburgueria.model.Combo;
import com.hamburgueria.model.Lanche;

public interface MontadorCombo {

    Lanche criarLanche();
    Bebida criarBebida();
    Acompanhamento criarAcompanhamento();

    default Combo montar() {
        Combo combo = new Combo(getNomeCombo(), getDesconto());
        combo.adicionar(criarLanche());
        combo.adicionar(criarBebida());
        combo.adicionar(criarAcompanhamento());
        return combo;
    }

    String getNomeCombo();
    double getDesconto();
}
