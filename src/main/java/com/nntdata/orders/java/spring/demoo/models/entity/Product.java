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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "Products")
public class Product implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public Product() {
        
    }
    
    public Product(long Id, String name, double unitPrice, boolean active, int creationUserID, Date creationDate, int updateUserID, Date updateDate, ProductCategory productCategory) {
        this.id = Id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.active = active;
        this.creationUserID = creationUserID;
        this.creationDate = creationDate;
        this.updateUserID = updateUserID;
        this.updateDate = updateDate;
        this.productCategory = productCategory;
    }

    public long getId() {
        return id;
    }

    public void setId(long Id) {
        this.id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
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

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private long id;
    
    @Column(name = "ProductName")
    private String name;
    
    @Column(name="UnitPrice")
    private double unitPrice;

    @Column(name = "Active")
    private boolean active;
    
    @Column(name = "CreationUserID")
    private int creationUserID;
    
    @Column(name = "CreationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate; 
    
    @Column(name = "UpdateUserID")
    private Integer updateUserID = null;
    
    @Column(name = "UpdateDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate; 
    
    /* entidades relacionadas a la entidad Producto */    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductCategoryID")
    private ProductCategory productCategory;
    
}
