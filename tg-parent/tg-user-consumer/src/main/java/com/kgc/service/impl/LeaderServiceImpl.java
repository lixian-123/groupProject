package com.kgc.service.impl;

import com.kgc.Feign.LeaderFeignClient;
import com.kgc.pojo.user.Leader;
import com.kgc.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderFeignClient leaderFeignClient;


    @Override
    public Leader getleaderLogin(Map<String, Object> param) {
        return leaderFeignClient.getleaderLogin(param);
    }

    @Override
    public Leader getLeaderById(Integer id) {
        return leaderFeignClient.getLeaderById(id);
    }

    @Override
    public int update(Leader leader) {
        return leaderFeignClient.update(leader);
    }

    @Override
    public int add(Leader leader) {
        return leaderFeignClient.add(leader);
    }

    @Override
    public int delete(Integer id) {
        return leaderFeignClient.delete(id);
    }
}
