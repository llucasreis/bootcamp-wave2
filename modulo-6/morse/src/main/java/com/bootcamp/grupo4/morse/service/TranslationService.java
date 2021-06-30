package com.bootcamp.grupo4.morse.service;

public class TranslationService {
    private static final char[] caracteres = { 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', '1', '2', '3', '4',
            '5', '6', '7', '8', '9', '0' };

    private static final String[] code = { ".-", "-...", "-.-.", "-..",  ".", "..-.",
            "--.",  "....", "..",   ".---", "-.-",  ".-..",
            "--",   "-.",   "---", ".--.", "--.-", ".-.",
            "...",  "-", "..-",  "...-", ".--",  "-..-",
            "-.--", "--..",  ".----",  "..---", "...--", "....-",
            ".....", "-....", "--...", "---..", "----.", "-----"
            };

    public static String translate(String morse) {
        String[] array = morse.split(" ");

        StringBuilder palavra = new StringBuilder();
        for (String s : array) {
            for (int j = 0; j < code.length; j++) {
                if (code[j].compareTo(s) == 0) {
                    palavra.append(caracteres[j]);
                }
            }
        }

        return palavra.toString();
    }
}
