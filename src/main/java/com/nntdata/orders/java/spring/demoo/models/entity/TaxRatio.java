/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "TaxRatios")
public class TaxRatio implements Serializable {

    public TaxRatio() {
        
    }
    
    public TaxRatio(long id, double cityTaxPercentage, double countryTaxPercentage, double stateTaxPercentage, double federalTaxPercentage, boolean active, int creationUserID, Date creationDate, int updateUserID, Date updateDate) {
        this.id = id;
        this.cityTaxPercentage = cityTaxPercentage;
        this.countryTaxPercentage = countryTaxPercentage;
        this.stateTaxPercentage = stateTaxPercentage;
        this.federalTaxPercentage = federalTaxPercentage;
        this.active = active;
        this.creationUserID = creationUserID;
        this.creationDate = creationDate;
        this.updateUserID = updateUserID;
        this.updateDate = updateDate;
    }

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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCreationUserID() {
        return creationUserID;
    }

    public void setCreationUserID(int creationUserID) {
        this.creationUserID = creationUserID;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getUpdateUserID() {
        return updateUserID;
    }

    public void setUpdateUserID(int updateUserID) {
        this.updateUserID = updateUserID;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaxRatioID")
    private long id;
     
    @Column(name = "CityTaxPercentage")
    private double cityTaxPercentage;
    
    @Column(name = "CountryTaxPercentage")
    private double countryTaxPercentage;
    
    @Column(name = "StateTaxPercentage")
    private double stateTaxPercentage;
    
    @Column(name = "FederalTaxPercentage")
    private double federalTaxPercentage;
    
    @Column(name = "Active")
    private boolean active;
    
    @Column(name = "CreationUserID")
    private int creationUserID;
    
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate; 
    
    @Column(name = "UpdateUserID")
    private int updateUserID;
    
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate; 
}
