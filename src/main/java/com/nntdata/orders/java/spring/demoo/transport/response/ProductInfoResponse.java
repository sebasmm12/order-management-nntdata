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
public class ProductInfoResponse {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(long productCategoryID) {
        this.productCategoryID = productCategoryID;
    }
    
    private long id;
    
    private String name;
    
    private double unitPrice;

    private boolean active;
    
    private long productCategoryID;
    
}
