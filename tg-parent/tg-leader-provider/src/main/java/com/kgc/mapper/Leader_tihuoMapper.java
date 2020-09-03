package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_tihuo;

import java.util.List;

/**
 * 该团提货记录几口
 */
public interface Leader_tihuoMapper {
    //得到所有已提货记录
    public List<Leader_tihuo> getAllTiHuo(Integer leaderId);
    //添加提货记录
    public int add(Leader_tihuo leader_tihuo);
}
