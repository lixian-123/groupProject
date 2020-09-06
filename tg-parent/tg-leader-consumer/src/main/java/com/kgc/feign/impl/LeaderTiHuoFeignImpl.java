package com.kgc.feign.impl;

import com.kgc.feign.LeaderTiHuoFeign;
import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class LeaderTiHuoFeignImpl implements LeaderTiHuoFeign {

    @Override
    public PageUtil<Leader_tihuo> getTiHuoPage(Map<String, Object> map) {
        return null;
    }

    @Override
    public int insertTihuo(Leader_tihuo tihuo) {
        return 0;
    }

    @Override
    public int delTihuo(Integer id) {
        return 0;
    }
}
