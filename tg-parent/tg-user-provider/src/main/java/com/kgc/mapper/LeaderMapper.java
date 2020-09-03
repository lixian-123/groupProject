package com.kgc.mapper;

import com.kgc.pojo.user.Leader;

import java.util.List;
import java.util.Map;


public interface LeaderMapper {

    //分页
    public List<Leader> getAllLeader(Map<String, Object> param);
    public int getCount(Map<String, Object> param);

    //登陆
    public Leader LeaderLogin(Map<String,Object> param);

    //根据编号查询
    public Leader getLeaderById(Integer id);

    //更新
    public int update(Leader leader);

    //添加
    public int add(Leader leader);

    //删除
    public int delete(Integer id);

}
