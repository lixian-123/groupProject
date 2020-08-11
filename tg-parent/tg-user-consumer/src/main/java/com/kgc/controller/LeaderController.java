package com.kgc.controller;

import com.kgc.pojo.user.Leader;
import com.kgc.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class LeaderController {

    @Autowired
    private LeaderService leaderService;


    @RequestMapping("/leaderlogin")
    public Leader getleaderLogin(String nickname,String passWord){
        return leaderService.getleaderLogin(nickname,passWord);
    }

    @RequestMapping("/leaderid/{id}")
    public Leader getLeaderById(@PathVariable("id") Integer id){
        return leaderService.getLeaderById(id);
    }

    @RequestMapping("/leaderupdate")
    public int update( @RequestBody Leader leader){
        return leaderService.update(leader);
    }

    @RequestMapping("/leaderadd")
    public int add(@RequestBody Leader leader){
        return leaderService.add(leader);
    }


    @RequestMapping("/leaderdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return leaderService.delete(id);
    }

}
