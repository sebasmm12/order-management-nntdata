/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.implementation;

import com.nntdata.orders.java.spring.demoo.models.dao.IProductDao;
import com.nntdata.orders.java.spring.demoo.models.entity.Product;
import com.nntdata.orders.java.spring.demoo.models.entity.ProductCategory;
import com.nntdata.orders.java.spring.demoo.models.service.IProductCategoryService;
import com.nntdata.orders.java.spring.demoo.models.service.IProductService;
import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductRegisterRequest;
import com.nntdata.orders.java.spring.demoo.transport.request.product.ProductUpdateRequest;
import com.nntdata.orders.java.spring.demoo.transport.response.ProductInfoResponse;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sebastian
 */
@Service("ProductImplementation")
public class ProductImplementation implements IProductService {

    @Autowired
    private IProductDao productDao;
    
    @Autowired
    private IProductCategoryService productCategoryService;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public void RegisterProduct(ProductRegisterRequest productRegisterRequest) throws Exception {
        
        productCategoryService.VerifyProductCategory(productRegisterRequest.getProductCategoryID());
        
        Product product = modelMapper.map(productRegisterRequest, Product.class);
        
        PrepareProductRegister(product);
        
        product = productDao.save(product);
        
        if(product.getId() == 0) throw new Exception("Couldn't register the product");
    }
    
    private void PrepareProductRegister(Product product) {
        
        /* Se realiza una simulación de auditoría ya que actualmente no se trabaja con sesiones */
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        
        product.setId(0);
        product.setActive(true);
        product.setCreationDate(calendar.getTime());
        product.setCreationUserID(1);
    }

    @Override
    public void UpdateProduct(ProductUpdateRequest productUpdateRequest) throws Exception {
        
       productCategoryService.VerifyProductCategory(productUpdateRequest.getProductCategoryID());
       
       Product product = GetEntityProductById(productUpdateRequest.getId());
       
       product.setProductCategory(new ProductCategory());
       modelMapper.map(productUpdateRequest, product);
       
       PrepareProductUpdate(product);
       
       productDao.save(product);
    }
    
    private void PrepareProductUpdate(Product product) {
        
        /* Se realiza una simulación de auditoría ya que actualmente no se trabaja con sesiones */
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
        
        product.setUpdateDate(calendar.getTime());
        product.setUpdateUserID(1);
    }

    @Override
    public ProductInfoResponse GetProductById(long id) throws Exception {
       
        Product product = productDao.findById(id).orElse(null);
        
        if(product == null) throw new Exception("The product doesn't exist");
                
        ProductInfoResponse productInfo = modelMapper.map(product, ProductInfoResponse.class); 
        
        return productInfo;
        
    }
    
    private Product GetEntityProductById(long id) throws Exception {
       
        Product product = productDao.findById(id).orElse(null);
        
        if(product == null) throw new Exception("The product doesn't exist");

        return product;
        
    }

    @Override
    public void ValidateProductsToRegisterOrder(List<Long> productsIds) throws Exception {
       
        int totalProducts = productDao.ValidateProductsToRegisterOrder(productsIds);
        
        if(totalProducts != productsIds.size()) throw new Exception("The registered products for the order don't exist");
        
    }
}
