package com.kgc.service;

import com.kgc.pojo.shops.ShopCar;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ShopService {

    public ShopCar getShopById(@PathVariable("id") Integer id);

    public int update(@RequestBody ShopCar shopCar);

    public int add(@RequestBody ShopCar shopCar);

    public int delete(@PathVariable("id") Integer id);
}
