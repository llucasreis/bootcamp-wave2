package com.bootcamp.grupo4.loja.entities;

import com.bootcamp.grupo4.loja.utils.DataUtil;

import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos;
    private double valorTotal;
    private String data;

    public Pedido(){}

    public Pedido(List<Produto> produtos, double valorTotal) {
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.data = DataUtil.getDataAtual();
    }

    public Pedido(Long id, List<Produto> produtos, double valorTotal, String data) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
