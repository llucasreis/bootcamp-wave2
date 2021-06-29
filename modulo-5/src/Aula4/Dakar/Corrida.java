package Aula4.Dakar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Corrida {
    private double distancia;
    private double premioEmDolares;
    private String nome;
    private int quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos;
    private SocorristaCarro socorristaCarro;
    private SocorristaMoto socorristaMoto;

    public Corrida() {
    }

    public Corrida(double distancia, double premioEmDolares, String nome, int quantidadeVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
        this.listaVeiculos = new ArrayList<>();
        this.socorristaCarro = new SocorristaCarro();
        this.socorristaMoto = new SocorristaMoto();
    }

    public Veiculo buscarVeiculoPorPlaca(String placa) {
        return listaVeiculos.stream()
                .filter(v -> v.getPlaca().equals(placa))
                .findFirst()
                .orElse(null);
    }

    public boolean podeAdicionarVeiculo() {
        return this.listaVeiculos.size() < this.quantidadeVeiculosPermitidos;
    }

    private void registrarVeiculo(Veiculo veiculo) {
        Veiculo veiculoJaExiste = buscarVeiculoPorPlaca(veiculo.getPlaca());

        if (veiculoJaExiste == null && podeAdicionarVeiculo()) {
            this.listaVeiculos.add(veiculo);
        } else {
            System.err.println("Não foi possível adicionar");
        }
    }

    public void registrarCarro(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        this.registrarVeiculo(new Carro(velocidade, aceleracao, anguloDeGiro, placa));
    }

    public void registrarMoto(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        this.registrarVeiculo(new Moto(velocidade, aceleracao, anguloDeGiro, placa));
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.listaVeiculos.remove(veiculo);
    }

    public void removerVeiculoPorPlaca(String placa) {
        Veiculo veiculoEncontrado = this.buscarVeiculoPorPlaca(placa);

        if (veiculoEncontrado != null) {
            this.listaVeiculos.remove(veiculoEncontrado);
        }
    }

    public void socorrerCarro(String placa) {
        Veiculo veiculoEncontrado = this.buscarVeiculoPorPlaca(placa);
        if (veiculoEncontrado instanceof Carro) {
            this.socorristaCarro.socorrer((Carro) veiculoEncontrado);
        }
    }

    public void socorrerMoto(String placa) {
        Veiculo veiculoEncontrado = this.buscarVeiculoPorPlaca(placa);
        if (veiculoEncontrado instanceof Moto) {
            this.socorristaMoto.socorrer((Moto) veiculoEncontrado);
        }
    }

    public Veiculo calcularVencedor() {
        Optional<Veiculo> vencedor = this.listaVeiculos.stream().max(Comparator.comparingDouble(Veiculo::pontuacao));

        return vencedor.orElse(null);
    }


    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEmDolares() {
        return premioEmDolares;
    }

    public void setPremioEmDolares(double premioEmDolares) {
        this.premioEmDolares = premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeVeiculosPermitidos() {
        return quantidadeVeiculosPermitidos;
    }

    public void setQuantidadeVeiculosPermitidos(int quantidadeVeiculosPermitidos) {
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
    }
}
