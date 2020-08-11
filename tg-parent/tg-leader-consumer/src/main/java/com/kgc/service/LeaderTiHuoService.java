package com.kgc.service;

import com.kgc.pojo.leader.Leader_tihuo;

import java.util.List;

public interface LeaderTiHuoService {
    public List<Leader_tihuo> getAllTiHuo(Integer leaderId);
    //添加提货记录
    public int add(Leader_tihuo leader_tihuo);
}
