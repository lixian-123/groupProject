package com.kgc.servie.impl;

import com.kgc.feign.TeamOrderFeign;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.servie.TeamOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeamOrderServiceImpl implements TeamOrderService {
    @Autowired
    TeamOrderFeign teamOrderFeign;
    @Override
    public List<TeamOrder> getAllTeam(Integer leaderId) {
        return teamOrderFeign.showTeam(leaderId);
    }

    @Override
    public int add(TeamOrder teamOrder) {
        return teamOrderFeign.addTeam(teamOrder);
    }

    @Override
    public int update(TeamOrder teamOrder) {
        return teamOrderFeign.updateTeam(teamOrder);
    }

    @Override
    public int delete(Integer teamId) {
        return 0;
    }
}
