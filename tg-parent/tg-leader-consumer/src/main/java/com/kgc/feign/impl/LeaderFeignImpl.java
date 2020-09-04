package com.kgc.feign.impl;

import com.kgc.feign.LeaderFeign;
import com.kgc.pojo.order.TeamOrder;
import org.springframework.stereotype.Component;

@Component
public class LeaderFeignImpl implements LeaderFeign{
    @Override
    public int addTeam(TeamOrder teamOrder) {
        return 0;
    }
}
