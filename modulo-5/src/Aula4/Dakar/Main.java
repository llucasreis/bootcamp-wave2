package Aula4.Dakar;

public class Main {
    public static void main(String[] args) {
        Corrida corrida = new Corrida(200.0, 1000, "X1", 4);

        corrida.registrarCarro(14.0, 5.0, 49, "MVD8754");
        corrida.registrarCarro(20.0, 5.5, 49, "MYQ7718");
        corrida.registrarMoto(11.5, 8.0, 47, "NEX1510");
        corrida.registrarMoto(12.0, 3.9, 48, "MZK7098");

        corrida.registrarCarro(10.0, 5.0, 49, "MVD8754");

        corrida.socorrerMoto("MZK7098");
        corrida.socorrerCarro("NEX1510");

        corrida.removerVeiculoPorPlaca("MZK7098");

        Veiculo veiculo = corrida.calcularVencedor();
        System.out.println("Vencedor: " + veiculo);
    }
}
