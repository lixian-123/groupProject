package com.kgc.controller;

import com.kgc.service.AliPayService;
import com.kgc.util.AliPayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AliPayController {
    @Autowired
    AliPayUtils aliPayUtils;

    @Autowired
    private AliPayService aliPayService;

    @RequestMapping("/pay")
    public String aliPay(@RequestParam("subjectName") String subjectName, @RequestParam("orderNo") String orderNo, @RequestParam("amount") String amount) throws Exception{
        return aliPayService.aliPay(subjectName,orderNo,amount);
    }
}
