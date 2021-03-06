package com.kgc.controller;

import com.kgc.pojo.order.TeamOrder;
import com.kgc.service.LeaderService;
import com.kgc.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@CrossOrigin
public class LeaderController {
    @Autowired
    LeaderService leaderService;

    @RequestMapping("/addTeam")
    public int addTeam(@RequestBody TeamOrder teamOrder){
        if(leaderService.addTeam(teamOrder)>0){
            TeamOrder teamOrder1=leaderService.getTeamOrder(teamOrder.getStartTime(),teamOrder.getEndTime());
            if(leaderService.saveTeamRedis(teamOrder1)){
                return 1;
            }
        }
        return 0;
    }
}
