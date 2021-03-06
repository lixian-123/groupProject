package com.kgc.controller;

import com.kgc.pojo.user.Member;
import com.kgc.service.MemberService;
import com.kgc.vo.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/memberlogin") //potman 测试成功
    public Member getLogin(String nickname,String passWord){
        return memberService.getLogin(nickname,passWord);
    }

    @RequestMapping("/memberid/{id}") //已测
    public Member getMemberById(@PathVariable("id") Integer id){
        return memberService.getMemberById(id);
    }

    @RequestMapping("/memberupdate") //已测
    public int update(@RequestBody Member member){
        return memberService.update(member);
    }

    @RequestMapping("/memberadd") //已测
    public int add(@RequestBody Member member){
        return memberService.add(member);
    }


    @RequestMapping("/memberdelete/{id}") //已测
    public int delete(@PathVariable("id") Integer id){
        return memberService.delete(id);
    }

    @RequestMapping("/getMemberFromRedis")
    public Member getMemberFromRedis(String token){
        System.out.println("controller"+token);
        return  memberService.getMemberFromRedis(token);
    }

    @RequestMapping("/sendMess")
    public Dto sendMessToLeader(String name,String teamOrder){
        return memberService.messToRabbit(name, teamOrder);
    }
}
