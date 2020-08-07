package com.kgc.service;

import com.kgc.mapper.Leader_saleMapper;
import com.kgc.pojo.leader.Leader_sale;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestLeaderSale {
    @Autowired
    Leader_saleMapper saleMapper;
    public List<Leader_sale> getAllSale(Map<String,Object> map){
        Integer leaderId=Integer.parseInt(map.get("leaderId").toString());
        String todayTime=map.get("todayTime").toString();
        return saleMapper.getAllSale(leaderId,todayTime);
    }
    public int add(Leader_sale leader_sale){
        return saleMapper.add(leader_sale);
    }
    public int update(Leader_sale leader_sale){
        return saleMapper.update(leader_sale);
    }
}
