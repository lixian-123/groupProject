package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_sale;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;
@Mapper

/**
 * 团长销售数据处理接口
 */
public interface Leader_saleMapper {
    public List<Leader_sale> getAllSale(Map<String,Object> map);
    public int add(Leader_sale leader_sale);
    public int update(Leader_sale leader_sale);

    //查看今日提成
    public String getTichengToday();

    //查看本月提成
    public String getTichengMonth();

}
