package com.kgc.feign;

import com.kgc.feign.impl.LeaderYJFeignImpl;
import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "tg-leader-provider",fallback = LeaderYJFeignImpl.class)
public interface LeaderYJFeign {

    @RequestMapping("/getYongJinByLeader/{leaderId}")
    public Leader_yongjin getYongJinByLeader(@PathVariable("leaderId") Integer leaderId);

    @RequestMapping("/updateYongjin")
    public int updateYongjin(@RequestBody Leader_yongjin yongjin);

    @RequestMapping("/addYongjin")
    public int addYongjin(@RequestBody Leader_yongjin yongjin);
}
