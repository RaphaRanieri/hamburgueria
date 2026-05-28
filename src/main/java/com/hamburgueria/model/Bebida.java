package com.hamburgueria.model;

public class Bebida implements ItemCardapio {

    private final String nome;
    private final double preco;

    public Bebida(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override public String getNome()  { return nome; }
    @Override public double getPreco() { return preco; }

    @Override
    public void aceitar(CalculadorItem calculador) {
        calculador.calcular(this);
    }

    @Override
    public String toString() {
        return String.format("Bebida(%s | R$%.2f)", nome, preco);
    }
}
