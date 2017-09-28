package com.xpto.cities.utils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CsvUtils {

    public static final Map<String, String> RELATION_CSV_ENTITY = new HashMap<>();
    static {
        RELATION_CSV_ENTITY.put("ibge_id", "ibge");
        RELATION_CSV_ENTITY.put("uf", "uf");
        RELATION_CSV_ENTITY.put("name", "name");
        RELATION_CSV_ENTITY.put("capital", "capital");
        RELATION_CSV_ENTITY.put("lon", "longitude");
        RELATION_CSV_ENTITY.put("lat", "latitude");
        RELATION_CSV_ENTITY.put("no_accents", "noAccentsName");
        RELATION_CSV_ENTITY.put("alternative_names", "alternativenames");
        RELATION_CSV_ENTITY.put("microregion", "microRegion");
        RELATION_CSV_ENTITY.put("mesoregion", "mesoregion");
    }

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
