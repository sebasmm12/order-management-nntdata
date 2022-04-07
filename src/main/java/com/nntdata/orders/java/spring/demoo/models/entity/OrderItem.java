/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "OrderItems")
public class OrderItem implements Serializable {

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public OrderItemPrice getOrderItemPrice() {
        return orderItemPrice;
    }

   public OrderItem() {
       
   } 
   
   public OrderItem(Order order, Product product, int quantity) {
       
        this(0, quantity, order, product, null);
   }
   
    public OrderItem(long id, int quantity, Order order, Product product, OrderItemPrice orderItemPrice) {
        this.id = id;
        this.quantity = quantity;
        this.order = order;
        this.product = product;
        this.orderItemPrice = orderItemPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderItemID")
    private long id;
    
    @Column(name = "Quantity")
    private int quantity;
    
    /* entidades relacionadas a la entidad OrderItem */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderID")
    private Order order;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID")
    private Product product;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderItemID")
    private OrderItemPrice orderItemPrice;
    
}
