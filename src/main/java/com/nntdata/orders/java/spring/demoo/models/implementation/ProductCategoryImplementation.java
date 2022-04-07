/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.implementation;

import com.nntdata.orders.java.spring.demoo.models.dao.IProductCategoryDao;
import com.nntdata.orders.java.spring.demoo.models.entity.ProductCategory;
import com.nntdata.orders.java.spring.demoo.models.service.IProductCategoryService;
import com.nntdata.orders.java.spring.demoo.transport.response.ProductCategoryInfoResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastian
 */
@Service("ProductCategoryImplementation")
public class ProductCategoryImplementation implements IProductCategoryService {

    @Autowired
    private IProductCategoryDao productCategoryDao;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    @Transactional(readOnly = true)
    public List<ProductCategoryInfoResponse> GetProductCategories() throws Exception  {
       
        List<ProductCategory> productCategories = (List<ProductCategory>) productCategoryDao.findAll();
        
        if(productCategories == null) throw new Exception("Couldn't find the product categories");

        /* Mapeo para retorna la lista deseado en base a la lista obtenida de la categoría de productos */
        List<ProductCategoryInfoResponse> productsCategoriesInfo = productCategories.stream()
                                                                                      .map(productCategory -> modelMapper.map(productCategory, ProductCategoryInfoResponse.class))
                                                                                      .collect(Collectors.toList());
        
        return productsCategoriesInfo;
        
    }

    @Override
    public ProductCategoryInfoResponse GetProductCategory(long id) throws Exception {
        
        ProductCategory productCategory = productCategoryDao.findById(id).orElse(null);
        
        if(productCategory == null) throw new Exception("Product Category doesn't exist");
        
        ProductCategoryInfoResponse productCategoryInfo = modelMapper.map(productCategory, ProductCategoryInfoResponse.class);
        
        return productCategoryInfo;
        
    }

    @Override
    public void VerifyProductCategory(long id) throws Exception {
        
        boolean exists = productCategoryDao.existsById(id);
        
        if(!exists) throw new Exception("Product Category doesn't exist");
        
    }
}
