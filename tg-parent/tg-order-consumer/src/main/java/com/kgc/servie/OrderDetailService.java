package com.kgc.servie;

import com.kgc.pojo.order.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    public List<OrderDetail> getAllDetail(Integer userId,Integer leaderId );
    public int add(OrderDetail orderDetail);
    public int update(OrderDetail orderDetail);
}
