package com.hamburgueria.comunicacao;

public abstract class Departamento {

    protected CentralMensagens central;

    public void vincularCentral(CentralMensagens central) {
        this.central = central;
    }

    public abstract String getNome();
    public abstract void receberMensagem(String mensagem, String origem);
}
