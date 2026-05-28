package com.hamburgueria.model;

import java.util.Collections;
import java.util.Set;

public enum StatusPedido {

    RECEBIDO {
        @Override public Set<StatusPedido> proximosPermitidos() {
            return Set.of(PREPARANDO, CANCELADO);
        }
    },
    PREPARANDO {
        @Override public Set<StatusPedido> proximosPermitidos() {
            return Set.of(PRONTO, CANCELADO);
        }
    },
    PRONTO {
        @Override public Set<StatusPedido> proximosPermitidos() {
            return Set.of(ENTREGUE);
        }
    },
    ENTREGUE {
        @Override public Set<StatusPedido> proximosPermitidos() {
            return Collections.emptySet();
        }
    },
    CANCELADO {
        @Override public Set<StatusPedido> proximosPermitidos() {
            return Collections.emptySet();
        }
    };

    public abstract Set<StatusPedido> proximosPermitidos();
}
