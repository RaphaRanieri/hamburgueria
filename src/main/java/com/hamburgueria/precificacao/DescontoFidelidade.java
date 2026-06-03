package com.hamburgueria.precificacao;

public class DescontoFidelidade implements RegraDesconto {

    @Override public double aplicar(double total) { return total * 0.85; }
    @Override public String descricao()            { return "Desconto fidelidade 15%"; }
}
