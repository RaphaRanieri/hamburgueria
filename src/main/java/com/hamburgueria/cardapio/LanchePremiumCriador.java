package com.hamburgueria.cardapio;

import com.hamburgueria.model.Lanche;

public class LanchePremiumCriador extends CriadorLanche {

    @Override
    public Lanche criar() {
        return new LancheBuilder("Premium", 28.00)
                .comQueijo()
                .comQueijo()
                .comBacon()
                .comOvo()
                .comAlface()
                .comTomate()
                .comMolhoEspecial()
                .build();
    }
}
