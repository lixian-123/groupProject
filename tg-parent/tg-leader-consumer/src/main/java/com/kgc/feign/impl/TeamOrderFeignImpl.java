package com.kgc.feign.impl;

import com.kgc.feign.TeamOrderFeign;
import com.kgc.pojo.order.TeamOrder;
import org.springframework.stereotype.Component;

@Component
public class TeamOrderFeignImpl implements TeamOrderFeign {
    @Override
    public TeamOrder getTeamOrder(String startTime, String endTime) {
        return null;
    }
}
