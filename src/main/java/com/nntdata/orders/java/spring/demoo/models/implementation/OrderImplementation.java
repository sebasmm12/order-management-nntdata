/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.implementation;

import com.nntdata.orders.java.spring.demoo.models.dao.IOrderDao;
import com.nntdata.orders.java.spring.demoo.models.entity.Order;
import com.nntdata.orders.java.spring.demoo.models.entity.OrderStatus;
import com.nntdata.orders.java.spring.demoo.models.entity.TaxRatio;
import com.nntdata.orders.java.spring.demoo.models.service.IOrderItemPriceService;
import com.nntdata.orders.java.spring.demoo.models.service.IOrderItemService;
import com.nntdata.orders.java.spring.demoo.models.service.IOrderService;
import com.nntdata.orders.java.spring.demoo.models.service.IProductService;
import com.nntdata.orders.java.spring.demoo.models.service.ITaxRatioService;
import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderProductRegister;
import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderUpdateRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.orderItem.OrderItemRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.orderItemPrices.OrderItemPriceRegisterResponse;
import com.nntdata.orders.java.spring.demoo.transport.response.TaxRatioInfoResponse;
import com.nntdata.orders.java.spring.demoo.transport.response.order.OrderRegisterInfoResponse;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service("OrderImplementation")
public class OrderImplementation implements IOrderService {
    
    @Autowired
    private IOrderDao orderDao;
    
    @Autowired
    private IProductService productService;
    
    @Autowired
    private ITaxRatioService taxRatioService;
    
    @Autowired
    private IOrderItemService orderItemService;

    @Autowired
    private IOrderItemPriceService orderItemPriceService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public void RegisterOrder(OrderRegisterRequest orderRegisterRequest) throws Exception {
       
        List<Long> productsIds = orderRegisterRequest.getOrderProducts()
                                                                 .stream()
                                                                 .map(orderProduct -> orderProduct.getProductID())
                                                                 .collect(Collectors.toList());
        
        // Se valida si todos los productos de la orden existen en el sistema
        productService.ValidateProductsToRegisterOrder(productsIds);
        
        Order order = modelMapper.map(orderRegisterRequest, Order.class);
        
        PrepareOrderRegister(order);
        
        order = orderDao.save(order);
        long orderId = order.getId();
        // Se registra todas los productos de la orden
        List<OrderItemRegisterRequest> orderItems = orderRegisterRequest.getOrderProducts().stream()
                                                                                           .map(orderProduct -> new OrderItemRegisterRequest(orderId, orderProduct.getQuantity(),
                                                                                                                                             orderProduct.getProductID()))
                                                                                           .collect(Collectors.toList());
        
        orderItemService.RegisterAllOrderItems(orderItems);
        
    }

    @Override
    public void UpdateOrder(OrderUpdateRequest orderUpdateRequest) throws Exception {
       
        Order order = GetEntityOrderById(orderUpdateRequest.getId());
        
        if(order.getOrderStatus().getId() != 1) throw new Exception("Couldn't update the order because its state isn't pending");
        
        order.setOrderStatus(new OrderStatus());
        
        modelMapper.map(orderUpdateRequest, order);
        
        PrepareOrderUpdate(order);
        
        /* Se envía la información de los precios de los productos de la orden así como el costo total de cada uno, debido a que al momento en que se aprobó la orden o se rechazó, se 
           realizó esta acción con el precio que se tenía de los productos como sus costos. */
        RegisterOrderItemsPrice(order);
         
        orderDao.save(order);
        
    }
    
    private void RegisterOrderItemsPrice(Order order) throws Exception {
        
        List<OrderItemPriceRegisterResponse> orderItemsPrices = orderItemService.GetOrderItemsWithPrices(order.getId());
        
        orderItemPriceService.RegisterAllOrderItemsPrices(orderItemsPrices);
        
    }
    
    private Order GetEntityOrderById(long id) throws Exception {
        
        Order order = orderDao.findById(id).orElse(null);
         
        if(order == null) throw new Exception("The product doesn't exist");
        
        return order;
        
    }
    
    private void PrepareOrderRegister(Order order) {
       
        order.setId(0);
        order.setOrderStatus(new OrderStatus(1)); // Por defecto toda orden se creará con estado "Pendiente".
        
        /* Se realiza una simulación de auditoría ya que actualmente no se trabaja con sesiones */
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        order.setCreationDate(calendar.getTime());
        order.setCreationUserID(1);
    }
    
    private void PrepareOrderUpdate(Order order) throws Exception {
        
        TaxRatioInfoResponse taxRatioInfo = taxRatioService.GetLastTaxRatio();
        TaxRatio taxRatio = modelMapper.map(taxRatioInfo, TaxRatio.class);
        
        order.setTaxRatio(taxRatio);
        
        /* Se realiza una simulación de auditoría ya que actualmente no se trabaja con sesiones */
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        
        order.setUpdateDate(calendar.getTime());
        order.setUpdateUserID(1);
    }
    
    private double GetTotal(TaxRatioInfoResponse taxRatioInfo, List<OrderProductRegister> orderProducts) {
       
        /* Se obtiene el total de la suma de los costos de los productos de la orden a registrar */
        double totalProductsSum = orderProducts.stream().mapToDouble(orderProduct -> orderProduct.getQuantity() * orderProduct.getUnitPrice()).sum();
        
        double cityTax = totalProductsSum * (1 +  taxRatioInfo.getCityTaxPercentage()) ;
        double countyTax = cityTax * (1 + taxRatioInfo.getCountryTaxPercentage());
        double stateTax = countyTax * (1 + taxRatioInfo.getStateTaxPercentage());
        double federalTax = stateTax * (1 + taxRatioInfo.getFederalTaxPercentage());
        
        return cityTax + countyTax + stateTax + federalTax;
    }

    @Override
    public OrderRegisterInfoResponse GetOrder(long orderId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
