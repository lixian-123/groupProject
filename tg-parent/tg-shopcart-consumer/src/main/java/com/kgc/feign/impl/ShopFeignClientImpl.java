package com.kgc.feign.impl;

import com.kgc.feign.ShopFeignClient;
import com.kgc.pojo.shops.ShopCar;
import org.springframework.stereotype.Component;

@Component
public class ShopFeignClientImpl implements ShopFeignClient {
    @Override
    public ShopCar getShopById(Integer id) {
        return null;
    }

    @Override
    public int update(ShopCar shopCar) {
        return 0;
    }

    @Override
    public int add(ShopCar shopCar) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
