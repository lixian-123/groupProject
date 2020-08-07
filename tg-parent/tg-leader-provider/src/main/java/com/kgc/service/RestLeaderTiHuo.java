package com.kgc.service;

import com.kgc.mapper.Leader_tihuoMapper;
import com.kgc.pojo.leader.Leader_tihuo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestLeaderTiHuo {
    @Autowired
    Leader_tihuoMapper tihuoMapper;
    //查询团长的所有提货记录
    public List<Leader_tihuo> getAllTiHuo(Integer leaderId){
        return tihuoMapper.getAllTiHuo(leaderId);
    }
    //添加提货记录
    public int add(Leader_tihuo leader_tihuo){
        return tihuoMapper.add(leader_tihuo);
    }
}
