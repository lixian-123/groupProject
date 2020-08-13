package com.kgc.service;

import com.kgc.mapper.Leader_tihuoMapper;
import com.kgc.pojo.leader.Leader_tihuo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestLeaderTiHuoService {
    @Autowired
    Leader_tihuoMapper tihuoMapper;
    //查询团长的所有提货记录
    @RequestMapping("/showLeaderTihuo")
    public List<Leader_tihuo> getAllTiHuo(@RequestParam("leaderId") Integer leaderId){
        return tihuoMapper.getAllTiHuo(leaderId);
    }
    //添加提货记录
    @RequestMapping("/addLeaderTihuo")
    public int add(@RequestBody Leader_tihuo leader_tihuo){
        return tihuoMapper.add(leader_tihuo);
    }
}
