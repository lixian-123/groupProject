package com.kgc.feign.impl;

import com.kgc.feign.CategoryFeign;
import com.kgc.pojo.goods.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryFeignimpl implements CategoryFeign{
    @Override
    public List<Category> getAllCate() {
        return null;
    }
}
