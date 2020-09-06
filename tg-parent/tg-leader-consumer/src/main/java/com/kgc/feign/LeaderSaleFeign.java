package com.kgc.feign;

import com.kgc.feign.impl.LeaderSaleFeignImpl;
import com.kgc.pojo.leader.Leader_sale;
import com.kgc.util.PageUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "tg-leader-provider",fallback = LeaderSaleFeignImpl.class)
public interface LeaderSaleFeign {

    @RequestMapping("/getSalePage")
    public PageUtil getSalePage(@RequestParam Map<String,Object> map);

    @RequestMapping("/addSale")
    public int addSale(@RequestBody Leader_sale leader_sale);

    @RequestMapping("/getSaleById/{id}")
    public Leader_sale getSaleById(@PathVariable("id") Integer id);

    @RequestMapping("/updateSale")
    public int updateSale(@RequestBody Leader_sale leader_sale);

    @RequestMapping("/getTichengToday")
    public String getTichengToday();

    @RequestMapping("/getTichengMonth")
    public String getTichengMonth();


}
