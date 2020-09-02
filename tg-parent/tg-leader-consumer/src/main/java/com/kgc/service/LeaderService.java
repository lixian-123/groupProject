package com.kgc.service;

import com.kgc.pojo.order.TeamOrder;
import org.springframework.web.bind.annotation.RequestParam;


public interface LeaderService {
    public int addTeam(TeamOrder teamOrder);//添加团队订单信息
    public boolean saveTeamRedis(TeamOrder teamOrder);//订单保存到redis中
    public TeamOrder getTeamOrder(String startTime,String endTime);//根据开始时间和结束时间找到订单
}
