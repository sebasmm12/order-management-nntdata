/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.service;

import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderUpdateRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.order.OrderRegisterInfoResponse;

/**
 *
 * @author Sebastian
 */
public interface IOrderService {
    
    public void RegisterOrder(OrderRegisterRequest orderRegisterRequest) throws Exception ;
    public void UpdateOrder(OrderUpdateRequest orderUpdateRequest) throws Exception;
    public OrderRegisterInfoResponse GetOrder(long orderId) throws Exception;
}
