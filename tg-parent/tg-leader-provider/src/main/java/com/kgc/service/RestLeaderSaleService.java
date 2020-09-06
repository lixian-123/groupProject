package com.kgc.service;

import com.kgc.mapper.Leader_saleMapper;
import com.kgc.pojo.leader.Leader_sale;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Map;

@RestController
public class RestLeaderSaleService {

    //调用mapper
    @Autowired
    private Leader_saleMapper saleMapper;

    @RequestMapping("/getSalePage")
    public PageUtil getSalePage(@RequestParam Map<String,Object> map){
        PageUtil page=new PageUtil();
        page.setPageIndex(Integer.parseInt(map.get("index").toString()));
        page.setPageSize(Integer.parseInt(map.get("size").toString()));
        List<Leader_sale> list=saleMapper.getAllSale(map);
        page.setList(list);
        int count=saleMapper.getCount(map);
        page.setTotalCount(count);
        return page;
    }

    @RequestMapping("/addSale")
    public int addSale(@RequestBody Leader_sale leader_sale){
        return saleMapper.add(leader_sale);
    }

    @RequestMapping("/getSaleById/{id}")
    public Leader_sale getSaleById(@PathVariable("id") Integer id){
        return saleMapper.getSaleById(id);
    }

    @RequestMapping("/updateSale")
    public int updateSale(@RequestBody Leader_sale leader_sale){
        return saleMapper.update(leader_sale);
    }

    @RequestMapping("/getTichengToday")
    public String getTichengToday(){
        return saleMapper.getTichengToday();
    }

    @RequestMapping("/getTichengMonth")
    public String getTichengMonth(){
        return saleMapper.getTichengMonth();
    }
}
