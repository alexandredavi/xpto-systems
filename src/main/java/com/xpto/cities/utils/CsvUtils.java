package com.xpto.cities.utils;

import java.math.BigDecimal;

public class CsvUtils {

    private CsvUtils() {
    }

    public static String getStringValue(String columnValue) {
        return "".equals(columnValue) ? null : columnValue;
    }

    public static Integer getIntegerValue(String columnValue) {
        return Integer.parseInt(columnValue);
    }

    public static Boolean getBooleanValue(String columnValue) {
        return new Boolean(columnValue);
    }

    public static BigDecimal getBigDecimalValue(String columnValue) {
        return  new BigDecimal(columnValue);
    }

}
