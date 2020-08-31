package com.kgc.controller;

import com.kgc.servie.OrderService;
import com.kgc.vo.Dto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@CrossOrigin
public class OrderController {
    @Resource
    OrderService orderService;
    @RequestMapping("/UserMess")
    public Dto userMess(@RequestParam Map<String,Object> map){
        return orderService.UserMess(map);
    }
}
