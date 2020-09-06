package com.kgc.service;

import com.kgc.pojo.order.TeamOrder;
import org.springframework.web.bind.annotation.RequestParam;


public interface LeaderService {
    //添加团队订单信息
    public int addTeam(TeamOrder teamOrder);
    //订单保存到redis中
    public boolean saveTeamRedis(TeamOrder teamOrder);
    //根据开始时间和结束时间找到订单
    public TeamOrder getTeamOrder(String startTime,String endTime);
}
