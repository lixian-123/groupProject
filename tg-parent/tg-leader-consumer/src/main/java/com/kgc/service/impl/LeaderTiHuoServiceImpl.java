package com.kgc.service.impl;

import com.kgc.feign.LeaderTiHuoFeign;
import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.service.LeaderTiHuoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LeaderTiHuoServiceImpl implements LeaderTiHuoService {
    @Autowired
    LeaderTiHuoFeign tiHuoFeign;
    @Override
    public List<Leader_tihuo> getAllTiHuo(Integer leaderId) {
        return tiHuoFeign.getAllTiHuo(leaderId);
    }

    @Override
    public int add(Leader_tihuo leader_tihuo) {
        return tiHuoFeign.add(leader_tihuo);
    }
}
