package com.hamburgueria.model;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.NoSuchElementException;

public class Pedido {

    private static int sequencia = 0;

    private final int id;
    private final Cliente cliente;
    private List<ItemCardapio> itens;
    private StatusPedido status;
    private final List<ListenerPedido> listeners;
    private final Deque<SnapshotPedido> snapshots;

    public Pedido(Cliente cliente) {
        this.id = ++sequencia;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.status = StatusPedido.RECEBIDO;
        this.listeners = new ArrayList<>();
        this.snapshots = new ArrayDeque<>();
    }

    public void adicionarListener(ListenerPedido listener) {
        listeners.add(listener);
    }

    private void notificarListeners() {
        listeners.forEach(l -> l.onStatusAlterado(this));
    }

    public void atualizarStatus(StatusPedido novoStatus) {
        if (!status.proximosPermitidos().contains(novoStatus)) {
            throw new IllegalStateException(
                    "Transição inválida: " + status + " → " + novoStatus);
        }
        this.status = novoStatus;
        notificarListeners();
    }

    public void salvarEstado() {
        snapshots.push(new SnapshotPedido(itens, status));
    }

    public void restaurarEstado() {
        if (snapshots.isEmpty()) throw new NoSuchElementException("Sem snapshots salvos.");
        SnapshotPedido snap = snapshots.pop();
        this.itens = new ArrayList<>(snap.getItens());
        this.status = snap.getStatus();
    }

    public void adicionarItem(ItemCardapio item) { itens.add(item); }
    public void removerItem(ItemCardapio item)    { itens.remove(item); }

    public double getTotal() {
        return itens.stream().mapToDouble(ItemCardapio::getPreco).sum();
    }

    public int getId()                    { return id; }
    public Cliente getCliente()           { return cliente; }
    public StatusPedido getStatus()       { return status; }
    public List<ItemCardapio> getItens()  { return Collections.unmodifiableList(itens); }

    @Override
    public String toString() {
        return String.format("Pedido#%d[%s | %s | R$%.2f]",
                id, cliente.getNome(), status, getTotal());
    }
}
