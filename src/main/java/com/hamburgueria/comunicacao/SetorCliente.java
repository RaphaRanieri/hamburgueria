package com.hamburgueria.comunicacao;

public class SetorCliente extends Departamento {

    @Override public String getNome() { return "Cliente"; }

    @Override
    public void receberMensagem(String mensagem, String origem) {
        System.out.println("  [Cliente] ← " + origem + ": " + mensagem);
    }
}
