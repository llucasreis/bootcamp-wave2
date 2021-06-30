package com.bootcamp.grupo4.productapi.entities;

public class Product {
    private Long id;
    private String nome;
    private int quantidade;

    public Product() {
    }

    public Product(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Product(Long id, String nome, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
