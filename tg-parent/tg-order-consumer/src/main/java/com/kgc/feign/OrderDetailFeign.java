package com.kgc.feign;

import com.kgc.pojo.order.OrderDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tg-order-provider",fallback = OrderDetailFeignImpl.class)
public interface OrderDetailFeign {
    @RequestMapping("/showDetail")
    public List<OrderDetail> showDetail(@RequestParam("userId")Integer userId, @RequestParam("leaderId")Integer leaderId);
    @RequestMapping("/addDetail")
    public int addDetail(@RequestBody OrderDetail orderDetail);
    @RequestMapping("/updateDetail")
    public int updateDetail(@RequestBody OrderDetail orderDetail);
}
