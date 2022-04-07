/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.restControllers;

import com.nntdata.orders.java.spring.demoo.models.service.IOrderService;
import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.order.OrderUpdateRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductUpdateRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Sebastian
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {
    
    private final Log logger = LogFactory.getLog(this.getClass());
    
    @Autowired
    private IOrderService orderService;
    
    @PostMapping()
    public ResponseEntity RegisterOrder(@RequestBody OrderRegisterRequest orderRegisterRequest) {
        
        try {
            
            orderService.RegisterOrder(orderRegisterRequest);
           
        } catch (Exception e) {
            
            Logger.getLogger(this.getClass().getName()).log(Logger.Level.FATAL, e);
            
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
            
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Could register the order successfully");
        
    }
    
    @PutMapping("/{orderId}")
    public ResponseEntity UpdateOrder(@PathVariable(name = "orderId") long orderId, @RequestBody OrderUpdateRequest orderUpdateRequest) {
        
        try {
            
            if(orderId == 0 || orderId != orderUpdateRequest.getId()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't find the order");
            
            orderService.UpdateOrder(orderUpdateRequest);
            
        } catch (Exception e) {
            
            Logger.getLogger(this.getClass().getName()).log(Logger.Level.FATAL, e);
            
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
            
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Could update the order successfully");
        
    }
    
}
