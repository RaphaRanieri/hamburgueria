package com.hamburgueria;

import com.hamburgueria.cardapio.LancheBuilder;
import com.hamburgueria.model.Lanche;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LancheBuilderTest {

    @Test
    void lancheSemIngredientesTemPrecoBase() {
        Lanche l = new LancheBuilder("Simples", 10.0).build();
        assertEquals(10.0, l.getPreco(), 0.001);
        assertEquals("Simples", l.getNome());
    }

    @Test
    void ingredientesAcumulamPreco() {
        Lanche l = new LancheBuilder("Teste", 10.0)
                .comQueijo()  // +1.50
                .comBacon()   // +2.50
                .build();
        assertEquals(14.0, l.getPreco(), 0.001);
    }

    @Test
    void queijoEBaconSaoCompartilhados() {
        Lanche l1 = new LancheBuilder("A", 10.0).comQueijo().build();
        Lanche l2 = new LancheBuilder("B", 10.0).comQueijo().build();
        assertSame(l1.getIngredientes().get(0), l2.getIngredientes().get(0),
                "Flyweight: queijo deve ser o mesmo objeto");
    }

    @Test
    void fluentInterfaceRetornaBuilder() {
        LancheBuilder builder = new LancheBuilder("x", 5.0);
        assertSame(builder, builder.comQueijo());
    }
}
