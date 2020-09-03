package com.kgc.service;

import com.kgc.util.AliPayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestAliPayService {
    @Autowired
    AliPayUtils aliPayUtils;

    @RequestMapping("/pay")
    public String aliPay(@RequestParam("subjectName") String subjectName, @RequestParam("orderNo") String orderNo, @RequestParam("amount") String amount) throws Exception{
        // System.out.println("进入控制器");
        int authCodeNew = 0;
        authCodeNew = (int) Math.round(Math.random() * (9999 - 1000) + 1000);
        subjectName="subjectName"+authCodeNew;
        orderNo="orderNo"+authCodeNew;
        //System.out.println(subjectName);

        return aliPayUtils.toPcPay(subjectName, orderNo, "69.9");
    }
}
