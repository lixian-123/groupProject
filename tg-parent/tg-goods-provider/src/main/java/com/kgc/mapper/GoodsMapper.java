package com.kgc.mapper;

import com.kgc.pojo.goods.Goods;
import com.kgc.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    //分页显示
    List<Goods> getGoodByPage(Map<String, Object> param);
    int getCount(Map<String, Object> param);

    //添加商品
    int insertGoods(Goods goods);
    //根据商品id显示详情
    Goods getGoodsById(Integer goodsId);
    //更新商品
    int updateGoods(Goods goods);

    //获取所有商品
    List<Goods> getAllGoods();
}
