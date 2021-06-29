package Aula1.TM.Exercicio2;

import java.util.Arrays;

public class Exercise2_1 {

    private static Integer[] order(Integer[] v, String direction) {
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (direction.equals("crescent")) {
                    if (v[j] > v[j + 1]) {
                        int aux = v[j];
                        v[j] = v[j+1];
                        v[j+1] = aux;
                    }
                }
                if (direction.equals("decrement")) {
                    if (v[j] < v[j + 1]) {
                        int aux = v[j];
                        v[j] = v[j+1];
                        v[j+1] = aux;
                    }
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        Integer[] array = {52, 10, 85, 1324, 01, 13, 62, 30, 12, 127};

        System.out.println(Arrays.toString(array));

        Integer[] arrayCrescent = order(Arrays.copyOf(array, array.length), "crescent");
        Integer[] arrayDecrement = order(Arrays.copyOf(array, array.length), "decrement");

        System.out.println(Arrays.toString(arrayCrescent));
        System.out.println(Arrays.toString(arrayDecrement));
    }
}
