package com.kgc.service.impl;

import com.kgc.feign.CategoryFeign;
import com.kgc.service.Categoryservice;
import com.kgc.pojo.goods.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Categoryserviceimpl implements Categoryservice {
    @Autowired
    private CategoryFeign categoryFeign;


    @Override
    public List<Category> getAllCate() {
        return categoryFeign.getAllCate();
    }
}
