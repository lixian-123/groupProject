package com.kgc.goods.controller;

import com.kgc.goods.service.Goodsservice;
import com.kgc.pojo.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Goodscontroller {
    @Autowired
    private Goodsservice goodsservice;

    //    @RequestMapping("/getAllGoods")
//    public PageUtil getAllGoods(@RequestParam Map<String ,Object> parma){

//
//    }

    //根据id查询商品详细信息
    @RequestMapping("/getGoodsById")
    public Goods getByid(Integer id){
        return goodsservice.getPersonById(id);
    }
    //根据商品类别查询商品
    @RequestMapping("/getGoodsType")
    public Goods getGoodsByType(String type){
        return goodsservice.getGoodsByType(type);
    }

    //添加商品
    @RequestMapping("/goodsAdd")
    public int getAdd(Goods goods){
        int count=goodsservice.goodsAdd(goods);
        return count;
    }
    //删除商品
    @RequestMapping("/goodsdelete/{id}")
    public int goodsDelete(Integer id){
        return goodsservice.goodsDelete(id);
    }
    //修改商品
    @RequestMapping("/goodsupdate")
    public int goodsUpdate(Goods goods){
        return goodsservice.goodsUpdate(goods);
    }
}
