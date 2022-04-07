/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.transport.request.orderItem;

/**
 *
 * @author Sebastian
 */
public class OrderItemRegisterRequest {

    public OrderItemRegisterRequest() {
        
    }
    
    public OrderItemRegisterRequest(long orderId, int quantity, long productId) {
        this.orderId = orderId;
        this.quantity = quantity;
        this.productId = productId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
    
    private long orderId;
    
    private int quantity;
    
    private long productId;
    
}
