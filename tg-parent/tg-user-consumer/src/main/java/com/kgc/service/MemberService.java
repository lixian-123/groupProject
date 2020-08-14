package com.kgc.service;

import com.kgc.pojo.user.Member;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface MemberService {

    public Member getLogin(String nickname,String passWord);

    public Member getMemberById( Integer id);

    public int update(Member member);

    public int add(Member member);

    public int delete(Integer id);

    public Member getMemberFromRedis(String token);

}
