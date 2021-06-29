package Aula2.TT;

public class Gerente extends FuncionarioCLT {

    public Gerente(String nome, int jornadaCumprida, int metasBatidas) {
        super(nome, 6000, 36, jornadaCumprida, 4, 0.125, metasBatidas, 0);
    }

    @Override
    public double pagarSalario() {
        return this.calcularBonificacao() + this.calcularJornada() + this.calcularDescansoRenumerado();
    }
}
