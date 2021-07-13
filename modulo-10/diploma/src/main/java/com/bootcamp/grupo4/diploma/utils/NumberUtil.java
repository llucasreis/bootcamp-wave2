package com.bootcamp.grupo4.diploma.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bigDecimal = BigDecimal.valueOf(value);

        bigDecimal = bigDecimal.setScale(places, RoundingMode.FLOOR);

        return bigDecimal.doubleValue();
    }
}
