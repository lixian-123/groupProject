package com.kgc.feign.impl;

import com.kgc.feign.LeaderSaleFeign;
import com.kgc.pojo.leader.Leader_sale;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LeaderSaleFeignImpl implements LeaderSaleFeign{


    @Override
    public PageUtil getSalePage(Map<String, Object> map) {
        return null;
    }

    @Override
    public int addSale(Leader_sale leader_sale) {
        return 0;
    }

    @Override
    public Leader_sale getSaleById(Integer id) {
        return null;
    }

    @Override
    public int updateSale(Leader_sale leader_sale) {
        return 0;
    }

    @Override
    public String getTichengToday() {
        return null;
    }

    @Override
    public String getTichengMonth() {
        return null;
    }
}
