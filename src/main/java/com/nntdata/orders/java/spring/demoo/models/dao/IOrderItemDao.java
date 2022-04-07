/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.dao;

import com.nntdata.orders.java.spring.demoo.models.entity.ProductCategory;
import com.nntdata.orders.java.spring.demoo.transport.response.orderItemPrices.OrderItemPriceRegisterResponse;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Sebastian
 */
public interface IOrderItemDao extends CrudRepository<ProductCategory, Long> {
    
   @Query("select OI.id as orderItemID, P.unitPrice as unitPrice, (P.unitPrice * OI.quantity) as cost from OrderItem OI"
        +  " join fetch Product P"
        + " where OI.order.id = :orderId")
    public List<OrderItemPriceRegisterResponse> GetOrderItemsWithPrices(@Param("orderId")long orderId);
    
}
