package com.kgc.feign;

import com.kgc.pojo.order.TeamOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "tg-order-provider")
public interface LeaderFeign {
    @RequestMapping("/addTeam")
    public int addTeam(@RequestBody TeamOrder teamOrder);
}
