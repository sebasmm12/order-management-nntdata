/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.service;

import com.nntdata.orders.java.spring.demoo.transport.request.orderItem.OrderItemRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.orderItemPrices.OrderItemPriceRegisterResponse;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IOrderItemService {
    
    public void RegisterAllOrderItems(List<OrderItemRegisterRequest> orderItems) throws Exception;
    public List<OrderItemPriceRegisterResponse> GetOrderItemsWithPrices(long orderId) throws Exception;
}
