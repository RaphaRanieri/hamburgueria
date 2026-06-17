package com.hamburgueria;

import com.hamburgueria.config.RestauranteConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestauranteConfigTest {

    @Test
    void sempreRetornaMesmaInstancia() {
        RestauranteConfig c1 = RestauranteConfig.getInstance();
        RestauranteConfig c2 = RestauranteConfig.getInstance();
        assertSame(c1, c2);
    }

    @Test
    void alteracaoRefleteTodosOsAcessos() {
        RestauranteConfig c1 = RestauranteConfig.getInstance();
        c1.setTaxaServico(0.20);
        RestauranteConfig c2 = RestauranteConfig.getInstance();
        assertEquals(0.20, c2.getTaxaServico(), 0.001);
        c1.setTaxaServico(0.10); // restaura
    }
}
