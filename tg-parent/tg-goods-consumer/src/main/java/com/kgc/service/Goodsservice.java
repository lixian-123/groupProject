package com.kgc.service;

import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;

import java.util.List;

public interface Goodsservice {
    //分页查询
   public PageUtil<Goods> getPage(Integer cateid , String goodsname , Integer index, Integer size);


    //根据商品分类查询
    public List<Goods> getGoodsByType(String type);

    //根据商品id查询
    public Goods getPersonById(Integer id);

    //添加商品
    public int goodsAdd(Goods goods);

    //删除商品
    public int goodsDelete(Integer id);

    //修改商品
    public int goodsUpdate(Goods goods);
}
