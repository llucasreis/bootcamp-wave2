package com.bootcamp.grupo4.linktracker.dtos;

import com.bootcamp.grupo4.linktracker.entities.Link;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotBlank;

public class LinkFormDTO {

    @URL
    @NotBlank
    private String url;

    private String senha;

    public LinkFormDTO() {
    }

    public LinkFormDTO(String url, String senha) {
        this.url = url;
        this.senha = senha;
    }

    public Link converter() {
        this.senha = this.senha == null ? "" : this.senha;
        return new Link(this.url, 0, true, this.senha);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
