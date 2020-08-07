package com.kgc.feign;

import com.kgc.pojo.order.RetailOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tg-order-provider")
public interface RetailOrderFeign {
    @RequestMapping("/showRetail")
    public List<RetailOrder> showRetail(@RequestParam("userId")Integer userId, @RequestParam("leaderId")Integer leaderId);
    @RequestMapping("/addRetail")
    public int addRetail(@RequestBody RetailOrder retailOrder);
    @RequestMapping("/updateRetail")
    public int updateRetail(@RequestBody RetailOrder retailOrder);
}
