import java.util.Scanner;

public class Exercise1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Insira até qual número gostaria de visualizar: ");
        int n = sc.nextInt();

        System.out.print("Insira o valor que deseja conhecer os múltiplos: ");
        int m = sc.nextInt();

        int multipleNumbers = m;

        while (multipleNumbers <= n) {
            if (multipleNumbers % m == 0) {
                System.out.println(multipleNumbers);
            }
            multipleNumbers++;
        }
    }
}
