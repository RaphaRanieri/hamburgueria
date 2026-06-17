package com.hamburgueria;

import com.hamburgueria.cardapio.*;
import com.hamburgueria.model.Lanche;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CriadorLancheTest {

    @Test
    void classicoTemQueijo() {
        Lanche l = new LancheClassicoCriador().preparar();
        assertTrue(l.getIngredientes().stream()
                .anyMatch(i -> i.getNome().equals("Queijo")));
    }

    @Test
    void veggieSemBacon() {
        Lanche l = new LancheVeggieCriador().preparar();
        assertFalse(l.getIngredientes().stream()
                .anyMatch(i -> i.getNome().equals("Bacon")));
    }

    @Test
    void premiumTemBaconEOvo() {
        Lanche l = new LanchePremiumCriador().preparar();
        assertTrue(l.getIngredientes().stream().anyMatch(i -> i.getNome().equals("Bacon")));
        assertTrue(l.getIngredientes().stream().anyMatch(i -> i.getNome().equals("Ovo")));
    }

    @Test
    void todasAsFabricasRetornamLanche() {
        for (CriadorLanche criador : List.of(
                new LancheClassicoCriador(),
                new LancheVeggieCriador(),
                new LanchePremiumCriador())) {
            assertInstanceOf(Lanche.class, criador.preparar());
        }
    }
}
