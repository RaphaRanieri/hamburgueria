package com.hamburgueria.pagamento;

public abstract class FormaPagamento {

    protected final GatewayCobranca gateway;

    protected FormaPagamento(GatewayCobranca gateway) {
        this.gateway = gateway;
    }

    public abstract String processar(double valor, String descricao);
}
