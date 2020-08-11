package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_sale;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface Leader_saleMapper {
    public List<Leader_sale> getAllSale(Map<String,Object> map);
    public int add(Leader_sale leader_sale);
    public int update(Leader_sale leader_sale);
}
