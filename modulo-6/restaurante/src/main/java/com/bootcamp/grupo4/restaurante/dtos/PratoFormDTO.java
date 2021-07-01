package com.bootcamp.grupo4.restaurante.dtos;

public class PratoFormDTO {
    private double preco;
    private String descricao;
    private int quantidade;

    public PratoFormDTO(double preco, String descricao, int quantidade) {
        this.preco = preco;
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
