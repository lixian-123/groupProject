package com.kgc.feign.impl;

import com.kgc.feign.LeaderTiHuoFeign;
import com.kgc.pojo.leader.Leader_tihuo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderTiHuoFeignImpl implements LeaderTiHuoFeign {
    @Override
    public List<Leader_tihuo> getAllTiHuo(Integer leaderId) {
        return null;
    }

    @Override
    public int add(Leader_tihuo leader_tihuo) {
        return 0;
    }
}
