package com.kgc.service;

import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.util.PageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface LeaderTiHuoService {

    public PageUtil<Leader_tihuo> getTiHuoPage(Integer index,Integer size,Integer LeaderId);

    public int insertTihuo(Leader_tihuo tihuo);

    public int delTihuo(Integer id);
}
