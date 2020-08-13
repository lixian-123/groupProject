package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.util.RedisUtils;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class RestLeaderService {
    @Resource
    RedisUtils redisUtils;
    @RequestMapping("/saveTeamRedis")
    public boolean saveTeamRedis(@RequestBody TeamOrder teamOrder){
        String key="TeamGoods_"+teamOrder.getTeamId();
        return redisUtils.set(key, JSON.toJSONString(teamOrder));
    }

}
