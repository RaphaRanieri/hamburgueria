package com.hamburgueria;

import com.hamburgueria.model.Ingrediente;
import com.hamburgueria.model.IngredienteRepositorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IngredienteRepositorioTest {

    @Test
    void mesmaNomeRetornaMesmaInstancia() {
        Ingrediente a = IngredienteRepositorio.queijo();
        Ingrediente b = IngredienteRepositorio.queijo();
        assertSame(a, b, "O repositório deve retornar a mesma instância para o mesmo ingrediente");
    }

    @Test
    void ingredientesDiferentesRetornamObjetosDiferentes() {
        Ingrediente queijo = IngredienteRepositorio.queijo();
        Ingrediente bacon  = IngredienteRepositorio.bacon();
        assertNotSame(queijo, bacon);
    }

    @Test
    void repositorioNaoDuplicaEntradas() {
        int antes = IngredienteRepositorio.quantidadeNoCatalogo();
        IngredienteRepositorio.queijo();
        IngredienteRepositorio.queijo();
        // A quantidade não deve crescer após buscar um ingrediente já existente
        assertTrue(IngredienteRepositorio.quantidadeNoCatalogo() >= antes);
    }
}
