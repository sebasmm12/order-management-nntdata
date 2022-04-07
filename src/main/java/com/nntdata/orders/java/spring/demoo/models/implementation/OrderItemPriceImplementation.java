/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.implementation;

import com.nntdata.orders.java.spring.demoo.models.dao.IOrderItemPriceDao;
import com.nntdata.orders.java.spring.demoo.models.entity.OrderItemPrice;
import com.nntdata.orders.java.spring.demoo.models.service.IOrderItemPriceService;
import com.nntdata.orders.java.spring.demoo.transport.response.orderItemPrices.OrderItemPriceRegisterResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service("OrderItemPriceImplementation")
public class OrderItemPriceImplementation implements IOrderItemPriceService {

    @Autowired
    private IOrderItemPriceDao orderItemPriceDao;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public void RegisterAllOrderItemsPrices(List<OrderItemPriceRegisterResponse> orderItems) throws Exception {
        
        if(orderItems.isEmpty()) throw new Exception("Must register at least 1 Item for the Order");
        
        List<OrderItemPrice> orderItemsPrices = orderItems.stream().map(orderItem -> modelMapper.map(orderItem, OrderItemPrice.class))
                                                                   .collect(Collectors.toList());
        
        orderItemPriceDao.saveAll((Iterable)orderItemsPrices);
        
    }
    
}
