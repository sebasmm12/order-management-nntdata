/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.service;

import com.nntdata.orders.java.spring.demoo.transport.response.ProductCategoryInfoResponse;
import java.util.List;

/**
 *
 * @author Sebastian
 */
public interface IProductCategoryService {
    
    public List<ProductCategoryInfoResponse> GetProductCategories() throws Exception;
    
    public ProductCategoryInfoResponse GetProductCategory(long id) throws Exception;
    
    public void VerifyProductCategory(long id) throws Exception;
    
}
