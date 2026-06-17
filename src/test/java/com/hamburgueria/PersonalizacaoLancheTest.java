package com.hamburgueria;

import com.hamburgueria.adicional.*;
import com.hamburgueria.cardapio.LancheClassicoCriador;
import com.hamburgueria.model.ItemCardapio;
import com.hamburgueria.model.Lanche;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonalizacaoLancheTest {

    @Test
    void adicionalQueijoAumentaPreco() {
        Lanche base = new LancheClassicoCriador().criar();
        ItemCardapio comQueijo = new AdicionalQueijo(base);
        assertEquals(base.getPreco() + 2.50, comQueijo.getPreco(), 0.001);
    }

    @Test
    void adicionalBaconAumentaPreco() {
        Lanche base = new LancheClassicoCriador().criar();
        ItemCardapio comBacon = new AdicionalBacon(base);
        assertEquals(base.getPreco() + 3.50, comBacon.getPreco(), 0.001);
    }

    @Test
    void versaoSemGlutenAumentaPreco() {
        Lanche base = new LancheClassicoCriador().criar();
        ItemCardapio sg = new VersaoSemGluten(base);
        assertEquals(base.getPreco() + 3.00, sg.getPreco(), 0.001);
        assertTrue(sg.getNome().contains("sem glúten"));
    }

    @Test
    void decoradoresEmpilham() {
        Lanche base = new LancheClassicoCriador().criar();
        ItemCardapio multi = new VersaoSemGluten(new AdicionalBacon(new AdicionalQueijo(base)));
        double esperado = base.getPreco() + 2.50 + 3.50 + 3.00;
        assertEquals(esperado, multi.getPreco(), 0.001);
    }
}
