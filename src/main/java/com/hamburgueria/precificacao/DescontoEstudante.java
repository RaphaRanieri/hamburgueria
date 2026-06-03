package com.hamburgueria.precificacao;

public class DescontoEstudante implements RegraDesconto {

    @Override public double aplicar(double total) { return total * 0.90; }
    @Override public String descricao()            { return "Desconto estudante 10%"; }
}
