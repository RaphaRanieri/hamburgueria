package com.hamburgueria.model;

public class Cliente {

    private final String nome;
    private final boolean fiel;
    private int pontos;

    public Cliente(String nome, boolean fiel) {
        this.nome = nome;
        this.fiel = fiel;
        this.pontos = 0;
    }

    public Cliente(String nome) { this(nome, false); }

    public String getNome()  { return nome; }
    public boolean isFiel()  { return fiel; }
    public int getPontos()   { return pontos; }
    public void addPontos(int p) { this.pontos += p; }

    @Override
    public String toString() {
        return String.format("Cliente(%s%s)", nome, fiel ? ", fiel" : "");
    }
}
