package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.config.RabbitConfig;
import com.kgc.mapper.LeaderMapper;
import com.kgc.pojo.user.Leader;
import com.kgc.vo.Dto;
import com.kgc.vo.DtoUtil;
import com.kgc.vo.MqMessVo;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class RestLeaderService {

    @Resource
    private LeaderMapper leaderMapper;


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;



    @GetMapping("/testRedis")
    public String testRedis(){
        redisTemplate.opsForValue().set("lixian","11111");
        String lixian = (String) redisTemplate.opsForValue().get("lixian");
        System.out.println("lixian = " + lixian);


        Leader leader =new Leader("lixian","123456");
        // JSONObject.toJSONString()
        redisTemplate.opsForValue().set("token888888", JSON.toJSONString(leader));

        return "success";
    }



    @RequestMapping("/leaderlogin")
    public Leader getleaderLogin(@RequestParam Map<String,Object> param){
        Map<String,Object> map=new HashMap<>();
        String nickname=param.get("nickname").toString();
        String passWord=param.get("passWord").toString();
        map.put("nickname",nickname);
        map.put("passWord",passWord);
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
