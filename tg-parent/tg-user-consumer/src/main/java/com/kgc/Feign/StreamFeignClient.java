package com.kgc.Feign;

import com.kgc.Feign.impl.StreamFeignClientImpl;
import com.kgc.pojo.user.UserStream;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "tg-user-provider")
public interface StreamFeignClient {

    @RequestMapping("/streamid/{id}")
    public UserStream getMemberById(@PathVariable("id") Integer id);

    @PostMapping("/streamupdate")
    public int update(@RequestBody UserStream userStream);

    @PostMapping("/stramadd")
    public int add(@RequestBody UserStream userStream);

}
