package com.kgc.controller;

import com.kgc.pojo.order.TeamOrder;
import com.kgc.servie.TeamOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeamOrderController {
    @Autowired
    TeamOrderService teamOrderService;
    @RequestMapping("/showTeam")
    public List<TeamOrder> showTeam(@RequestParam("leaderId")Integer leaderId){
        return  teamOrderService.getAllTeam(leaderId);
    }
    @RequestMapping("/addTeam")
    public int addTeam(@RequestBody TeamOrder teamOrder){
        return  teamOrderService.add(teamOrder);
    }
    @RequestMapping("/updateTeam")
    public int updateTeam(@RequestBody TeamOrder teamOrder){
        return  teamOrderService.update(teamOrder);
    }
    @RequestMapping("/deleteTeam")
    public int deleteTeam(@RequestParam("teamId")Integer teamId){
        return teamOrderService.delete(teamId);
    }
}
