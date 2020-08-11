package com.kgc.service.impl;

import com.kgc.feign.GoodsFeign;
import com.kgc.service.Goodsservice;
import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Goodsserviceimpl implements Goodsservice{
    @Autowired
    private GoodsFeign goodsFeign;


    @Override
    public PageUtil<Goods> getPage(Integer cateid, String goodsname, Integer index, Integer size) {
        return null;
    }

    @Override
    public List<Goods> getGoodsByType(String type) {
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
