package com.hamburgueria.cardapio;

import com.hamburgueria.model.Lanche;

public class LancheClassicoCriador extends CriadorLanche {

    @Override
    public Lanche criar() {
        return new LancheBuilder("Clássico", 18.00)
                .comQueijo()
                .comAlface()
                .comTomate()
                .comMolhoEspecial()
                .build();
    }
}
