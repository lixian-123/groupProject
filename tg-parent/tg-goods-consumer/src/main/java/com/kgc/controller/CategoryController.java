package com.kgc.controller;

import com.kgc.pojo.goods.Category;
import com.kgc.service.CateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CategoryController {
    //调用service
    @Autowired
    private CateGoryService cateGoryService;
    @RequestMapping("/getCategory")
    List<Category> getAllCategory(){
        return cateGoryService.getAllCategory();
    }
}
