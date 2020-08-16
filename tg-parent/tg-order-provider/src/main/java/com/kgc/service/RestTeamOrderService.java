package com.kgc.service;

import com.kgc.mapper.TeamOrderMapper;
import com.kgc.pojo.order.RetailOrder;
import com.kgc.pojo.order.TeamOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
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
    @RequestMapping("/showVersion")
    public int getVersion(@RequestParam("teamId")Integer teamId){
        return  teamOrderMapper.getVersion(teamId);
    }
    @RequestMapping("/updateGoodsNum")
    public int updateGoodsNum(@RequestParam("teamId")Integer teamId,@RequestParam("versionValue")Integer versionValue,@RequestParam("goodsNumber")Integer goodsNumber){
        Map<String,Object> map=new HashMap<>();
        map.put("teamId",teamId);
        map.put("versionValue",versionValue);
        map.put("goodsNumber",goodsNumber);
        return teamOrderMapper.updateGoodsNum(map);
    }
}
