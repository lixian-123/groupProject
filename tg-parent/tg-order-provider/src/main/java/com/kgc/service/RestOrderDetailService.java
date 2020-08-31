package com.kgc.service;

import com.kgc.mapper.OrderDetailMapper;
import com.kgc.pojo.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/OrderDetail")
public class RestOrderDetailService {
    @Autowired
    OrderDetailMapper detailMapper;
    @RequestMapping("/showDetail")
    public List<OrderDetail> showDetail(@RequestParam("userId")Integer userId,@RequestParam("leaderId")Integer leaderId){
        System.out.println("成功");
        return  detailMapper.getAllDetail(userId,leaderId);
    }
    @RequestMapping("/addDetail")
    public int addDetail(@RequestBody OrderDetail orderDetail){
        return  detailMapper.add(orderDetail);
    }
    @RequestMapping("/updateDetail")
    public int updateDetail(@RequestBody OrderDetail orderDetail){
        return  detailMapper.update(orderDetail);
    }
}
