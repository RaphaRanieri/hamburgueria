package com.hamburgueria.pagamento;

public class PagamentoSimples extends FormaPagamento {

    public PagamentoSimples(GatewayCobranca gateway) {
        super(gateway);
    }

    @Override
    public String processar(double valor, String descricao) {
        return gateway.cobrar(valor, descricao);
    }
}
