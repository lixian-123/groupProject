package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_yongjin;

import java.util.List;

public interface Leader_yongjinMapper {
    public List<Leader_yongjin> getAllYongJin(Integer leaderId);
    public int add(Leader_yongjin leader_yongjin);
    public int update(Leader_yongjin leader_yongjin);
}
