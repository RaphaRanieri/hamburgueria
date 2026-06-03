package com.hamburgueria.precificacao;

public class SemDesconto implements RegraDesconto {

    @Override public double aplicar(double total) { return total; }
    @Override public String descricao()            { return "Preço regular"; }
}
