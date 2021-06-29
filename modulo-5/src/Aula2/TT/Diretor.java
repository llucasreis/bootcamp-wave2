package Aula2.TT;

public class Diretor extends FuncionarioCLT {
    private double lucrosEmpresa;

    public Diretor(String nome, double lucrosEmpresa) {
        super(nome, 15000, 0, 0, 4, 0, 0, 0.03);
        this.lucrosEmpresa = lucrosEmpresa;
    }

    @Override
    public double pagarSalario() {
        return (
                this.getSalarioBase() + (this.lucrosEmpresa * this.getParticipaoLucros())
                );
    }

    public double getLucrosEmpresa() {
        return lucrosEmpresa;
    }

    public void setLucrosEmpresa(double lucrosEmpresa) {
        this.lucrosEmpresa = lucrosEmpresa;
    }
}
