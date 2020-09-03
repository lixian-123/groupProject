package com.kgc.Feign.impl;

import com.kgc.Feign.LeaderFeignClient;
import com.kgc.pojo.user.Leader;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LeaderFeignClientImpl implements LeaderFeignClient  {

    @Override
    public PageUtil<Leader> getLeaderPage(Map<String, Object> param) {
        return null;
    }

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
