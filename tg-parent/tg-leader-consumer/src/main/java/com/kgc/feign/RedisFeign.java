package com.kgc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tg-leader-provider")
public interface RedisFeign {
    @RequestMapping("/saveTeamRedis")
    public boolean saveTeamRedis(@RequestBody Object object);
}
