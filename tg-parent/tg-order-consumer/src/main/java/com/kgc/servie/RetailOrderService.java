package com.kgc.servie;

import com.kgc.pojo.order.RetailOrder;

import java.util.List;

public interface RetailOrderService {
    public List<RetailOrder> getAllRetail(Integer userId,Integer leaderId );
    public int add(RetailOrder retailOrder);
    public int update(RetailOrder retailOrder);
}
