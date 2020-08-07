package com.kgc.feign;

import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tg-leader-provider")
public interface LeaderYJFeign {
    @RequestMapping("/showLeaderYJ")
    public List<Leader_yongjin> getAllYongJin(@RequestParam("leaderId") Integer leaderId);
    @RequestMapping("/addLeaderYJ")
    public int add(@RequestBody Leader_yongjin leader_yongjin);
    @RequestMapping("/updateLeaderYJ")
    public int update(@RequestBody Leader_yongjin leader_yongjin);
}
