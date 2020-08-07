package com.kgc.service;

import com.kgc.mapper.CustodianMapper;
import com.kgc.pojo.user.Custodian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestCustodianService {

    @Autowired
    private CustodianMapper custodianMapper;

    @RequestMapping("/custoid/{id}")
    public Custodian getCustoById(@PathVariable("id") Integer id){
        return custodianMapper.getCustodianById(id);
    }

    @PostMapping("/custoupdate")
    public int update(@RequestBody Custodian custodian){
        return custodianMapper.update(custodian);
    }

    @PostMapping("/custoadd")
    public int add(@RequestBody Custodian custodian){
        return custodianMapper.add(custodian);
    }

    @RequestMapping("/custodelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return custodianMapper.delete(id);
    }

}
