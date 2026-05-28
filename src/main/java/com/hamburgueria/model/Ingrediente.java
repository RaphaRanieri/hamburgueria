package com.hamburgueria.model;

public class Ingrediente {

    private final String nome;
    private final int calorias;
    private final double precoPorcao;

    Ingrediente(String nome, int calorias, double precoPorcao) {
        this.nome = nome;
        this.calorias = calorias;
        this.precoPorcao = precoPorcao;
    }

    public String getNome()        { return nome; }
    public int getCalorias()       { return calorias; }
    public double getPrecoPorcao() { return precoPorcao; }

    @Override
    public String toString() { return nome; }
}
