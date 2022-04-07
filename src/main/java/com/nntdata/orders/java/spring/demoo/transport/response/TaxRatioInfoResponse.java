/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.transport.response;

/**
 *
 * @author Sebastian
 */
public class TaxRatioInfoResponse {
    
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCityTaxPercentage() {
        return cityTaxPercentage;
    }

    public void setCityTaxPercentage(double cityTaxPercentage) {
        this.cityTaxPercentage = cityTaxPercentage;
    }

    public double getCountryTaxPercentage() {
        return countryTaxPercentage;
    }

    public void setCountryTaxPercentage(double countryTaxPercentage) {
        this.countryTaxPercentage = countryTaxPercentage;
    }

    public double getStateTaxPercentage() {
        return stateTaxPercentage;
    }

    public void setStateTaxPercentage(double stateTaxPercentage) {
        this.stateTaxPercentage = stateTaxPercentage;
    }

    public double getFederalTaxPercentage() {
        return federalTaxPercentage;
    }

    public void setFederalTaxPercentage(double federalTaxPercentage) {
        this.federalTaxPercentage = federalTaxPercentage;
    }
    
    private double cityTaxPercentage;
    
    private double countryTaxPercentage;
    
    private double stateTaxPercentage;
    
    private double federalTaxPercentage;
    
}
