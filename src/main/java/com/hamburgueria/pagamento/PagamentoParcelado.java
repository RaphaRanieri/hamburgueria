package com.hamburgueria.pagamento;

public class PagamentoParcelado extends FormaPagamento {

    private final int parcelas;

    public PagamentoParcelado(GatewayCobranca gateway, int parcelas) {
        super(gateway);
        this.parcelas = parcelas;
    }

    @Override
    public String processar(double valor, String descricao) {
        double valorParcela = valor / parcelas;
        String desc = String.format("%s em %dx de R$%.2f", descricao, parcelas, valorParcela);
        return gateway.cobrar(valor, desc);
    }
}
