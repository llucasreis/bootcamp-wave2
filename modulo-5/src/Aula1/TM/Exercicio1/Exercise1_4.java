package Aula1.TM.Exercicio1;

import java.util.Scanner;

public class Exercise1_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira a quantidade de números primos que deseja saber: ");
        int n = sc.nextInt();

        int currentNumber = 2;
        int totalPrimes = 0;

        while (totalPrimes < n) {
            boolean isPrime = true;

            for (int i = 2; i < currentNumber; i++) {
                if (currentNumber % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(currentNumber);
                totalPrimes++;
            }
            currentNumber++;
        }
    }
}
