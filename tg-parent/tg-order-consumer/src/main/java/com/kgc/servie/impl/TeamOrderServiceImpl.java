package com.kgc.servie.impl;

import com.alibaba.fastjson.JSON;
import com.kgc.feign.OrderDetailFeign;
import com.kgc.feign.TeamOrderFeign;
import com.kgc.pojo.order.OrderDetail;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.pojo.user.Member;
import com.kgc.servie.TeamOrderService;
import com.kgc.util.RedisUtils;
import com.kgc.vo.MqMessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamOrderServiceImpl implements TeamOrderService {
    @Autowired
    TeamOrderFeign teamOrderFeign;
    @Autowired
    OrderDetailFeign orderDetailFeign;
    @Autowired
    RedisUtils redisUtils;
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
        return 0;
    }

    @Override
    public int delete(Integer teamId) {
        return 0;
    }



}
