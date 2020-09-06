package com.kgc.feign.impl;

import com.kgc.feign.LeaderFeign;
import com.kgc.feign.LeaderMessFeign;
import com.kgc.pojo.leader.Leader_mess;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderMessFeignImpl implements LeaderMessFeign {
    @Override
    public List<Leader_mess> getAllLeaderMess(Integer messTypeId) {
        return null;
    }

    @Override
    public int add(Leader_mess leader_mess) {
        return 0;
    }
}
