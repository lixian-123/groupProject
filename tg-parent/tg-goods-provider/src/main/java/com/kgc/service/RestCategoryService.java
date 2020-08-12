package com.kgc.service;

import com.kgc.mapper.CategoryMapper;
import com.kgc.pojo.goods.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;
import java.util.List;

@RestController
public class RestCategoryService {

    @Autowired
    private CategoryMapper categoryMapper;
    @RequestMapping("/getCategory")
    public List<Category> getAllCategry(){
        return categoryMapper.getAllCategory();
    }
}
