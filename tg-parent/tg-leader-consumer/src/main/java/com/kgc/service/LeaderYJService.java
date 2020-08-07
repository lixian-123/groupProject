package com.kgc.service;

import com.kgc.pojo.leader.Leader_yongjin;

import java.util.List;

public interface LeaderYJService {
    public List<Leader_yongjin> getAllYongJin(Integer leaderId);
    public int add(Leader_yongjin leader_yongjin);
    public int update(Leader_yongjin leader_yongjin);
}
