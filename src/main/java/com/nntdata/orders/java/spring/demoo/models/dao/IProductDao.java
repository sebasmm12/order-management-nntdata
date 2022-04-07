/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.dao;

import com.nntdata.orders.java.spring.demoo.models.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Sebastian
 */
public interface IProductDao extends PagingAndSortingRepository<Product, Long> {
    
    @Query("select count(1)"
           + " from Product P"
           + " where P.id IN :productsIds")
    public int ValidateProductsToRegisterOrder(@Param("productsIds") List<Long> productsIds);
}
