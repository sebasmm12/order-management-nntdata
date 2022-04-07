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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Sebastian
 */

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public Order() {
        
    }
    
    public Order(long id, String customerName, Date orderDate, int creationUserID, Date creationDate, Integer updateUserID, Date updateDate, double totalAmount, OrderStatus orderStatus, TaxRatio taxRatio) {
        this.id = id;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.creationUserID = creationUserID;
        this.creationDate = creationDate;
        this.updateUserID = updateUserID;
        this.updateDate = updateDate;
        this.orderStatus = orderStatus;
        this.taxRatio = taxRatio;
    }
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public void setUpdateUserID(Integer updateUserID) {
        this.updateUserID = updateUserID;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderID")
    private long id;
    
    @Column(name = "CustomerName")
    private String customerName;
    
    @Column(name = "OrderDate")
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    
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
    
    /* entidades relacionadas a la entidad Order */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OrderStatusID")
    private OrderStatus orderStatus;

    public TaxRatio getTaxRatio() {
        return taxRatio;
    }

    public void setTaxRatio(TaxRatio taxRatio) {
        this.taxRatio = taxRatio;
    }
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TaxRatioID")
    private TaxRatio taxRatio;
    
}
