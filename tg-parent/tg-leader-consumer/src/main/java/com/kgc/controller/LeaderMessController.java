package com.kgc.controller;

import com.kgc.pojo.leader.Leader_mess;
import com.kgc.service.LeaderMessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderMessController {
    @Autowired
    LeaderMessService messService;
    @RequestMapping("showLeaderMess")
    public List<Leader_mess> getAllLeaderMess(@RequestParam("messTypeId")Integer messTypeId){
        return messService.getAllLeaderMess(messTypeId);
    }
    @RequestMapping("addLeaderMess")
    public int add(Leader_mess leader_mess){
        return messService.add(leader_mess);
    }
}
