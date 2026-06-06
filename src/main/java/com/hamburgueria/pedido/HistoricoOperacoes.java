package com.hamburgueria.pedido;

import java.util.ArrayDeque;
import java.util.Deque;

public class HistoricoOperacoes {

    private final Deque<Operacao> pilha = new ArrayDeque<>();

    public void executar(Operacao op) {
        op.executar();
        pilha.push(op);
    }

    public void desfazer() {
        if (pilha.isEmpty()) {
            System.out.println("  Nada para desfazer.");
            return;
        }
        pilha.pop().desfazer();
    }

    public boolean temHistorico() { return !pilha.isEmpty(); }
}
