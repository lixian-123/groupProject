package com.kgc.feign.impl;

import com.kgc.feign.LeaderFeign;
import com.kgc.feign.LeaderMessFeign;
import com.kgc.pojo.leader.Leader_mess;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LeaderMessFeignImpl implements LeaderMessFeign{

    @Override
    public PageUtil<Leader_mess> getMessPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public int insertMess(Leader_mess mess) {
        return 0;
    }

    @Override
    public Leader_mess getMessById(Integer id) {
        return null;
    }

    @Override
    public int updateMess(Leader_mess mess) {
        return 0;
    }

    @Override
    public int delMess(Integer id) {
        return 0;
    }

    @Override
    public List<Leader_mess> getAllMess(Integer LeaderId) {
        return null;
    }
}
