package com.kgc.Feign.impl;

import com.kgc.Feign.MemberFeignClient;
import com.kgc.pojo.user.Member;
import org.springframework.stereotype.Component;

import java.util.Map;


public class MemberFeignClientImpl implements MemberFeignClient {
    @Override
    public Member getLogin(Map<String, Object> param) {
        return null;
    }

    @Override
    public Member getMemberById(Integer id) {
        return null;
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int add(Member member) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public Member getMemberFromRedis(String token) {
        return null;
    }

    @Override
    public String aliPay(String subjectName, String orderNo, String amount) {
        return null;
    }


}
