package com.kgc.service;

import com.kgc.mapper.Leader_yongjinMapper;
import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestLeaderYJ {
    @Autowired
    Leader_yongjinMapper yongjinMapper;
    public List<Leader_yongjin> getAllYongJin(Integer leaderId){
        return yongjinMapper.getAllYongJin(leaderId);
    }
    public int add(Leader_yongjin leader_yongjin){
        return yongjinMapper.add(leader_yongjin);
    }
    public int update(Leader_yongjin leader_yongjin){
        return yongjinMapper.update(leader_yongjin);
    }
}
