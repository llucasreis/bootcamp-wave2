package com.bootcamp.grupo4.loja.entities;

import java.util.List;

public class Pedido {
    private Long id;
    private List<Produto> produtos;
    private double valorTotal;

    public Pedido(){}

    public Pedido(List<Produto> produtos, double valorTotal) {
        this.produtos = produtos;
        this.valorTotal = valorTotal;
    }

    public Pedido(Long id, List<Produto> produtos, double valorTotal) {
        this.id = id;
        this.produtos = produtos;
        this.valorTotal = valorTotal;
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
}
