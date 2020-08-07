package com.kgc.service.impl;

import com.kgc.Feign.CustFeignClient;
import com.kgc.pojo.user.Custodian;
import com.kgc.service.CustService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustServiceImpl implements CustService {

    @Autowired
    private CustFeignClient custFeignClient;

    @Override
    public Custodian getCustoById(Integer id) {
        return custFeignClient.getCustoById(id);
    }

    @Override
    public int update(Custodian custodian) {
        return 0;
    }

    @Override
    public int add(Custodian custodian) {
        return custFeignClient.add(custodian);
    }

    @Override
    public int delete(Integer id) {
        return custFeignClient.delete(id);
    }
}
