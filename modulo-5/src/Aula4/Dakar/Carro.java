package Aula4.Dakar;

public class Carro extends Veiculo {
    public Carro() {
    }

    public Carro(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, 1000, 4);
    }

    @Override
    public String toString() {
        return "Carro{" + this.getPlaca() + "}";
    }
}
