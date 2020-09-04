package com.kgc.feign;

import com.kgc.pojo.order.TeamOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tg-order-provider",fallback = TeamOrderFeign.class)
public interface TeamOrderFeign {
    @RequestMapping("/getTeamOrder")
    public TeamOrder getTeamOrder(@RequestParam("startTime")String startTime, @RequestParam("endTime")String endTime);
}
