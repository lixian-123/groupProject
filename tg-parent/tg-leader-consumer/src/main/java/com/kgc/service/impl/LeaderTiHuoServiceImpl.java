package com.kgc.service.impl;

import com.kgc.feign.LeaderTiHuoFeign;
import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.service.LeaderTiHuoService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LeaderTiHuoServiceImpl implements LeaderTiHuoService {
    @Autowired
    LeaderTiHuoFeign tiHuoFeign;

    @Override
    public PageUtil<Leader_tihuo> getTiHuoPage(Integer index, Integer size, Integer LeaderId) {
        Map<String,Object> map=new HashMap<>();
        map.put("index",(index-1)*size);
        map.put("size",size);
        map.put("LeaderId",LeaderId);

        return tiHuoFeign.getTiHuoPage(map);
    }

    @Override
    public int insertTihuo(Leader_tihuo tihuo) {
        return tiHuoFeign.insertTihuo(tihuo);
    }

    @Override
    public int delTihuo(Integer id) {
        return tiHuoFeign.delTihuo(id);
    }
}
