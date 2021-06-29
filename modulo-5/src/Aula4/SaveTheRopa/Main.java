package Aula4.SaveTheRopa;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Vestuario vestuario1 = new Vestuario("Marca 1", "Modelo 1");
        Vestuario vestuario2 = new Vestuario("Marca 2", "Modelo 2");

        GuardaRoupa guardaRoupa = new GuardaRoupa();

        guardaRoupa.guardarVestuarios(new ArrayList<>(Arrays.asList(vestuario1, vestuario2)));

        guardaRoupa.mostrarVestuarios();

        System.out.println(Arrays.asList(guardaRoupa.devolverVestuarios(0)));
    }
}
