package Aula4.Dakar;

public class SocorristaCarro implements Socorrista<Carro> {

    @Override
    public void socorrer(Carro carro) {
        System.out.println("Socorrendo Carro");
        System.out.println("Placa:  " + carro.getPlaca());
    }
}
