package com.kgc.mapper;

import com.kgc.pojo.order.RetailOrder;
import com.kgc.pojo.order.TeamOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeamOrderMapper {
    public List<TeamOrder> getAllTeam(@Param("leaderId")Integer leaderId);
    public int add(TeamOrder teamOrder);
    public int update(TeamOrder teamOrder,@Param("versionValue")Integer versionValue);
    public int delete(@Param("teamId")Integer teamId);
    public int getVersion(@Param("teamId") Integer teamId);
    public int updateGoodsNum(Map<String,Object> map);
    public TeamOrder getTeamOrder(@Param("startTime")String startTime,@Param("endTime")String endTime);//根据开始时间和结束时间得到订单

}
