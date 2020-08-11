package com.kgc.service.impl;

import com.kgc.Feign.MemberFeignClient;
import com.kgc.pojo.user.Member;
import com.kgc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberFeignClient memberFeignClient;

    @Override
    public Member getLogin(String nickname,String passWord) {
        Map<String,Object> param=new HashMap<>();
        param.put("nickname",nickname);
        param.put("passWord",passWord);
        return memberFeignClient.getLogin(param);
    }

    @Override
    public Member getMemberById(Integer id) {
        return memberFeignClient.getMemberById(id);
    }

    @Override
    public int update(Member member) {
        return memberFeignClient.update(member);
    }

    @Override
    public int add(Member member) {
        return memberFeignClient.add(member);
    }

    @Override
    public int delete(Integer id) {
        return memberFeignClient.delete(id);
    }
}
