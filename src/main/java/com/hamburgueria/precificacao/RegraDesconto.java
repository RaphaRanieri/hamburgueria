package com.hamburgueria.precificacao;

public interface RegraDesconto {
    double aplicar(double totalBruto);
    String descricao();
}
