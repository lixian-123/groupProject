package com.kgc.service;

import com.kgc.pojo.user.Member;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

public interface MemberService {

    public Member getLogin(@RequestParam Map<String,Object> param);

    public Member getMemberById(@PathVariable("id") Integer id);

    public int update(@RequestBody Member member);

    public int add(@RequestBody Member member);

    public int delete(@PathVariable("id") Integer id);

}
