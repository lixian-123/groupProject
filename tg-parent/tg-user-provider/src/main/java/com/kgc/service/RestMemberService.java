package com.kgc.service;

import com.kgc.mapper.MemberMapper;
import com.kgc.pojo.user.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RestMemberService {

    @Autowired
    private MemberMapper memberMapper;

    @RequestMapping("/memberlogin")
    public Member getLogin(@RequestParam Map<String,Object> param){
        Map<String,Object> map=new HashMap<>();
        String nickname=param.get("nickname").toString();
        String passWord=param.get("passWord").toString();
        map.put("nickname",nickname);
        map.put("passWord",passWord);
        return memberMapper.MemberLogin(map);
    }

    @RequestMapping("/memberid/{id}")
    public Member getMemberById(@PathVariable("id") Integer id){
        return memberMapper.getMemberById(id);
    }

    @RequestMapping("/memberupdate")
    public int update(@RequestBody Member member){
        return memberMapper.update(member);
    }

    @RequestMapping("/memberadd")
    public int add(@RequestBody Member member){
        return memberMapper.add(member);
    }


    @RequestMapping("/memberdelete/{id}")
    public int delete(@PathVariable("id") Integer id){
        return memberMapper.delete(id);
    }



}
