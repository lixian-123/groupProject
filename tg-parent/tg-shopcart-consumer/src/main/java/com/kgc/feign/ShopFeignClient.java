package com.kgc.feign;


import com.kgc.feign.impl.ShopFeignClientImpl;
import com.kgc.pojo.shops.ShopCar;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "tg-shopcart-provider",fallback = ShopFeignClientImpl.class)
public interface ShopFeignClient {

    @RequestMapping("/shopid/{id}")
    public ShopCar getShopById(@PathVariable("id") Integer id);

    @RequestMapping("/shopupdate")
    public int update(@RequestBody ShopCar shopCar);

    @RequestMapping("/shopadd")
    public int add(@RequestBody ShopCar shopCar);

    @RequestMapping("/shopdelete/{id}")
    public int delete(@PathVariable("id") Integer id);

}
