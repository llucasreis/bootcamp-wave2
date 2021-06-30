package com.bootcamp.grupo4.morse.entities;

// Plain Old Java Object
public class Palavra {
    private String valor;
    private String morse;

    public Palavra() {}

    public Palavra(String valor, String morse) {
        this.valor = valor;
        this.morse = morse;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getMorse() {
        return morse;
    }

    public void setMorse(String morse) {
        this.morse = morse;
    }
}
