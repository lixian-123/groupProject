package com.kgc.Feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tg-user-provider")
public interface AliPayFeignClient {

    @RequestMapping("/pay")
    public String aliPay(@RequestParam("subjectName") String subjectName, @RequestParam("orderNo") String orderNo, @RequestParam("amount") String amount);

}
