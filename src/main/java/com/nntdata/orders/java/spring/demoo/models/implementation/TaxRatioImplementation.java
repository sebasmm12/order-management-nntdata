/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nntdata.orders.java.spring.demoo.models.implementation;

import com.nntdata.orders.java.spring.demoo.models.dao.ITaxRatioDao;
import com.nntdata.orders.java.spring.demoo.models.entity.TaxRatio;
import com.nntdata.orders.java.spring.demoo.models.service.ITaxRatioService;
import com.nntdata.orders.java.spring.demoo.transport.response.TaxRatioInfoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastian
 */
@Service("TaxRatioImplementation")
public class TaxRatioImplementation implements ITaxRatioService {

    @Autowired
    private ITaxRatioDao taxRatioDao;
    
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    @Transactional(readOnly = true)
    public TaxRatioInfoResponse GetLastTaxRatio() throws Exception {
       
        TaxRatio taxRatio = taxRatioDao.GetLastTaxRatio();
        
        if(taxRatio == null) throw new Exception("Couldn't find the ratios");
        
        TaxRatioInfoResponse taxRatioInfo = modelMapper.map(taxRatio, TaxRatioInfoResponse.class);
        
        return taxRatioInfo;
    }
}
