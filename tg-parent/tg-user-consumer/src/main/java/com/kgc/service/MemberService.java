package com.kgc.service;

import com.kgc.pojo.user.Member;
import com.kgc.vo.Dto;

public interface MemberService {

    public Member getLogin(String nickname,String passWord);

    public Member getMemberById( Integer id);

    public int update(Member member);

    public int add(Member member);

    public int delete(Integer id);

    public Member getMemberFromRedis(String token);

    //参加团购之后给团长发送的消息
    public Dto messToRabbit(String name,String teamOrder);

}
