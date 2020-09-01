package com.kgc.service.impl;

import com.kgc.feign.GoodsFeignClient;
import com.kgc.pojo.goods.Goods;
import com.kgc.service.GoodsService;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {
    //调用 feign
    private GoodsFeignClient goodsFeignClient;
    @Override
    public PageUtil<Goods> getGoodsPage(Integer index,Integer size,String goodsname) {
        Map<String,Object> parma=new HashMap<>();
        parma.put("index",(index-1)*size);
        parma.put("size",size);
        parma.put("goodsname",goodsname);
        return goodsFeignClient.getGoodsPage(parma);
    }

    @Override
    public int insetGoods(Goods goods) {
        return goodsFeignClient.insetGoods(goods);
    }

    @Override
    public int updateGoods(Goods goods) {
        return goodsFeignClient.updateGoods(goods);
    }

    @Override
    public Goods getGoodsById(Integer goodsId) {
        return goodsFeignClient.getGoodsById(goodsId);
    }
}
