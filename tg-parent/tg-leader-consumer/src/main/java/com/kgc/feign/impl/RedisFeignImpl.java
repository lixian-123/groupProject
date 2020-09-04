package com.kgc.feign.impl;

import com.kgc.feign.RedisFeign;
import org.springframework.stereotype.Component;

@Component
public class RedisFeignImpl implements RedisFeign {
    @Override
    public boolean saveTeamRedis(Object object) {
        return false;
    }
}
