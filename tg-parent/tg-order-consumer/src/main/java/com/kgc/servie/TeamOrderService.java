package com.kgc.servie;

import com.kgc.pojo.order.TeamOrder;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface TeamOrderService {
    public List<TeamOrder> getAllTeam(Integer leaderId);
    public int add(TeamOrder teamOrder);
    public int update(TeamOrder teamOrder);
    public int delete(Integer teamId);
}
