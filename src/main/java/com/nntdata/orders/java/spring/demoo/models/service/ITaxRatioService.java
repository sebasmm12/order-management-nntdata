/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.service;

import com.nntdata.orders.java.spring.demoo.models.entity.TaxRatio;
import com.nntdata.orders.java.spring.demoo.transport.response.TaxRatioInfoResponse;

/**
 *
 * @author Sebastian
 */
public interface ITaxRatioService {
    
    public TaxRatioInfoResponse GetLastTaxRatio() throws Exception;
    
}
