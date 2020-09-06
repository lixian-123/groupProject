package com.kgc.service.impl;

import com.kgc.feign.LeaderMessFeign;
import com.kgc.pojo.leader.Leader_mess;
import com.kgc.service.LeaderMessService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaderMessServiceImpl implements LeaderMessService {
    @Autowired
    LeaderMessFeign messFeign;
    @Override
    public List<Leader_mess> getAllLeaderMess(Integer messTypeId) {
        return messFeign.getAllLeaderMess(messTypeId);
    }

    @Override
    public int add(Leader_mess leader_mess) {
        return messFeign.add(leader_mess);
    }


    @RabbitListener(queues ="lm")
    public void getMessFromRabbi(String mess) {
        System.out.println(mess);
    }
}
