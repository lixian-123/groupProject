package com.kgc.feign;

import com.kgc.pojo.user.Member;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="tg-user-provider")
public interface MemberFeign {
    @RequestMapping("/getMemberFromRedis")
    public Member getMemberFromRedis(@RequestParam("token") String token);
}
