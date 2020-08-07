package com.kgc.Feign;

import com.kgc.pojo.user.Custodian;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "tg-user-provider",fallback = CustFeignClientImpl.class)
public interface CustFeignClient {

    @RequestMapping("/custoid/{id}")
    public Custodian getCustoById(@PathVariable("id") Integer id);

    @PostMapping("/custoupdate")
    public int update(@RequestBody Custodian custodian);

    @PostMapping("/custoadd")
    public int add(@RequestBody Custodian custodian);

    @RequestMapping("/custodelete/{id}")
    public int delete(@PathVariable("id") Integer id);


}
