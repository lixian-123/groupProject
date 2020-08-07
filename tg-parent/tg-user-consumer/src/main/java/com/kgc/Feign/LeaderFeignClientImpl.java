package com.kgc.Feign;

import com.kgc.pojo.user.Leader;

import java.util.Map;

public class LeaderFeignClientImpl implements LeaderFeignClient {
    @Override
    public Leader getleaderLogin(Map<String, Object> param) {
        return null;
    }

    @Override
    public Leader getLeaderById(Integer id) {
        return null;
    }

    @Override
    public int update(Leader leader) {
        return 0;
    }

    @Override
    public int add(Leader leader) {
        return 0;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }
}
