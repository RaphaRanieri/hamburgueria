package com.hamburgueria.pagamento;

public interface GatewayCobranca {
    String cobrar(double valor, String descricao);
}
