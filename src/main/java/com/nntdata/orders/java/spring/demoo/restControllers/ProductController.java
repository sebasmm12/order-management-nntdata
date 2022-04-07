/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.restControllers;

import com.nntdata.orders.java.spring.demoo.models.service.IProductService;
import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductUpdateRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.ProductInfoResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/products")
public class ProductController {
    
    private final Log logger = LogFactory.getLog(this.getClass());
    
    @Autowired
    private IProductService productService;
    
    @PostMapping()
    public ResponseEntity RegisterProduct(@RequestBody ProductRegisterRequest productRegisterRequest) {
        try {

           productService.RegisterProduct(productRegisterRequest); 
        } 
        catch (Exception e) {
           
            Logger.getLogger(this.getClass().getName()).log(Logger.Level.FATAL, e);
            
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());

        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Could register the product successfully");
    }
    
    @GetMapping("/{productId}")
    public ResponseEntity GetProductById(@PathVariable(name = "productId") long productId) {
        
        try {
            
           if(productId == 0) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't find the product");
           
           ProductInfoResponse product = productService.GetProductById(productId);
           
           return ResponseEntity.status(HttpStatus.CREATED).body(product);
            
        } catch (Exception e) {
            
           Logger.getLogger(this.getClass().getName()).log(Logger.Level.FATAL, e);
            
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
        }
    }
    
    @PutMapping("/{productId}")
    public ResponseEntity UpdateProduct(@PathVariable(name = "productId") long productId, @RequestBody ProductUpdateRequest productUpdateRequest) {
        
        try {
            
            if(productId == 0 || productId != productUpdateRequest.getId()) return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Couldn't find the product");
            
            productService.UpdateProduct(productUpdateRequest);
            
        } catch (Exception e) {
            
            Logger.getLogger(this.getClass().getName()).log(Logger.Level.FATAL, e);
            
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
            
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body("Could update the product successfully");
        
    }
}
