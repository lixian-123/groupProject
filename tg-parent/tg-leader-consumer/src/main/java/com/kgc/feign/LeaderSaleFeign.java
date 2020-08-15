package com.kgc.feign;

import com.kgc.pojo.leader.Leader_sale;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "tg-leader-provider")
public interface LeaderSaleFeign {
    @RequestMapping("showLeaderSale")
    public List<Leader_sale> getAllSale(@RequestParam Map<String,Object> map);
    @RequestMapping("addLeaderSale")
    public int add(@RequestBody Leader_sale leader_sale);
    @RequestMapping("updateLeaderSale")
    public int update(@RequestBody Leader_sale leader_sale);

    @RequestMapping("/getTichengToday")
    public String getTichengToDay();

    @RequestMapping("/getTichengMonth")
    public String getTichengMonth();
}
