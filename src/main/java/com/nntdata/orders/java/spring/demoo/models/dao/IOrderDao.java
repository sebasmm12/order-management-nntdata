/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.dao;


import com.nntdata.orders.java.spring.demoo.models.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author Sebastian
 */
public interface IOrderDao extends PagingAndSortingRepository<Order, Long> {
   
}
