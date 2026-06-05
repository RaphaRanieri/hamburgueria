package com.hamburgueria.pagamento;

public class CobrancaCartao implements GatewayCobranca {
    @Override
    public String cobrar(double valor, String descricao) {
        return String.format("[Cartão] R$%.2f — %s", valor, descricao);
    }
}
