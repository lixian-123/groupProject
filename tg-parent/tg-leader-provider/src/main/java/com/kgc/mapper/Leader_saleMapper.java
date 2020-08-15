package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_sale;


import java.util.List;
import java.util.Map;

public interface Leader_saleMapper {
    public List<Leader_sale> getAllSale(Map<String,Object> map);
    public int add(Leader_sale leader_sale);
    public int update(Leader_sale leader_sale);

    //团购订单完成，给团长结算提成

    //查看今日提成
    public String getTichengToday();

    //查看本月提成
    public String getTichengMonth();

}
