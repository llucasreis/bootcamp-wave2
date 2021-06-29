package Aula4.Dakar;

public class Moto extends Veiculo {

    public Moto() {
    }

    public Moto(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, 300, 2);
    }

    @Override
    public String toString() {
        return "Moto{" + this.getPlaca() + "}";
    }
}
