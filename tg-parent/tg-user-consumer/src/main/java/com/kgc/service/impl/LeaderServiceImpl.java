package com.kgc.service.impl;

import com.kgc.Feign.LeaderFeignClient;
import com.kgc.pojo.user.Leader;
import com.kgc.service.LeaderService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class LeaderServiceImpl implements LeaderService {

    @Autowired
    private LeaderFeignClient leaderFeignClient;


    @Override
    public PageUtil<Leader> getLeaderPage(Integer index, Integer size, String LeaaderName) {
        Map<String,Object> param=new HashMap<>();
        param.put("index",(index-1)*size);
        param.put("size",size);
        param.put("LeaaderName",LeaaderName);
        return leaderFeignClient.getLeaderPage(param);
    }

    @Override
    public Leader getleaderLogin(String nickname,String passWord) {
        Map<String,Object> param=new HashMap<>();
        param.put("nickname",nickname);
        param.put("passWord",passWord);
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
