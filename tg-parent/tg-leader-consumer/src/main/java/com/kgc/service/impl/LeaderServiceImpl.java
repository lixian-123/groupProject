package com.kgc.service.impl;

import com.kgc.feign.LeaderFeign;
import com.kgc.feign.RedisFeign;
import com.kgc.feign.TeamOrderFeign;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    LeaderFeign leaderFeign;
    @Autowired
    RedisFeign redisFeign;
    @Autowired
    TeamOrderFeign orderFeign;

    //添加团购信息
    @Override
    public int addTeam(TeamOrder teamOrder) {
        return leaderFeign.addTeam(teamOrder);
    }

    @Override
    public boolean saveTeamRedis(TeamOrder teamOrder) {
        return redisFeign.saveTeamRedis(teamOrder);
    }

    @Override
    public TeamOrder getTeamOrder(String startTime, String endTime) {
        return orderFeign.getTeamOrder(startTime, endTime);
    }

}
