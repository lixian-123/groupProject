package com.kgc.service;

import com.kgc.mapper.TeamOrderMapper;
import com.kgc.pojo.order.RetailOrder;
import com.kgc.pojo.order.TeamOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTeamOrderService {
    @Autowired
    TeamOrderMapper teamOrderMapper;
    @RequestMapping("/showTeam")
    public List<TeamOrder> showTeam(@RequestParam("leaderId")Integer leaderId){
        return  teamOrderMapper.getAllTeam(leaderId);
    }
    @RequestMapping("/addTeam")
    public int addTeam(@RequestBody TeamOrder teamOrder){
        return  teamOrderMapper.add(teamOrder);
    }
    @RequestMapping("/updateTeam")
    public int updateTeam(@RequestBody TeamOrder teamOrder){
        return  teamOrderMapper.update(teamOrder);
    }
    @RequestMapping("/deleteTeam")
    public int deleteTeam(@RequestParam("teamId")Integer teamId){
        return teamOrderMapper.delete(teamId);
    }
}
