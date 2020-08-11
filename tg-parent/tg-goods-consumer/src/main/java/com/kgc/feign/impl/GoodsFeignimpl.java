package com.kgc.feign.impl;

import com.kgc.feign.GoodsFeign;
import com.kgc.pojo.goods.Goods;
import org.springframework.stereotype.Component;

@Component
public class GoodsFeignimpl implements GoodsFeign{
    @Override
    public Goods getPersonById(Integer id) {
        return null;
    }

    @Override
    public Goods getGoodsByType(String type) {
        return null;
    }

    @Override
    public int goodsAdd(Goods goods) {
        return 0;
    }

    @Override
    public int goodsDelete(Integer id) {
        return 0;
    }

    @Override
    public int goodsUpdate(Goods goods) {
        return 0;
    }
}
