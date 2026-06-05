package com.hamburgueria.pagamento;

public class CobrancaPix implements GatewayCobranca {
    @Override
    public String cobrar(double valor, String descricao) {
        return String.format("[PIX] R$%.2f — %s", valor, descricao);
    }
}
