package Aula2.TT;

public class Analista extends FuncionarioCLT {

    public Analista(String nome, int jornadaCumprida, int metasBatidas) {
        super(nome, 4000, 40, jornadaCumprida, 4, 0.08, metasBatidas, 0);
    }

    @Override
    public double pagarSalario() {
        return this.calcularBonificacao() + this.calcularJornada() + this.calcularDescansoRenumerado();
    }
}
