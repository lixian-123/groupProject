package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.kgc.mapper.MemberMapper;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.pojo.user.Member;
import com.kgc.util.MD5;
import com.kgc.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
public class RestMemberService {

    @Autowired
    private MemberMapper memberMapper;
    @Resource
    RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("/memberlogin")
    public Member getLogin(@RequestParam Map<String,Object> param){
        Map<String,Object> map=new HashMap<>();
        String nickname=param.get("nickname").toString();
        String passWord=param.get("passWord").toString();
        map.put("nickname",nickname);
        map.put("passWord",passWord);

        //保存用户到redis
        Member member=memberMapper.MemberLogin(map);
        String token="token:";
        token+= MD5.getMd5(member.getUserPhone(),8)+"-";
        token+=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(member!=null){
            redisTemplate.opsForValue().set(token,JSON.toJSONString(member),2*60*60, TimeUnit.SECONDS);
        }
        return memberMapper.MemberLogin(map);
    }

    @RequestMapping("/memberid/{id}")
    public Member getMemberById(@PathVariable("id") Integer id){
        return memberMapper.getMemberById(id);
    }

    @RequestMapping("/memberupdate")
    public int update(@RequestBody Member member){
        return memberMapper.update(member);
    }

    @RequestMapping("/memberadd")
    public int add(@RequestBody Member member){
        return memberMapper.add(member);
    }


    @RequestMapping("/memberdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return memberMapper.delete(id);
    }

    //从redis获取用户
    @RequestMapping("/getMemberFromRedis")
    public Member getMemberFromRedis(@RequestParam("token") String token){
        if(redisUtils.exist(token)){
            String jsonStr=redisTemplate.opsForValue().get(token).toString();
            Member member=JSONObject.parseObject(jsonStr,Member.class);
            if(member!=null){
                return member;
            }
        }
        return null;
    }
    @RequestMapping("/getTeam")
    public TeamOrder getTeamFromRedis(@RequestParam("key") String key){
        if(redisUtils.exist(key)){
            String jsonStr=redisUtils.get(key).toString();
            TeamOrder teamOrder=JSONObject.parseObject(jsonStr,TeamOrder.class);
            if(teamOrder!=null){
                return teamOrder;
            }
        }
        return null;
    }
}
