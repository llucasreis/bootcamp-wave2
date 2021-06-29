package Aula4.LaChiqui;

public class ConvidadoMeli extends Convidado {

    public ConvidadoMeli(String nome) {
        super(nome);
    }

    @Override
    public void comerBolo() {
        System.out.println(this.getNome() + " comendo bolo!!");
        System.out.println("Viva la Chiqui !!");
    }
}
