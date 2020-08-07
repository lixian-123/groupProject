package com.kgc.Feign;

import com.kgc.Feign.impl.MemberFeignClientImpl;
import com.kgc.pojo.user.Member;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "tg-user-provider",fallback = MemberFeignClientImpl.class)
public interface MemberFeignClient {

    @RequestMapping("/memberlogin")
    public Member getLogin(@RequestParam Map<String,Object> param);

    @RequestMapping("/memberid/{id}")
    public Member getMemberById(@PathVariable("id") Integer id);

    @RequestMapping("/memberupdate")
    public int update(@RequestBody Member member);

    @RequestMapping("/memberadd")
    public int add(@RequestBody Member member);

    @RequestMapping("/memberdelete/{id}")
    public int delete(@PathVariable("id") Integer id);

}
