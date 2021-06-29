package Aula1.TM.Exercicio2;

public class Exercise2_2 {
    public static void main(String[] args) {
        double XValue = 1.13;
        double XGrowing = 14.8; //148%

        double YValue = 18.4;
        double YGrowing = 0.32; //32%

        int year = 2021;

        System.out.println("Empresa X - 01/01" + year + " - Valor da empresa: " + XValue + "m");
        System.out.println("Empresa Y - 01/01" + year + " - Valor da empresa: " + YValue + "m");

        while (XValue < YValue) {
            XValue += (XValue * XGrowing);
            YValue += (YValue * YGrowing);

            year++;

            System.out.println("Empresa X - 01/01" + year + " - Valor da empresa: " + XValue + "m");
            System.out.println("Empresa Y - 01/01" + year + " - Valor da empresa: " + YValue + "m");
        }
    }
}
