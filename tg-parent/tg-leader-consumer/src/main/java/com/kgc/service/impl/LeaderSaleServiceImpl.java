package com.kgc.service.impl;

import com.kgc.feign.LeaderSaleFeign;
import com.kgc.pojo.leader.Leader_sale;
import com.kgc.service.LeaderSaleService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaderSaleServiceImpl implements LeaderSaleService {
    @Autowired
    LeaderSaleFeign saleFeign;


    @Override
    public PageUtil getSalePage(Integer index, Integer size, Integer LeaderId) {
        Map<String,Object> map=new HashMap<>();
        map.put("index",(index-1)*size);
        map.put("size",size);
        map.put("LeaderId",LeaderId);

        return saleFeign.getSalePage(map);
    }

    @Override
    public int addSale(Leader_sale leader_sale) {
        return saleFeign.addSale(leader_sale);
    }

    @Override
    public Leader_sale getSaleById(Integer id) {
        return saleFeign.getSaleById(id);
    }

    @Override
    public int updateSale(Leader_sale leader_sale) {
        return saleFeign.updateSale(leader_sale);
    }

    @Override
    public String getTichengToday() {
        return saleFeign.getTichengToday();
    }

    @Override
    public String getTichengMonth() {
        return saleFeign.getTichengMonth();
    }
}
