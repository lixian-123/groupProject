package com.kgc.mapper;

import com.kgc.pojo.order.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * 订单详情
 */
import java.util.List;

public interface OrderDetailMapper {
    public List<OrderDetail> getAllDetail(@Param("userId") Integer userId,@Param("leaderId")Integer leaderId );
    public int add(OrderDetail orderDetail);
    public int update(OrderDetail orderDetail);
}
