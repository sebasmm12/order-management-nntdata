/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.dao;

import com.nntdata.orders.java.spring.demoo.models.entity.TaxRatio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Sebastian
 */
public interface ITaxRatioDao extends CrudRepository<TaxRatio, Long> {
    
    @Query("select tR from TaxRatio tR"
            + " where tR.active = 1")
    public TaxRatio GetLastTaxRatio();
    
}
