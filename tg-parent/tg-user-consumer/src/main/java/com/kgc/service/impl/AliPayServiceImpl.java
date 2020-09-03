package com.kgc.service.impl;

import com.kgc.Feign.AliPayFeignClient;
import com.kgc.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private AliPayFeignClient aliPayFeignClient;

    @Override
    public String aliPay(String subjectName, String orderNo, String amount) {
        return aliPayFeignClient.aliPay(subjectName,orderNo,amount);
    }
}
