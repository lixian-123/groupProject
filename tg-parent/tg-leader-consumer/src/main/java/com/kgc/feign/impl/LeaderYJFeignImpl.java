package com.kgc.feign.impl;

import com.kgc.feign.LeaderYJFeign;
import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderYJFeignImpl implements LeaderYJFeign{
    @Override
    public List<Leader_yongjin> getAllYongJin(Integer leaderId) {
        return null;
    }

    @Override
    public int add(Leader_yongjin leader_yongjin) {
        return 0;
    }

    @Override
    public int update(Leader_yongjin leader_yongjin) {
        return 0;
    }
}
