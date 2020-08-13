package com.kgc.mapper;

import com.kgc.pojo.goods.Category;

import java.util.List;

/**
 * 商品分类
 */
public interface CategoryMapper {
    //获取所有商品分类
    List<Category> getAllCategory();
}
