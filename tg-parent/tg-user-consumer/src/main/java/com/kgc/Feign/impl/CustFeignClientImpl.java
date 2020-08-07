package com.kgc.Feign.impl;

import com.kgc.Feign.CustFeignClient;
import com.kgc.pojo.user.Custodian;
import org.springframework.stereotype.Component;

@Component
public class CustFeignClientImpl implements CustFeignClient {
    @Override
    public Custodian getCustoById(Integer id) {
        return null;
    }

    @Override
    public int update(Custodian custodian) {
        return 0;
    }

    @Override
    public int add(Custodian custodian) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
