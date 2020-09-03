package com.kgc.service;

import com.kgc.pojo.user.Member;
import com.kgc.vo.Dto;
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

    /*public String aliPay(String subjectName,String orderNo,String amount);*/

    //用户参与团购成功后给团长提示
    public Dto messToRabbit(String name,String number);

}
