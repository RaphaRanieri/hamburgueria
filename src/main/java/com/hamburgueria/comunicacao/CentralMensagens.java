package com.hamburgueria.comunicacao;

import java.util.HashMap;
import java.util.Map;

public class CentralMensagens {

    private final Map<String, Departamento> setores = new HashMap<>();

    public void registrar(Departamento departamento) {
        departamento.vincularCentral(this);
        setores.put(departamento.getNome(), departamento);
    }

    public void enviar(String mensagem, String origem, String destino) {
        Departamento receptor = setores.get(destino);
        if (receptor != null) {
            receptor.receberMensagem(mensagem, origem);
        } else {
            System.out.println("  [Central] Setor '" + destino + "' não encontrado.");
        }
    }
}
