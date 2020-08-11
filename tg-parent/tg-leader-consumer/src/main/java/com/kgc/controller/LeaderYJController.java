package com.kgc.controller;

import com.kgc.pojo.leader.Leader_yongjin;
import com.kgc.service.LeaderYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LeaderYJController {
    @Autowired
    LeaderYJService yjService;
    @RequestMapping("/showLeaderYJ")
    public List<Leader_yongjin> getAllYongJin(@RequestParam("leaderId") Integer leaderId){
        return yjService.getAllYongJin(leaderId);
    }
    @RequestMapping("/addLeaderYJ")
    public int add(@RequestBody Leader_yongjin leader_yongjin){
        return yjService.add(leader_yongjin);
    }
    @RequestMapping("/updateLeaderYJ")
    public int update(@RequestBody Leader_yongjin leader_yongjin){
        return yjService.update(leader_yongjin);
    }
}
