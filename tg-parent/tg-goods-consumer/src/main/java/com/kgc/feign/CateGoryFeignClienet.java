package com.kgc.feign;

import com.kgc.pojo.goods.Category;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "tg-goods-provider")
public interface CateGoryFeignClienet {
    @RequestMapping("/getCategory")
    public List<Category> getAllCategry();
}
