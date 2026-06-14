package com.hamburgueria.fluxo;

public class CadeiaProcessamento {

    public static EtapaProcessamento montar() {
        EtapaProcessamento inicio = new VerificacaoItens();
        inicio.definirProxima(new VerificacaoEstoque())
              .definirProxima(new AprovacaoPagamento())
              .definirProxima(new EnvioParaCozinha());
        return inicio;
    }
}
