package com.kgc.feign.impl;

import com.kgc.feign.LeaderYJFeign;
import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LeaderYJFeignImpl implements LeaderYJFeign{

    @Override
    public Leader_yongjin getYongJinByLeader(Integer leaderId) {
        return null;
    }

    @Override
    public int updateYongjin(Leader_yongjin yongjin) {
        return 0;
    }

    @Override
    public int addYongjin(Leader_yongjin yongjin) {
        return 0;
    }
}
