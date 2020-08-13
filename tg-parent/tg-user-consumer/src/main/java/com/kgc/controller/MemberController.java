package com.kgc.controller;

import com.kgc.pojo.user.Member;
import com.kgc.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/memberlogin")
    public Member getLogin(String nickname, String passWord, HttpServletRequest request){
        //通过请求头获取用户代理字符串
        String userAgentStr=request.getHeader("User-Agent");
        return memberService.getLogin(nickname,passWord,userAgentStr);
    }

    @RequestMapping("/memberid/{id}")
    public Member getMemberById(@PathVariable("id") Integer id){
        return memberService.getMemberById(id);
    }

    @RequestMapping("/memberupdate")
    public int update(@RequestBody Member member){
        return memberService.update(member);
    }

    @RequestMapping("/memberadd")
    public int add(@RequestBody Member member){
        return memberService.add(member);
    }


    @RequestMapping("/memberdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return memberService.delete(id);
    }

}
