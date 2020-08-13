package com.kgc.service.impl;

import com.kgc.feign.ShopFeignClient;
import com.kgc.pojo.shops.ShopCar;
import com.kgc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopFeignClient shopFeignClient;

    @Override
    public ShopCar getShopById(Integer id) {
        return shopFeignClient.getShopById(id);
    }

    @Override
    public int update(ShopCar shopCar) {
        return shopFeignClient.update(shopCar);
    }

    @Override
    public int add(ShopCar shopCar) {
        return shopFeignClient.add(shopCar);
    }

    @Override
    public int delete(Integer id) {
        return shopFeignClient.delete(id);
    }
}
