package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public abstract class EtapaProcessamento {

    private EtapaProcessamento proxima;

    public EtapaProcessamento definirProxima(EtapaProcessamento proxima) {
        this.proxima = proxima;
        return proxima;
    }

    public final boolean processar(Pedido pedido) {
        if (!executar(pedido)) return false;
        return (proxima == null) || proxima.processar(pedido);
    }

    protected abstract boolean executar(Pedido pedido);
}
