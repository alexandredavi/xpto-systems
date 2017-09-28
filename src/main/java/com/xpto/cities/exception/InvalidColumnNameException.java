package com.xpto.cities.exception;

public class InvalidColumnNameException extends RuntimeException {

    private final String column;

    public InvalidColumnNameException(String column) {
        super();
        this.column = column;
    }

    public String getColumn() {
        return column;
    }
}
