package com.kgc.service.impl;

import com.kgc.feign.LeaderYJFeign;
import com.kgc.pojo.leader.Leader_yongjin;
import com.kgc.service.LeaderYJService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaderYJServiceImpl implements LeaderYJService {
    @Autowired
    LeaderYJFeign yjFeign;

    @Override
    public Leader_yongjin getYongJinByLeader(Integer leaderId) {
        return yjFeign.getYongJinByLeader(leaderId);
    }

    @Override
    public int updateYongjin(Leader_yongjin yongjin) {
        return yjFeign.updateYongjin(yongjin);
    }

    @Override
    public int addYongjin(Leader_yongjin yongjin) {
        return yjFeign.addYongjin(yongjin);
    }
}
