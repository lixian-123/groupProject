package com.kgc.feign;

import com.kgc.pojo.order.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class OrderDetailFeignImpl implements OrderDetailFeign {
    @Override
    public List<OrderDetail> showDetail(Integer userId, Integer leaderId) {
        return null;
    }

    @Override
    public int addDetail(OrderDetail orderDetail) {
        return 0;
    }

    @Override
    public int updateDetail(OrderDetail orderDetail) {
        return 0;
    }
}
