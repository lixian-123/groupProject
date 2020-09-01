package com.kgc.service;

import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;

import java.util.Map;

public interface GoodsService {

    public PageUtil<Goods> getGoodsPage(Integer index, Integer size, String goodsname);


    public int insetGoods(Goods goods);


    public int updateGoods(Goods goods);


    public Goods getGoodsById(Integer goodsId);
}
