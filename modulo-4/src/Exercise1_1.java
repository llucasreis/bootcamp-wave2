import java.util.Scanner;

public class Exercise1_1 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira até qual número gostaria de visualizar os números pares: ");
        int amountNumbers = sc.nextInt();

        int currentNumber = 0;

        while (currentNumber <= amountNumbers) {
            if (currentNumber % 2 == 0) {
                System.out.println(currentNumber);
            }
            currentNumber++;
        }
    }
}
