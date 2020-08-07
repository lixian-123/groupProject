package com.kgc.service;

import com.kgc.mapper.OrderDetailMapper;
import com.kgc.pojo.order.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.List;

@RestController
public class RestOrderDetailService {
    @Autowired
    OrderDetailMapper detailMapper;
    @RequestMapping("/showDetail")
    public List<OrderDetail> showDetail(@RequestParam("userId")Integer userId,@RequestParam("leaderId")Integer leaderId){
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
