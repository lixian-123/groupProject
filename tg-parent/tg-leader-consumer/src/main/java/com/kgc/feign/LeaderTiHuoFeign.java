package com.kgc.feign;

import com.kgc.feign.impl.LeaderTiHuoFeignImpl;
import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "tg-leader-provider",fallback = LeaderTiHuoFeignImpl.class)
public interface LeaderTiHuoFeign {

    @RequestMapping("/getTiHuoPage")
    public PageUtil<Leader_tihuo> getTiHuoPage(@RequestParam Map<String,Object> map);

    @RequestMapping("/addTihuo")
    public int insertTihuo(@RequestBody Leader_tihuo tihuo);

    @RequestMapping("/delTihuo/{id}")
    public int delTihuo(@PathVariable("id") Integer id);

}
