import java.util.Scanner;

public class Exercise1_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira quantos números gostaria de visualizar: ");
        int n = sc.nextInt();

        System.out.print("Quantos digitos repetidos: ");
        int m = sc.nextInt();

        System.out.print("Qual o digito repetido: ");
        int d = sc.nextInt();

        int totalNumbers = 0;
        int currentNumber = 0;

        while (totalNumbers < n) {
           int temp = currentNumber;
           int countDigits = 0;

           while (temp != 0) {
               int digit = temp % 10;
               temp = temp / 10;

               if (digit == d) countDigits++;
           }

           if (countDigits == m) {
               System.out.println(currentNumber);
               totalNumbers++;
           }
           currentNumber++;
        }
    }
}
