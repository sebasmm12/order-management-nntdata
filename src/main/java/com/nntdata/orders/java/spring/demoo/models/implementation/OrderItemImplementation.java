/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.implementation;

import com.nntdata.orders.java.spring.demoo.models.dao.IOrderItemDao;
import com.nntdata.orders.java.spring.demoo.models.entity.Order;
import com.nntdata.orders.java.spring.demoo.models.entity.OrderItem;
import com.nntdata.orders.java.spring.demoo.models.entity.Product;
import com.nntdata.orders.java.spring.demoo.models.service.IOrderItemService;
import com.nntdata.orders.java.spring.demoo.transport.request.orderItem.OrderItemRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.orderItemPrices.OrderItemPriceRegisterResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service("OrderItemImplementation")
public class OrderItemImplementation implements IOrderItemService {

    @Autowired
    private IOrderItemDao orderItemDao;
    

    @Override
    public void RegisterAllOrderItems(List<OrderItemRegisterRequest> orderItemsRegisters) throws Exception {
       
        if(orderItemsRegisters.isEmpty()) throw new Exception("Must register at least 1 Product for the Order");
        
        List<OrderItem> orderItems = orderItemsRegisters.stream().map(orderItemRegister -> {
        
            Product product = new Product();
            product.setId(orderItemRegister.getProductId());
            
            Order order = new Order();
            order.setId(orderItemRegister.getOrderId());
            
            return new OrderItem(order, product, orderItemRegister.getQuantity());
        }
        ).collect(Collectors.toList());
        
        orderItemDao.saveAll((Iterable)orderItems);
        
    }

    @Override
    public List<OrderItemPriceRegisterResponse> GetOrderItemsWithPrices(long orderId) throws Exception {
        
        List<OrderItemPriceRegisterResponse> orderItemPrices = orderItemDao.GetOrderItemsWithPrices(orderId);
        
        if(orderItemPrices == null || orderItemPrices.isEmpty()) throw new Exception("Couldn't get the order items with their prices");
        
        return orderItemPrices;
        
    }
}
