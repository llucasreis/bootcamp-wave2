package Aula2.TM.Exercicio6;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtil.rpad("5", '0', 2));
        System.out.println(StringUtil.ltrim("   Lucas"));
        System.out.println(StringUtil.rtrim("Lucas   "));

        String s = "John|Paul|George|Ringo";
        int n = 2;
        char c = '|';
        System.out.println(StringUtil.indexOfN(s, c, n));

    }
}
