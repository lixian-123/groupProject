package com.kgc.feign.impl;

import com.kgc.feign.LeaderSaleFeign;
import com.kgc.pojo.leader.Leader_sale;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LeaderSaleFeignImpl implements LeaderSaleFeign {
    @Override
    public List<Leader_sale> getAllSale(Map<String, Object> map) {
        return null;
    }

    @Override
    public int add(Leader_sale leader_sale) {
        return 0;
    }

    @Override
    public int update(Leader_sale leader_sale) {
        return 0;
    }
}
