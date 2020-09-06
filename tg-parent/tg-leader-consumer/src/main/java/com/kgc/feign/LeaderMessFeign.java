package com.kgc.feign;

import com.kgc.feign.impl.LeaderMessFeignImpl;
import com.kgc.pojo.leader.Leader_mess;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "tg-leader-provider",fallback = LeaderMessFeignImpl.class)
public interface LeaderMessFeign {

    @RequestMapping("/getMessPage")
    public PageUtil<Leader_mess> getMessPage(@RequestParam Map<String,Object> map);

    @RequestMapping("/insertMess")
    public int insertMess(@RequestBody Leader_mess mess);

    @RequestMapping("/getMessById/{id}")
    public Leader_mess getMessById(@PathVariable("id") Integer id);

    @RequestMapping("/updateMess")
    public int updateMess(@RequestBody Leader_mess mess);

    @RequestMapping("/delMess/{id}")
    public int delMess(@PathVariable("id") Integer id);

    @RequestMapping("/getAllMess/{LeaderId}")
    public List<Leader_mess> getAllMess(@PathVariable("LeaderId") Integer LeaderId);


}
