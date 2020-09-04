package com.kgc.service;

import org.springframework.web.bind.annotation.RequestParam;

public interface AliPayService {

    public String aliPay(@RequestParam("subjectName") String subjectName, @RequestParam("orderNo") String orderNo, @RequestParam("amount") String amount);

}
