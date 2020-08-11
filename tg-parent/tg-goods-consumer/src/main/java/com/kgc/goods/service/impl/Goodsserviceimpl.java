package com.kgc.goods.service.impl;

import com.kgc.goods.feign.GoodsFeign;
import com.kgc.goods.service.Goodsservice;
import com.kgc.pojo.goods.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Goodsserviceimpl implements Goodsservice{
    @Autowired
    private GoodsFeign goodsFeign;

    @Override
    public Goods getGoodsByType(String type) {
        return goodsFeign.getGoodsByType(type);
    }

    @Override
    public Goods getPersonById(Integer id) {
        return goodsFeign.getPersonById(id);
    }

    @Override
    public int goodsAdd(Goods goods) {
        return goodsFeign.goodsAdd(goods);
    }

    @Override
    public int goodsDelete(Integer id) {
        return goodsFeign.goodsDelete(id);
    }

    @Override
    public int goodsUpdate(Goods goods) {
        return goodsFeign.goodsUpdate(goods);
    }
}
