package com.kgc.service.impl;

import com.kgc.feign.LeaderFeign;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    LeaderFeign leaderFeign;

    @Override
    public int addTeam(TeamOrder teamOrder) {
        return leaderFeign.addTeam(teamOrder);
    }
}
