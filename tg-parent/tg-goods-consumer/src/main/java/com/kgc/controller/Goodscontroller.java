package com.kgc.controller;

import com.kgc.pojo.goods.Goods;
import com.kgc.service.GoodsService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/showGoodsPage")
    PageUtil<Goods> getGoodsPage(@RequestParam(name = "index",required = false,defaultValue = "1") Integer index,
                                 @RequestParam(value = "size",required =false, defaultValue = "3")Integer size,
                                 String goodsname){
        return goodsService.getGoodsPage(index,size,goodsname);
    }

    @RequestMapping("/getGoodsById")
    Goods getGoodsById(Integer goodsid){
        return goodsService.getGoodsById(goodsid);
    }

    @RequestMapping("/addGoods")
    int insertGoods(@RequestBody Goods goods){
        return goodsService.insetGoods(goods);
    }

    @RequestMapping("/uodateGoods")
    int uodateGoods(@RequestBody Goods goods){
        return goodsService.updateGoods(goods);
    }

}
