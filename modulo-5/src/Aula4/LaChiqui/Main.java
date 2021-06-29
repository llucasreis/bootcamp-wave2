package Aula4.LaChiqui;

public class Main {
    public static void main(String[] args) {
        Evento evento = new Evento();
        evento.inserirConvidado(new ConvidadoMeli("Lucas"));
        evento.inserirConvidado(new ConvidadoStandard("Emily"));

        FogosPacote fogosApitoPacote = new FogosPacote();
        fogosApitoPacote.inserirNoPacote(new FogoApito());
        fogosApitoPacote.inserirNoPacote(new FogoApito());
        fogosApitoPacote.inserirNoPacote(new FogoApito());

        FogosPacote fogosPacote = new FogosPacote();
        fogosPacote.inserirNoPacote(fogosApitoPacote);

        evento.inserirFogos(new FogoApito());
        evento.inserirFogos(new FogoSpider());
        evento.inserirFogos(new FogoTiro());
        evento.inserirFogos(fogosPacote);

        evento.apagarVelas();
    }
}
