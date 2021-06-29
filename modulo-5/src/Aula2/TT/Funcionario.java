package Aula2.TT;

public abstract class Funcionario {
    private String nome;

    public Funcionario() {}

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public abstract double pagarSalario();
}
