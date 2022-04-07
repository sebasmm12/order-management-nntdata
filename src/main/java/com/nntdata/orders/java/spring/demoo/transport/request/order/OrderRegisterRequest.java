/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.transport.request.order;

import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sebastian
 */
public class OrderRegisterRequest {

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderProductRegister> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProductRegister> orderProducts) {
        this.orderProducts = orderProducts;
    }
    
    
    private String customerName;
    private Date orderDate;
    
    @NotNull(message = "Must register at least 1 product for the order")
    @Size(min = 1)
    private List<OrderProductRegister> orderProducts;
}
