package com.kgc.feign;

import com.kgc.feign.impl.LeaderMessFeignImpl;
import com.kgc.pojo.leader.Leader_mess;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tg-leader-provider",fallback = LeaderMessFeignImpl.class)
public interface LeaderMessFeign {
    @RequestMapping("showLeaderMess")
    public List<Leader_mess> getAllLeaderMess(@RequestParam("messTypeId")Integer messTypeId);
    @RequestMapping("addLeaderMess")
    public int add(Leader_mess leader_mess);
}
