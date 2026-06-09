package com.hamburgueria.comunicacao;

public class SetorEntrega extends Departamento {

    @Override public String getNome() { return "Entrega"; }

    @Override
    public void receberMensagem(String mensagem, String origem) {
        System.out.println("  [Entrega] ← " + origem + ": " + mensagem);
    }
}
