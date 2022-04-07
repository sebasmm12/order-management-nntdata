/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.service;

import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductUpdateRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.ProductInfoResponse;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IProductService {
    
    public void RegisterProduct(ProductRegisterRequest productRegisterRequest) throws Exception;
    public void UpdateProduct(ProductUpdateRequest productUpdateRequest) throws Exception;
    public ProductInfoResponse GetProductById(long id) throws Exception;
    public void ValidateProductsToRegisterOrder(List<Long> productsIds) throws Exception;
    
}
