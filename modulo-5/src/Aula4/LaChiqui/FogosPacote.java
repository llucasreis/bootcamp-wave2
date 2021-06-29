package Aula4.LaChiqui;

import java.util.ArrayList;
import java.util.List;

public class FogosPacote implements Fogos {
    private List<Fogos> fogos;

    public FogosPacote() {
        this.fogos = new ArrayList<>();
    }

    public FogosPacote(List<Fogos> fogos) {
        this.fogos = fogos;
    }

    public void inserirNoPacote(Fogos fogos) {
        this.fogos.add(fogos);
    }

    @Override
    public void explodir() {
        fogos.forEach(Fogos::explodir);
    }
}
