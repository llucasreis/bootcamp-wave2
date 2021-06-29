package Aula2.TT;

public class Tecnico extends FuncionarioCLT {

    public Tecnico(String nome, int jornadaCumprida, int metasBatidas) {
        super(nome, 3200, 40, jornadaCumprida, 0, 0.05, metasBatidas, 0);
    }

    @Override
    public double pagarSalario() {
        return this.calcularBonificacao() + this.calcularJornada();
    }
}
