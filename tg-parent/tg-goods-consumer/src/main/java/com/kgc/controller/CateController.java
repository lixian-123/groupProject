package com.kgc.controller;

import com.kgc.service.Categoryservice;
import com.kgc.pojo.goods.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CateController {

    @Autowired
    private Categoryservice categoryservice;

    @RequestMapping("/getAllCate")
    public List<Category> getAllCate(){
        return categoryservice.getAllCate();
    }


}
