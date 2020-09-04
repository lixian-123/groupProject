package com.kgc.Feign;

import com.kgc.Feign.impl.LeaderFeignClientImpl;
import com.kgc.pojo.user.Leader;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "tg-user-provider")
public interface LeaderFeignClient {

    @RequestMapping("/getLeaderPage")
    public PageUtil<Leader> getLeaderPage(@RequestParam Map<String,Object> param);

    @RequestMapping("/leaderlogin")
    public Leader getleaderLogin(@RequestParam Map<String,Object> param);

    @RequestMapping("/leaderid/{id}")
    public Leader getLeaderById(@PathVariable("id") Integer id);

    @RequestMapping("/leaderupdate")
    public int update( @RequestBody Leader leader);

    @RequestMapping("/leaderadd")
    public int add(@RequestBody Leader leader);

    @RequestMapping("/leaderdelete/{id}")
    public int delete(@PathVariable("id") Integer id);

}
