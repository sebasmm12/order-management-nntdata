/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.transport.request.product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sebastian
 */
public class ProductUpdateRequest {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProductCategoryID() {
        return productCategoryID;
    }

    public void setProductCategoryID(int productCategoryID) {
        this.productCategoryID = productCategoryID;
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

    @Min(value = 1, message = "The product doesn't exist")
    private int id;
    
    @NotNull(message = "The name must not be null")
    @NotEmpty(message = "The name must not be empty")
    private String name;
    
    private int productCategoryID;
    
    private double unitPrice;
    
    private boolean active;
    
}
