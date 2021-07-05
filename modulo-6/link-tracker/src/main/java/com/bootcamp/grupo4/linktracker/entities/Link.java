package com.bootcamp.grupo4.linktracker.entities;

public class Link {
    private Long id;
    private String url;
    private int quantidadeRedirects;
    private boolean valido;
    private String senha;

    public Link() {
    }

    public Link(String url, int quantidadeRedirects, boolean valido, String senha) {
        this.url = url;
        this.quantidadeRedirects = quantidadeRedirects;
        this.valido = valido;
        this.senha = senha;
    }

    public Link(Long id, String url, int quantidadeRedirects, boolean valido, String senha) {
        this.id = id;
        this.url = url;
        this.quantidadeRedirects = quantidadeRedirects;
        this.valido = valido;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getQuantidadeRedirects() {
        return quantidadeRedirects;
    }

    public void setQuantidadeRedirects(int quantidadeRedirects) {
        this.quantidadeRedirects = quantidadeRedirects;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
