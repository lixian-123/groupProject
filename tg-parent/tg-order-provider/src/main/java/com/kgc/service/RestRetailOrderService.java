package com.kgc.service;

import com.kgc.mapper.OrderDetailMapper;
import com.kgc.mapper.RetailOrderMapper;
import com.kgc.pojo.order.OrderDetail;
import com.kgc.pojo.order.RetailOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/RetailOrder")
public class RestRetailOrderService {
    @Autowired
    RetailOrderMapper retailMapper;
    @RequestMapping("/showRetail")
    public List<RetailOrder> showRetail(@RequestParam("userId")Integer userId, @RequestParam("leaderId")Integer leaderId){
        return  retailMapper.getAllRetail(userId,leaderId);
    }
    @RequestMapping("/addRetail")
    public int addRetail(@RequestBody RetailOrder retailOrder){
        return  retailMapper.add(retailOrder);
    }
    @RequestMapping("/updateRetail")
    public int updateRetail(@RequestBody RetailOrder retailOrder){
        return  retailMapper.update(retailOrder);
    }
}
