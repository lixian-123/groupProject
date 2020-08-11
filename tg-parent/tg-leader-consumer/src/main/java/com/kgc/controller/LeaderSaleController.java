package com.kgc.controller;

import com.kgc.pojo.leader.Leader_sale;
import com.kgc.service.LeaderSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LeaderSaleController {
    @Autowired
    LeaderSaleService saleService;
    @RequestMapping("showLeaderSale")
    public List<Leader_sale> getAllSale(@RequestParam Map<String,Object> map){
        return saleService.getAllSale(map);
    }
    @RequestMapping("addLeaderSale")
    public int add(@RequestBody Leader_sale leader_sale){
        return saleService.add(leader_sale);
    }
    @RequestMapping("updateLeaderSale")
    public int update(@RequestBody Leader_sale leader_sale){
        return saleService.update(leader_sale);
    }
}
