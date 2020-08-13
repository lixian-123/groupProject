package com.kgc.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestLeaderService {
    public boolean saveTeamRedis(String key,Object object){
        return false;
    }
}
