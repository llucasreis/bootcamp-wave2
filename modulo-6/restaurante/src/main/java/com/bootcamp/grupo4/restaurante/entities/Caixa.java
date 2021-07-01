package com.bootcamp.grupo4.restaurante.entities;

public class Caixa {
    private Long id;
    private double valor;

    public Caixa(Long id) {
        this.id = id;
        this.valor = 0.0;
    }

    public Caixa(Long id, double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
