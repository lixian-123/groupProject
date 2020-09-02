package com.kgc.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tg-goods-provider")
public interface GoodsFeign {
    @RequestMapping("/checkNumberTeam")
    public int checkNumberTeam(@RequestParam("goodsId") Integer goodsId);
}
