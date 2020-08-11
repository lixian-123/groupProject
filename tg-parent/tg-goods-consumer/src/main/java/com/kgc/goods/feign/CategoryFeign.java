package com.kgc.goods.feign;


import com.kgc.pojo.goods.Category;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "my-provider",fallback = CategoryFeignimpl.class)
public interface CategoryFeign {
    @RequestMapping("/getAllCate")
    public List<Category> getAllCate();
}
