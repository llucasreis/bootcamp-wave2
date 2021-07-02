package com.bootcamp.grupo4.restaurante.entities;

import com.bootcamp.grupo4.restaurante.utils.DataUtil;

public class Caixa {
    private Long id;
    private double valor;
    private String data;

    public Caixa(Long id) {
        this.id = id;
        this.valor = 0.0;
        this.data = DataUtil.getDataAtual();
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
