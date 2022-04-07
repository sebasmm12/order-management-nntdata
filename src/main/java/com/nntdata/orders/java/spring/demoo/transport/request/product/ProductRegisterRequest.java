/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.transport.request.product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



/**
 *
 * @author Sebastian
 */
public class ProductRegisterRequest {

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

    public void setUnitPrice(double price) {
        this.unitPrice = price;
    }
    
    @NotNull(message = "The name must not be null")
    @NotEmpty(message = "The name must not be empty")
    private String name;
    
    private int productCategoryID;
    
    private double unitPrice;
    
}
