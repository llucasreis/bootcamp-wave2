package com.bootcamp.grupo4.linktracker.dtos;

import com.bootcamp.grupo4.linktracker.entities.Link;

public class LinkDTO {
    private Long linkId;
    private String url;
    private int quantidadeRedirects;
    private boolean valido;

    public LinkDTO() {
    }

    public LinkDTO(Long linkId, String url, int quantidadeRedirects, boolean valido) {
        this.linkId = linkId;
        this.url = url;
        this.quantidadeRedirects = quantidadeRedirects;
        this.valido = valido;
    }

    public static LinkDTO converter(Link link) {
        return new LinkDTO(
                link.getId(),
                link.getUrl(),
                link.getQuantidadeRedirects(),
                link.isValido()
        );
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
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
}
