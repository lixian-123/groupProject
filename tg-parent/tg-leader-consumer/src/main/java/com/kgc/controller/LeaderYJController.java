package com.kgc.controller;

import com.kgc.pojo.leader.Leader_yongjin;
import com.kgc.service.LeaderYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class LeaderYJController {
    @Autowired
    LeaderYJService yjService;

    @RequestMapping("/getYongJinByLeader")
    public Leader_yongjin getYongJinByLeader(Integer leaderId){
        return yjService.getYongJinByLeader(leaderId);
    }

    @RequestMapping("/updateYongjin")
    public int updateYongjin(Leader_yongjin yongjin){
        return yjService.updateYongjin(yongjin);
    }

    @RequestMapping("/addYongjin")
    public int addYongjin(Leader_yongjin yongjin){
        return yjService.addYongjin(yongjin);
    }
}
