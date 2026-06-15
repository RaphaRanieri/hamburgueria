package com.hamburgueria.config;

public class RestauranteConfig {

    private static RestauranteConfig instancia;

    private String nomeRestaurante;
    private double taxaServico;
    private double aliquotaImposto;
    private int capacidadeMaximaFila;

    private RestauranteConfig() {
        nomeRestaurante      = "Hamburguer do Seu Zé";
        taxaServico          = 0.10;
        aliquotaImposto      = 0.12;
        capacidadeMaximaFila = 20;
    }

    public static RestauranteConfig getInstance() {
        if (instancia == null) {
            instancia = new RestauranteConfig();
        }
        return instancia;
    }

    public String getNomeRestaurante()    { return nomeRestaurante; }
    public double getTaxaServico()        { return taxaServico; }
    public double getAliquotaImposto()    { return aliquotaImposto; }
    public int getCapacidadeMaximaFila()  { return capacidadeMaximaFila; }

    public void setTaxaServico(double taxa)             { this.taxaServico = taxa; }
    public void setAliquotaImposto(double aliquota)     { this.aliquotaImposto = aliquota; }
    public void setCapacidadeMaximaFila(int capacidade) { this.capacidadeMaximaFila = capacidade; }

    static void resetar() { instancia = null; }
}
