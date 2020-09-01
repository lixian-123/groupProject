package com.kgc.service.impl;

import com.kgc.feign.CateGoryFeignClienet;
import com.kgc.pojo.goods.Category;
import com.kgc.service.CateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateGoryServiceImpl implements CateGoryService {
    //调用feign
    @Autowired
    private CateGoryFeignClienet feignClienet;
    @Override
    public List<Category> getAllCategory() {
        return feignClienet.getAllCategry();
    }
}
