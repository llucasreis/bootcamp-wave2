package com.bootcamp.grupo4.linktracker.dtos;

import com.bootcamp.grupo4.linktracker.entities.Link;

public class LinkMetricDTO {
    private Long id;
    private int quantidadeRedirects;
    private boolean valido;

    public LinkMetricDTO() {
    }

    public LinkMetricDTO(Long id, int quantidadeRedirects, boolean valido) {
        this.id = id;
        this.quantidadeRedirects = quantidadeRedirects;
        this.valido = valido;
    }

    public static LinkMetricDTO converter(Link link) {
        return new LinkMetricDTO(
                link.getId(),
                link.getQuantidadeRedirects(),
                link.isValido()
        );
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
