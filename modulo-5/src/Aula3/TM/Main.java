package Aula3.TM;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Pessoa[] pessoas = {
                new Pessoa("Lucas", "91152207024"),
                new Pessoa("Emily", "60206349068"),
                new Pessoa("Roberto", "81848866089")
        };

        SortUtil.sort(pessoas);
        System.out.println(Arrays.asList(pessoas));

        Celular[] celulares = {
                new Celular("981558532", "Lucas"),
                new Celular("946753182", "Emily")
        };

        SortUtil.sort(celulares);
        System.out.println(Arrays.asList(celulares));
    }
}
