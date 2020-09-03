package com.kgc.service;

import com.kgc.mapper.Leader_saleMapper;
import com.kgc.pojo.leader.Leader_sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RestLeaderSaleService {
    @Autowired
    Leader_saleMapper saleMapper;
    @RequestMapping("showLeaderSale")
    public List<Leader_sale> getAllSale(@RequestParam Map<String,Object> map){
        return saleMapper.getAllSale(map);
    }
    @RequestMapping("addLeaderSale")
    public int add(@RequestBody Leader_sale leader_sale){
        return saleMapper.add(leader_sale);
    }
    @RequestMapping("updateLeaderSale")
    public int update(@RequestBody Leader_sale leader_sale){
        return saleMapper.update(leader_sale);
    }
}
