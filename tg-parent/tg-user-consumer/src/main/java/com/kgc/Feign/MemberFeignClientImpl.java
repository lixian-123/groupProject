package com.kgc.Feign;

import com.kgc.pojo.user.Member;

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
}
