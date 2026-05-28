package com.hamburgueria.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lanche implements ItemCardapio {

    private final String nome;
    private final double precoBase;
    private final List<Ingrediente> ingredientes;

    public Lanche(String nome, double precoBase, List<Ingrediente> ingredientes) {
        this.nome = nome;
        this.precoBase = precoBase;
        this.ingredientes = new ArrayList<>(ingredientes);
    }

    @Override public String getNome() { return nome; }

    @Override
    public double getPreco() {
        return precoBase + ingredientes.stream()
                .mapToDouble(Ingrediente::getPrecoPorcao).sum();
    }

    @Override
    public void aceitar(CalculadorItem calculador) {
        calculador.calcular(this);
    }

    public List<Ingrediente> getIngredientes() {
        return Collections.unmodifiableList(ingredientes);
    }

    @Override
    public String toString() {
        return String.format("Lanche(%s | R$%.2f)", nome, getPreco());
    }
}
