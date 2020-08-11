package com.kgc.service;

import com.kgc.pojo.leader.Leader_mess;

import java.util.List;

public interface LeaderMessService {
    public List<Leader_mess> getAllLeaderMess(Integer messTypeId);
    public int add(Leader_mess leader_mess);
}
