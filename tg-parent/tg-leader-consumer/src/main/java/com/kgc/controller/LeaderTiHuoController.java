package com.kgc.controller;

import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.service.LeaderTiHuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderTiHuoController {
    @Autowired
    LeaderTiHuoService tiHuoService;
    @RequestMapping("/showLeaderTihuo")
    public List<Leader_tihuo> getAllTiHuo(@RequestParam("leaderId") Integer leaderId){
        return tiHuoService.getAllTiHuo(leaderId);
    }
    //添加提货记录
    @RequestMapping("/addLeaderTihuo")
    public int add(@RequestBody Leader_tihuo leader_tihuo){
        return tiHuoService.add(leader_tihuo);
    }
}
