package com.kgc.service;

import com.kgc.mapper.LeaderMapper;
import com.kgc.pojo.user.Leader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class RestLeaderService {

    @Autowired
    private LeaderMapper leaderMapper;

    @RequestMapping("/leaderlogin")
    public Leader getleaderLogin(@RequestParam Map<String,Object> param){
        Map<String,Object> map=new HashMap<>();
        String nickname=param.get("nickname").toString();
        String PassWord=param.get("PassWord").toString();
        map.put("nickname",nickname);
        map.put("PassWord",PassWord);
        return leaderMapper.LeaderLogin(map);
    }

    @RequestMapping("/leaderid/{id}")
    public Leader getLeaderById(@PathVariable("id") Integer id){
        return leaderMapper.getLeaderById(id);
    }

    @RequestMapping("/leaderupdate")
    public int update( @RequestBody Leader leader){
        return leaderMapper.update(leader);
    }

    @RequestMapping("/leaderadd")
    public int add(@RequestBody Leader leader){
        return leaderMapper.add(leader);
    }


    @RequestMapping("/leaderdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return leaderMapper.delete(id);
    }




}
