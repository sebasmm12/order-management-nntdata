/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "OrderItemPrices")
public class OrderItemPrice implements Serializable {

    public OrderItemPrice() {
        
    }
    
    public OrderItemPrice(int orderItemID, double unitPrice, double cost) {
        this.orderItemID = orderItemID;
        this.unitPrice = unitPrice;
        this.cost = cost;
    }

    public int getOrderItemID() {
        return orderItemID;
    }

    public void setOrderItemID(int orderItemID) {
        this.orderItemID = orderItemID;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "OrderItemID")
    private int orderItemID;
    
    @Column(name = "UnitPrice")
    private double unitPrice;
    
    @Column(name = "Cost")
    private double cost;
}
