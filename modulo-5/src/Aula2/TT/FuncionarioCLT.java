package Aula2.TT;

public abstract class FuncionarioCLT extends Funcionario {
    private double salarioBase;
    private int jornada;
    private int jornadaCumprida;
    private int descanso;
    private double bonificacao;
    private int metasBatidas;
    private double participaoLucros;

    public FuncionarioCLT() {}

    public FuncionarioCLT(String nome, double salarioBase, int jornada, int jornadaCumprida,
                          int descanso, double bonificacao, int metasBatidas, double participaoLucros) {
        super(nome);
        this.salarioBase = salarioBase;
        this.jornada = jornada;
        this.jornadaCumprida = jornadaCumprida;
        this.descanso = descanso;
        this.bonificacao = bonificacao;
        this.metasBatidas = metasBatidas;
        this.participaoLucros = participaoLucros;
    }

    public double calcularBonificacao() {
        return ((this.metasBatidas * this.bonificacao) * this.salarioBase);
    }

    public double calcularJornada() {
        return ((this.salarioBase / this.jornada) * this.jornadaCumprida);
    }

    public double calcularDescansoRenumerado() {
        return this.jornadaCumprida > 0 ?
                ((this.salarioBase * this.descanso) / this.jornadaCumprida)
                : 0.0;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }

    public int getJornadaCumprida() {
        return jornadaCumprida;
    }

    public void setJornadaCumprida(int jornadaCumprida) {
        this.jornadaCumprida = jornadaCumprida;
    }

    public int getDescanso() {
        return descanso;
    }

    public void setDescanso(int descanso) {
        this.descanso = descanso;
    }

    public double getBonificacao() {
        return bonificacao;
    }

    public void setBonificacao(double bonificacao) {
        this.bonificacao = bonificacao;
    }

    public int getMetasBatidas() {
        return metasBatidas;
    }

    public void setMetasBatidas(int metasBatidas) {
        this.metasBatidas = metasBatidas;
    }

    public double getParticipaoLucros() {
        return participaoLucros;
    }

    public void setParticipaoLucros(double participaoLucros) {
        this.participaoLucros = participaoLucros;
    }
}
