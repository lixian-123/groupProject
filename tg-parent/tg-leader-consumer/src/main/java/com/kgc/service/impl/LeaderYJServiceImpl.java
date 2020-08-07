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
    public List<Leader_yongjin> getAllYongJin(Integer leaderId) {
        return yjFeign.getAllYongJin(leaderId);
    }

    @Override
    public int add(Leader_yongjin leader_yongjin) {
        return yjFeign.add(leader_yongjin);
    }

    @Override
    public int update(Leader_yongjin leader_yongjin) {
        return yjFeign.update(leader_yongjin);
    }
}
