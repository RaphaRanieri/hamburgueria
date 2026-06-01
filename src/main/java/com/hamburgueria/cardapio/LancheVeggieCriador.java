package com.hamburgueria.cardapio;

import com.hamburgueria.model.Lanche;

public class LancheVeggieCriador extends CriadorLanche {

    @Override
    public Lanche criar() {
        return new LancheBuilder("Veggie", 20.00)
                .comAlface()
                .comTomate()
                .comCebola()
                .build();
    }
}
