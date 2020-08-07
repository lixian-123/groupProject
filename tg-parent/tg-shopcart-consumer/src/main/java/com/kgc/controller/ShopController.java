package com.kgc.controller;

import com.kgc.pojo.shops.ShopCar;
import com.kgc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;


    @RequestMapping("/shopid/{id}")
    public ShopCar getShopById(@PathVariable("id") Integer id){
        return shopService.getShopById(id);
    }

    @RequestMapping("/shopupdate")
    public int update(@RequestBody ShopCar shopCar){
        return shopService.update(shopCar);
    }

    @RequestMapping("/shopadd")
    public int add(@RequestBody ShopCar shopCar){
        return shopService.add(shopCar);
    }


    @RequestMapping("/shopdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return shopService.delete(id);
    }

}
