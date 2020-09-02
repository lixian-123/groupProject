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


    @RequestMapping("/shopid/{id}") //已测
    public ShopCar getShopById(@PathVariable("id") Integer id){
        return shopService.getShopById(id);
    }

    @RequestMapping("/shopupdate") //已测
    public int update(@RequestBody ShopCar shopCar){
        return shopService.update(shopCar);
    }

    @RequestMapping("/shopadd") //已测
    public int add(@RequestBody ShopCar shopCar){
        return shopService.add(shopCar);
    }


    @RequestMapping("/shopdelete/{id}") //已测
    public int delete(@PathVariable("id") Integer id){
        return shopService.delete(id);
    }

}
