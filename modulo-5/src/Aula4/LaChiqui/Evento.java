package Aula4.LaChiqui;

import java.util.ArrayList;
import java.util.List;

public class Evento {
    private List<Fogos> fogosList;
    private List<Convidado> convidadoList;

    public Evento() {
        this.fogosList = new ArrayList<>();
        this.convidadoList = new ArrayList<>();
    }

    public void inserirConvidado(Convidado convidado) {
        this.convidadoList.add(convidado);
    }

    public void inserirFogos(Fogos fogos) {
        this.fogosList.add(fogos);
    }

    public void apagarVelas() {
        System.out.println("Apagando velas");
        System.out.println("...................");
        this.explodirFogos();
        System.out.println("-----------------------");
        this.distribuirBolo();
    }

    public void explodirFogos() {
        fogosList.forEach(Fogos::explodir);
    }

    public void distribuirBolo() {
        convidadoList.forEach(Convidado::comerBolo);
    }
}
