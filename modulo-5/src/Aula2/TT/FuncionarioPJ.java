package Aula2.TT;

public class FuncionarioPJ extends Funcionario {
    public double horasTrabalhadas;
    public double salarioPorHora;

    public FuncionarioPJ() {}

    public FuncionarioPJ(String nome, double horasTrabalhadas, double salarioPorHora) {
        super(nome);
        this.horasTrabalhadas = horasTrabalhadas;
        this.salarioPorHora = salarioPorHora;
    }

    @Override
    public double pagarSalario() {
        return horasTrabalhadas * salarioPorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getSalarioPorHora() {
        return salarioPorHora;
    }

    public void setSalarioPorHora(double salarioPorHora) {
        this.salarioPorHora = salarioPorHora;
    }
}
