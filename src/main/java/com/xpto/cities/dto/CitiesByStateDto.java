package com.xpto.cities.dto;

public class CitiesByStateDto {

    private String state;
    private Long number;

    public CitiesByStateDto() {
    }

    public CitiesByStateDto(String state, Long number) {
        this.state = state;
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
