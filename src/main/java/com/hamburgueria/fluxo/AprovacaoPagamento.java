package com.hamburgueria.fluxo;

import com.hamburgueria.model.Pedido;

public class AprovacaoPagamento extends EtapaProcessamento {

    @Override
    protected boolean executar(Pedido pedido) {
        System.out.println("  [Pagamento] Aprovado ✓");
        return true;
    }
}
