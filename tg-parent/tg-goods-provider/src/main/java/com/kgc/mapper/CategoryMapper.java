package com.kgc.mapper;

import com.kgc.pojo.goods.Category;

import java.util.List;

public interface CategoryMapper {
    //获取所有商品分类
    List<Category> getAllCategry();
}
