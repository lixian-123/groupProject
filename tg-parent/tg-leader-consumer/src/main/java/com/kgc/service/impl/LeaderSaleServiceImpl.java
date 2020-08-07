package com.kgc.service.impl;

import com.kgc.feign.LeaderSaleFeign;
import com.kgc.pojo.leader.Leader_sale;
import com.kgc.service.LeaderSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LeaderSaleServiceImpl implements LeaderSaleService {
    @Autowired
    LeaderSaleFeign saleFeign;
    @Override
    public List<Leader_sale> getAllSale(Map<String,Object> map) {
        return saleFeign.getAllSale(map);
    }

    @Override
    public int add(Leader_sale leader_sale) {
        return saleFeign.add(leader_sale);
    }

    @Override
    public int update(Leader_sale leader_sale) {
        return saleFeign.update(leader_sale);
    }
}
