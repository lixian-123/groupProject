package com.kgc.feign;

import com.kgc.pojo.leader.Leader_tihuo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tg-leader-provider")
public interface LeaderTiHuoFeign {
    @RequestMapping("/showLeaderTihuo")
    public List<Leader_tihuo> getAllTiHuo(@RequestParam("leaderId") Integer leaderId);
    @RequestMapping("/addLeaderTihuo")
    public int add(@RequestBody Leader_tihuo leader_tihuo);
}
