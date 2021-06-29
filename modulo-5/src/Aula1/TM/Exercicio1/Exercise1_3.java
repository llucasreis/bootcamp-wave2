package Aula1.TM.Exercicio1;

import java.util.Scanner;

public class Exercise1_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira o número que deseja saber se é primo: ");
        int n = sc.nextInt();

        boolean isPrime = true;

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }

        System.out.println(isPrime ? "É primo" : "Não é primo");
    }
}
