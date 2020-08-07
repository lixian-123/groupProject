package com.kgc.mapper;

import com.kgc.pojo.order.RetailOrder;
import com.kgc.pojo.order.TeamOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamOrderMapper {
    public List<TeamOrder> getAllTeam(@Param("leaderId")Integer leaderId);
    public int add(TeamOrder teamOrder);
    public int update(TeamOrder teamOrder);
    public int delete(@Param("teamId")Integer teamId);
}
