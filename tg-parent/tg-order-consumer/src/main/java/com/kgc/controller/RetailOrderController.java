package com.kgc.controller;

import com.kgc.pojo.order.RetailOrder;
import com.kgc.servie.RetailOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RetailOrderController {
    @Autowired
    RetailOrderService retailOrderService;
    @RequestMapping("/showRetail") //已测
    public List<RetailOrder> showRetail(@RequestParam("userId")Integer userId, @RequestParam("leaderId")Integer leaderId){
        return  retailOrderService.getAllRetail(userId,leaderId);
    }
    @RequestMapping("/addRetail") //已测
    public int addRetail(@RequestBody RetailOrder retailOrder){
        return  retailOrderService.add(retailOrder);
    }
    @RequestMapping("/updateRetail") //已测
    public int updateRetail(@RequestBody RetailOrder retailOrder){
        return  retailOrderService.update(retailOrder);
    }
}
