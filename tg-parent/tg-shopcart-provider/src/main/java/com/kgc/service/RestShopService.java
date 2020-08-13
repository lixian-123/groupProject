package com.kgc.service;

import com.kgc.mapper.ShopMapper;
import com.kgc.pojo.shops.ShopCar;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RestShopService {

    @Resource
    private ShopMapper shopMapper;

    @RequestMapping("/shopid/{id}")
    public ShopCar getShopById(@PathVariable("id") Integer id){
        return shopMapper.getShopById(id);
    }

    @RequestMapping("/shopupdate")
    public int update(@RequestBody ShopCar shopCar){
        return shopMapper.update(shopCar);
    }

    @RequestMapping("/shopadd")
    public int add(@RequestBody ShopCar shopCar){
        return shopMapper.add(shopCar);
    }


    @RequestMapping("/shopdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return shopMapper.delete(id);
    }

}
