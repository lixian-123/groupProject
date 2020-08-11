package com.kgc.goods.mapper;

import com.kgc.pojo.goods.Goods;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Goodsmapper {

    //分页查询
//    public List<Goods> getAllGoods(Map<String, Object> parma);
//    public int count(Map<String, Object> param);

    //根据商品分类查询
    public Goods getGoodsByType(String type);

    //根据商品id查询
    public Goods getPersonById(Integer id);

    //添加商品
    public int goodsAdd(Goods goods);

    //删除商品
    public int goodsDelete(Integer id);

    //修改商品
    public int goodsUpdate(Goods goods);
}
