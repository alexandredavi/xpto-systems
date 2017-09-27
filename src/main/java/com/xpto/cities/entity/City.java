package com.xpto.cities.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cd_ibge")
    private Integer ibgeC;

    @Column(name = "nm_uf")
    private String uf;

    @Column(name = "nm_city")
    private String name;

    @Column(name = "nm_capital")
    private String capital;

    @Column(name = "nu_longitude")
    private BigDecimal longitude;

    @Column(name = "nu_latitute")
    private BigDecimal latitude;

    @Column(name = "nm_no_accents")
    private String noAccentsName;

    @Column(name = "nm_alternative")
    private String alternativenames;

    @Column(name = "nm_microregion")
    private String microRegion;

    @Column(name = "nm_mesoregion")
    private String mesoregion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIbgeC() {
        return ibgeC;
    }

    public void setIbgeC(Integer ibgeC) {
        this.ibgeC = ibgeC;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public String getNoAccentsName() {
        return noAccentsName;
    }

    public void setNoAccentsName(String noAccentsName) {
        this.noAccentsName = noAccentsName;
    }

    public String getAlternativenames() {
        return alternativenames;
    }

    public void setAlternativenames(String alternativenames) {
        this.alternativenames = alternativenames;
    }

    public String getMicroRegion() {
        return microRegion;
    }

    public void setMicroRegion(String microRegion) {
        this.microRegion = microRegion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }
}
