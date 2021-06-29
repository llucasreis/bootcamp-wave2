package Aula4.Dakar;

public class SocorristaMoto implements Socorrista<Moto> {

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorrendo moto");
        System.out.println("Placa: " + moto.getPlaca());
    }
}
