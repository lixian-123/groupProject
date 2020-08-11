package com.kgc.controller;

import com.kgc.pojo.order.OrderDetail;
import com.kgc.servie.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailController {
    @Autowired
    OrderDetailService detailService;
    @RequestMapping("/showDetail")
    public List<OrderDetail> showDetail(@RequestParam("userId")Integer userId, @RequestParam("leaderId")Integer leaderId){
        return  detailService.getAllDetail(userId,leaderId);
    }
    @RequestMapping("/addDetail")
    public int addDetail(@RequestBody OrderDetail orderDetail){
        return  detailService.add(orderDetail);
    }
    @RequestMapping("/updateDetail")
    public int updateDetail(@RequestBody OrderDetail orderDetail){
        return  detailService.update(orderDetail);
    }
}
