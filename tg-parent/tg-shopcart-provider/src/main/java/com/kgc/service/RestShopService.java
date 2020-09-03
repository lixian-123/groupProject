package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.mapper.ShopMapper;
import com.kgc.pojo.shops.ShopCar;
import com.kgc.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@RestController
public class RestShopService {

    @Resource
    private ShopMapper shopMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("/shopid/{id}")
    public ShopCar getShopById(@PathVariable("id") Integer id){
        return shopMapper.getShopById(id);
    }

    @RequestMapping("/shopupdate")
    public int update(@RequestBody ShopCar shopCar){
        return shopMapper.update(shopCar);
    }

    //加入购物车并保存到redis
    @RequestMapping("/shopadd")
    public int add(@RequestBody ShopCar shopCar){
        /*ShopCar shopCar1=shopMapper.add(shopCar);
        String token="token:";
        token+= MD5.getMd5(shopCar1.getShopTime(),8)+"-";
        token+=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(shopCar1!=null){
            redisTemplate.opsForValue().set(token, JSON.toJSONString(shopCar1),2*60*60, TimeUnit.SECONDS);
        }*/
        return shopMapper.add(shopCar);
    }


    @RequestMapping("/shopdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return shopMapper.delete(id);
    }

}
