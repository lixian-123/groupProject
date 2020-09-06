package com.kgc.controller;

import com.kgc.pojo.user.Leader;
import com.kgc.service.LeaderService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LeaderController {

    @Autowired
    private LeaderService leaderService;

    @RequestMapping("/getLeaderPage")
    public PageUtil<Leader> getLeaderPage( Integer index,Integer size,String LeaaderName){
        return leaderService.getLeaderPage(index,size,LeaaderName);
    }
    //团长登陆
    @RequestMapping("/leaderlogin") //已测
    public Leader getleaderLogin(String nickname,String passWord){
        return leaderService.getleaderLogin(nickname,passWord);
    }

    //查询团长详细信息
    @RequestMapping("/leaderid/{id}") //已测
    public Leader getLeaderById(@PathVariable("id") Integer id){
        return leaderService.getLeaderById(id);
    }

    //修改团长信息
    @RequestMapping("/leaderupdate") //已测
    public int update( @RequestBody Leader leader){
        return leaderService.update(leader);
    }

    //添加团长
    @RequestMapping("/leaderadd") //已测
    public int add(@RequestBody Leader leader){
        return leaderService.add(leader);
    }


    //删除团长
    @RequestMapping("/leaderdelete/{id}") //已测
    public int delete(@PathVariable("id") Integer id){
        return leaderService.delete(id);
    }

}
