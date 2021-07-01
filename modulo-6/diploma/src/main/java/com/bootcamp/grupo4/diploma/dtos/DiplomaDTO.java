package com.bootcamp.grupo4.diploma.dtos;

public class DiplomaDTO {
    private String mensagem;
    private double media;
    private String aluno;

    public DiplomaDTO(double media, String aluno) {
        this.media = media;
        this.aluno = aluno;
        this.mensagem = geraMensagem();
    }

    private String geraMensagem() {
        String mensagem = "";
        if (this.media >= 7.0) {
            mensagem += "Aprovado.";
            if (this.media > 9.0) {
                mensagem += " Parabéns!";
            }
        } else {
            mensagem += "Reprovado.";
        }

        return mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
}
