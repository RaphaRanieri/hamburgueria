package com.hamburgueria.model;

import java.util.HashMap;
import java.util.Map;

public class IngredienteRepositorio {

    private static final Map<String, Ingrediente> catalogo = new HashMap<>();

    private IngredienteRepositorio() {}

    public static Ingrediente buscar(String nome, int calorias, double precoPorcao) {
        return catalogo.computeIfAbsent(nome,
                k -> new Ingrediente(nome, calorias, precoPorcao));
    }

    public static int quantidadeNoCatalogo() {
        return catalogo.size();
    }

    public static Ingrediente queijo()       { return buscar("Queijo",        80, 1.50); }
    public static Ingrediente bacon()        { return buscar("Bacon",        120, 2.50); }
    public static Ingrediente alface()       { return buscar("Alface",        10, 0.50); }
    public static Ingrediente tomate()       { return buscar("Tomate",        20, 0.50); }
    public static Ingrediente cebola()       { return buscar("Cebola",        15, 0.50); }
    public static Ingrediente ovo()          { return buscar("Ovo",           90, 2.00); }
    public static Ingrediente molhoEspecial(){ return buscar("Molho Especial",60, 1.00); }
}
