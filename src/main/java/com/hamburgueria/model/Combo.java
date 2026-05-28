package com.hamburgueria.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combo implements ItemCardapio {

    private final String nome;
    private final double desconto;
    private final List<ItemCardapio> itens;

    public Combo(String nome, double desconto) {
        this.nome = nome;
        this.desconto = desconto;
        this.itens = new ArrayList<>();
    }

    public void adicionar(ItemCardapio item) { itens.add(item); }
    public void remover(ItemCardapio item)   { itens.remove(item); }

    public List<ItemCardapio> getItens() {
        return Collections.unmodifiableList(itens);
    }

    @Override public String getNome() { return nome; }

    @Override
    public double getPreco() {
        double total = itens.stream().mapToDouble(ItemCardapio::getPreco).sum();
        return Math.max(0, total - desconto);
    }

    @Override
    public void aceitar(CalculadorItem calculador) {
        calculador.calcular(this);
    }

    @Override
    public String toString() {
        return String.format("Combo(%s | R$%.2f)", nome, getPreco());
    }
}
