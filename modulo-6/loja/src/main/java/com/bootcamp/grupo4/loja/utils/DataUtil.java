package com.bootcamp.grupo4.loja.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String getDataAtual() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    public static String converterFormato(String data){
        String newDate = "";
        SimpleDateFormat userFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            return simpleDateFormat.format(userFormat.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
