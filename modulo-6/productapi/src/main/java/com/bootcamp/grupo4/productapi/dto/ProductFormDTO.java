package com.bootcamp.grupo4.productapi.dto;

import com.bootcamp.grupo4.productapi.entities.Product;

public class ProductFormDTO {
    public String nome;
    public int quantidade;

    public ProductFormDTO() {
    }

    public ProductFormDTO(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Product convert() {
        return new Product(this.nome, this.quantidade);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
