package com.hamburgueria.entrega;

import com.hamburgueria.model.ItemCardapio;

import java.util.List;
import java.util.stream.Collectors;

public class IntegradorEntrega implements ServicoEntrega {

    private final PlataformaLogistica plataforma;

    public IntegradorEntrega(PlataformaLogistica plataforma) {
        this.plataforma = plataforma;
    }

    @Override
    public String despachar(int pedidoId, String endereco, List<ItemCardapio> itens) {
        List<String> nomes = itens.stream()
                .map(ItemCardapio::getNome)
                .collect(Collectors.toList());
        return "Entrega despachada | Código: " + plataforma.dispatchOrder(pedidoId, endereco, nomes);
    }
}
