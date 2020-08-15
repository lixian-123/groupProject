package com.kgc.service;

import com.kgc.pojo.leader.Leader_sale;

import java.util.List;
import java.util.Map;

public interface LeaderSaleService {
    public List<Leader_sale> getAllSale(Map<String,Object> map);
    public int add(Leader_sale leader_sale);
    public int update(Leader_sale leader_sale);

    public String getTichengToDay();
    public String getTichengMonth();
}
