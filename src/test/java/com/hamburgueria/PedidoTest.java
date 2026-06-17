package com.hamburgueria;

import com.hamburgueria.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido novoPedido() {
        return new Pedido(new Cliente("Teste"));
    }

    @Test
    void statusInicialERecebido() {
        assertEquals(StatusPedido.RECEBIDO, novoPedido().getStatus());
    }

    @Test
    void transicaoValidaMudaStatus() {
        Pedido p = novoPedido();
        p.atualizarStatus(StatusPedido.PREPARANDO);
        assertEquals(StatusPedido.PREPARANDO, p.getStatus());
    }

    @Test
    void transicaoInvalidaLancaExcecao() {
        Pedido p = novoPedido();
        assertThrows(IllegalStateException.class,
                () -> p.atualizarStatus(StatusPedido.ENTREGUE));
    }

    @Test
    void listenerNotificadoNaMudancaDeStatus() {
        List<StatusPedido> recebidos = new ArrayList<>();
        Pedido p = novoPedido();
        p.adicionarListener(pedido -> recebidos.add(pedido.getStatus()));
        p.atualizarStatus(StatusPedido.PREPARANDO);
        assertEquals(1, recebidos.size());
        assertEquals(StatusPedido.PREPARANDO, recebidos.get(0));
    }

    @Test
    void snapshotRestauraNumerDeItens() {
        Pedido p = novoPedido();
        p.adicionarItem(new Bebida("Refri", 5.0));
        p.salvarEstado();
        p.adicionarItem(new Bebida("Suco", 8.0));
        assertEquals(2, p.getItens().size());
        p.restaurarEstado();
        assertEquals(1, p.getItens().size());
    }

    @Test
    void totalDosPedidosSomadoCorretamente() {
        Pedido p = novoPedido();
        p.adicionarItem(new Bebida("A", 5.0));
        p.adicionarItem(new Acompanhamento("B", 8.0));
        assertEquals(13.0, p.getTotal(), 0.001);
    }
}
