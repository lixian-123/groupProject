package com.kgc.service;

import com.kgc.pojo.order.TeamOrder;


public interface LeaderService {
    public int addTeam(TeamOrder teamOrder);//添加团队订单信息
    public boolean saveTeamRedis(TeamOrder teamOrder);//订单保存到redis中
}
