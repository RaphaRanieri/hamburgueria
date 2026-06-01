package com.hamburgueria.cardapio;

import com.hamburgueria.model.Ingrediente;
import com.hamburgueria.model.IngredienteRepositorio;
import com.hamburgueria.model.Lanche;

import java.util.ArrayList;
import java.util.List;

public class LancheBuilder {

    private final String nome;
    private final double precoBase;
    private final List<Ingrediente> ingredientes = new ArrayList<>();

    public LancheBuilder(String nome, double precoBase) {
        this.nome = nome;
        this.precoBase = precoBase;
    }

    public LancheBuilder comQueijo()        { ingredientes.add(IngredienteRepositorio.queijo());        return this; }
    public LancheBuilder comBacon()         { ingredientes.add(IngredienteRepositorio.bacon());         return this; }
    public LancheBuilder comAlface()        { ingredientes.add(IngredienteRepositorio.alface());        return this; }
    public LancheBuilder comTomate()        { ingredientes.add(IngredienteRepositorio.tomate());        return this; }
    public LancheBuilder comCebola()        { ingredientes.add(IngredienteRepositorio.cebola());        return this; }
    public LancheBuilder comOvo()           { ingredientes.add(IngredienteRepositorio.ovo());           return this; }
    public LancheBuilder comMolhoEspecial() { ingredientes.add(IngredienteRepositorio.molhoEspecial()); return this; }

    public LancheBuilder comIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
        return this;
    }

    public Lanche build() {
        return new Lanche(nome, precoBase, ingredientes);
    }
}
