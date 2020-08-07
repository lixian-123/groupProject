package com.kgc.servie.impl;

import com.kgc.feign.RetailOrderFeign;
import com.kgc.pojo.order.RetailOrder;
import com.kgc.servie.RetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetailOrderServiceImpl implements RetailOrderService {
    @Autowired
    RetailOrderFeign retailOrderFeign;
    @Override
    public List<RetailOrder> getAllRetail(Integer userId, Integer leaderId) {
        return retailOrderFeign.showRetail(userId, leaderId);
    }

    @Override
    public int add(RetailOrder retailOrder) {
        return retailOrderFeign.addRetail(retailOrder);
    }

    @Override
    public int update(RetailOrder retailOrder) {
        return retailOrderFeign.updateRetail(retailOrder);
    }
}
