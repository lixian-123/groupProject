package com.kgc.controller;


import com.kgc.pojo.user.Custodian;
import com.kgc.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CustController {

    @Autowired
    private CustService custService;

    //管理员详细信息
    @RequestMapping("/custoid/{id}") //已测
    public Custodian getCustoById(@PathVariable("id") Integer id){
        return custService.getCustoById(id);
    }

    //管理员信息修改
    @PostMapping("/custoupdate")
    public int update(@RequestBody Custodian custodian){
        return custService.update(custodian);
    }

    //添加管理员
    @PostMapping("/custoadd")
    public int add(@RequestBody Custodian custodian){
        return custService.add(custodian);
    }

    //删除
    @RequestMapping("/custodelete/{id}") //已测
    public int delete(@PathVariable("id") Integer id){
        return custService.delete(id);
    }

}
