package com.kgc.controller;

import com.kgc.service.Goodsservice;
import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class Goodscontroller {
    @Autowired
    private Goodsservice goodsservice;

   @RequestMapping("/getAllGoods")
   public PageUtil<Goods> getAllGoods(Integer cateid , String goodsname , Integer index, Integer size){
           return goodsservice.getPage(cateid,goodsname,index,size);
   }

    //根据id查询商品详细信息
    @RequestMapping("/getGoodsById")
    public Goods getByid(Integer id){
        return goodsservice.getPersonById(id);
    }
    //根据商品类别查询商品
    @RequestMapping("/getGoodsType")
    public List<Goods> getGoodsByType(String type){
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
