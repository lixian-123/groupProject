package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_tihuo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper


import java.util.List;
import java.util.Map;

/**
 * 该团提货记录几口
 */
public interface Leader_tihuoMapper {
    /**
     * 提货记录分页显示
     * @param param
     * @return
     */
    List<Leader_tihuo> getTiHuoPage(Map<String,Object> param);
    int getCount(Map<String,Object> param);

    /**
     *    添加提货记录
     * @param leader_tihuo
     * @return
     */
    int add(Leader_tihuo leader_tihuo);

    /**
     * 删除提货记录
     * @param id
     * @return
     */
    int delTihuo(Integer id);
}
