package com.kgc.servie.impl;

import com.kgc.feign.OrderDetailFeign;
import com.kgc.pojo.order.OrderDetail;
import com.kgc.servie.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    OrderDetailFeign detailFeign;
    @Override
    public List<OrderDetail> getAllDetail(Integer userId, Integer leaderId) {
        return detailFeign.showDetail(userId, leaderId);
    }

    @Override
    public int add(OrderDetail orderDetail) {
        return detailFeign.addDetail(orderDetail);
    }

    @Override
    public int update(OrderDetail orderDetail) {
        return detailFeign.updateDetail(orderDetail);
    }
}
