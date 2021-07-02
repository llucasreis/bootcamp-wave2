package com.bootcamp.grupo4.restaurante.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtil {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static String getDataAtual() {
        Date date = new Date();
        return simpleDateFormat.format(date);
    }
}
