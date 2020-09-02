package com.kgc.feign;

import com.kgc.pojo.order.TeamOrder;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name = "tg-order-provider")
public interface TeamOrderFeign {
    @RequestMapping("/showTeam")
    public List<TeamOrder> showTeam(@RequestParam("leaderId")Integer leaderId);
    @RequestMapping("/addTeam")
    public int addTeam(@RequestBody TeamOrder teamOrder);
    @RequestMapping("/updateTeam")
    public int updateTeam(@RequestBody TeamOrder teamOrder,@RequestParam("versionValue")Integer versionValue);
    @RequestMapping("/deleteTeam")
    public int deleteTeam(@RequestParam("teamId")Integer teamId);
    @RequestMapping("/getVersion")
    public int getVersion(@RequestParam("teamId")Integer teamId);
    @RequestMapping("/updateGoodsNum")
    public int updateGoodsNum(@RequestParam Map<String,Object> map);
}
