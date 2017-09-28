package com.xpto.cities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "city")
public class City extends BaseEntity<Long> implements LogicExclusion {

    @Column(name = "cd_ibge")
    private Integer ibge;

    @Column(name = "nm_uf")
    private String uf;

    @Column(name = "nm_city")
    private String name;

    @Column(name = "fg_capital")
    private boolean capital;

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

    @Column(name = "fg_excluded")
    private boolean excluded;

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
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

    public boolean getCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
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

    @Override
    public boolean isExcluded() {
        return excluded;
    }

    @Override
    public void setExcluded(boolean excluded) {
        this.excluded = excluded;
    }
}
