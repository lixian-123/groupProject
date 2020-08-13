package com.kgc.service;

import com.kgc.mapper.Leader_messMapper;
import com.kgc.pojo.leader.Leader_mess;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestLeaderMessService {
    @Autowired
    Leader_messMapper messMapper;
    @RequestMapping("showLeaderMess")
    public List<Leader_mess> getAllLeaderMess(@RequestParam("messTypeId")Integer messTypeId){
        return messMapper.getAllLeaderMess(messTypeId);
    }
    @RequestMapping("addLeaderMess")
    public int add(Leader_mess leader_mess){
        return messMapper.add(leader_mess);
    }
}
