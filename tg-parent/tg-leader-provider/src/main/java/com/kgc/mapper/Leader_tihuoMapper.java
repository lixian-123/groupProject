package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_tihuo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Leader_tihuoMapper {
    //得到所有已提货记录
    public List<Leader_tihuo> getAllTiHuo(Integer leaderId);
    //添加提货记录
    public int add(Leader_tihuo leader_tihuo);
}
