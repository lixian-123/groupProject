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

    @RequestMapping("/custoid/{id}")
    public Custodian getCustoById(@PathVariable("id") Integer id){
        return custService.getCustoById(id);
    }

    @PostMapping("/custoupdate")
    public int update(@RequestBody Custodian custodian){
        return custService.update(custodian);
    }

    @PostMapping("/custoadd")
    public int add(@RequestBody Custodian custodian){
        return custService.add(custodian);
    }

    @RequestMapping("/custodelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return custService.delete(id);
    }

}
