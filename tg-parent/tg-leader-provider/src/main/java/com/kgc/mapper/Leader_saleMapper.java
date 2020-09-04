package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_sale;


import java.util.List;
import java.util.Map;

/**
 * 团长销售数据处理接口
 */
public interface Leader_saleMapper {
    /**
     * 流水分页信息
     * @param map
     * @return
     */
    List<Leader_sale> getAllSale(Map<String,Object> map);
    int getCount(Map<String,Object> map);

    /**
     * 流水添加
     * @param leader_sale
     * @return
     */
    int add(Leader_sale leader_sale);

    /**
     * 流水更改
     * @param id
     * @return
     */
    Leader_sale getSaleById(Integer id);
    int update(Leader_sale leader_sale);


    //查看今日提成
    String getTichengToday();

    //查看本月提成
    String getTichengMonth();

}
