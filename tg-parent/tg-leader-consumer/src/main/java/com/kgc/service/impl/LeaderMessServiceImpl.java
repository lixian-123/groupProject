package com.kgc.service.impl;

import com.kgc.feign.LeaderMessFeign;
import com.kgc.pojo.leader.Leader_mess;
import com.kgc.service.LeaderMessService;
import com.kgc.util.PageUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaderMessServiceImpl implements LeaderMessService {
    @Autowired
    LeaderMessFeign messFeign;

    @Override
    public PageUtil<Leader_mess> getMessPage(Integer index, Integer size, Integer LeaderId) {
        Map<String,Object> map=new HashMap<>();
        map.put("index",(index-1)*size);
        map.put("size",size);
        map.put("LeaderId",LeaderId);

        return messFeign.getMessPage(map);
    }

    @Override
    public int insertMess(Leader_mess mess) {
        return messFeign.insertMess(mess);
    }

    @Override
    public Leader_mess getMessById(Integer id) {
        return messFeign.getMessById(id);
    }

    @Override
    public int updateMess(Leader_mess mess) {
        return messFeign.updateMess(mess);
    }

    @Override
    public int delMess(Integer id) {
        return messFeign.delMess(id);
    }

    @Override
    public List<Leader_mess> getAllMess(Integer LeaderId) {
        return messFeign.getAllMess(LeaderId);
    }

    //监听用户发送的消息
    @RabbitListener(queues ="lm")
    public void getMessFromRabbi(String mess) {
        System.out.println(mess);
    }
}
