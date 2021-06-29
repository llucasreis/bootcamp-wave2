package Aula4.LaChiqui;

public abstract class Convidado {
    private String nome;

    public Convidado(){}

    public Convidado(String nome) {
        this.nome = nome;
    }

    public void comerBolo() {
        System.out.println(this.nome + " comendo bolo.");
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
