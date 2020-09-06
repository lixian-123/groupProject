package com.kgc.controller;

import com.kgc.pojo.leader.Leader_sale;
import com.kgc.service.LeaderSaleService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class LeaderSaleController {
    @Autowired
    LeaderSaleService saleService;

    @RequestMapping("/getSalePage")
    public PageUtil getSalePage(Integer index, Integer size, Integer LeaderId){
        return saleService.getSalePage(index, size, LeaderId);
    }

    @RequestMapping("/addSale")
    public int addSale(Leader_sale leader_sale){
        return saleService.addSale(leader_sale);
    }

    @RequestMapping("/getSaleById")
    public Leader_sale getSaleById(Integer id){
        return saleService.getSaleById(id);
    }

    @RequestMapping("/updateSale")
    public int updateSale(Leader_sale leader_sale){
        return saleService.updateSale(leader_sale);
    }

    @RequestMapping("/getTichengToday")
    public String getTichengToday(){
        return saleService.getTichengToday();
    }

    @RequestMapping("/getTichengMonth")
    public String getTichengMonth(){
        return saleService.getTichengMonth();
    }

}
