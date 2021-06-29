package Aula2.TM.Exercicio6;

public class StringUtil {
    public static String rpad(String s, char c, int n) {
        StringBuilder sBuilder = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            sBuilder.append(c);
        }
        s = sBuilder.toString();
        return s;
    }

    public static String ltrim(String s) {
        return s.replaceAll("^\\s+", "");
    }

    public static String rtrim(String s) {
        return s.replaceAll("\\s+$", "");
    }

    public static int indexOfN(String s, char c, int n) {
        int count = 0;
        for (int i=0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
                if (count == n) {
                    return i;
                }
            }
        }
        return -1;
    }
}
