package com.kgc.servie;

import com.kgc.pojo.order.TeamOrder;

import java.util.List;

public interface TeamOrderService {
    public List<TeamOrder> getAllTeam(Integer leaderId);
    public int add(TeamOrder teamOrder);
    public int update(TeamOrder teamOrder);
    public int delete(Integer teamId);
}
