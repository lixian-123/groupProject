package com.kgc.mapper;

import com.kgc.pojo.order.OrderType;
import com.kgc.pojo.order.RetailOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface RetailOrderMapper {
    public List<RetailOrder> getAllRetail(@Param("userId")Integer userId,@Param("leaderId")Integer leaderId );
    public int add(RetailOrder retailOrder);
    public int update(RetailOrder retailOrder);
}
