package com.hamburgueria.fila;

import com.hamburgueria.model.Pedido;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class FilaPedidos implements Iterable<Pedido> {

    private final List<Pedido> pedidos = new ArrayList<>();

    public void enfileirar(Pedido pedido) {
        pedidos.add(pedido);
        System.out.printf("  [Fila] Pedido #%d enfileirado (%d na fila)%n",
                pedido.getId(), pedidos.size());
    }

    public Pedido desenfileirar() {
        if (pedidos.isEmpty()) throw new NoSuchElementException("Fila vazia.");
        return pedidos.remove(0);
    }

    public int tamanho() { return pedidos.size(); }
    public boolean vazia() { return pedidos.isEmpty(); }

    @Override
    public Iterator<Pedido> iterator() {
        return new Iterator<>() {
            private int indice = 0;

            @Override public boolean hasNext() { return indice < pedidos.size(); }

            @Override
            public Pedido next() {
                if (!hasNext()) throw new NoSuchElementException();
                return pedidos.get(indice++);
            }
        };
    }
}
