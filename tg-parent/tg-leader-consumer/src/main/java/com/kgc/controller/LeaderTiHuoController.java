package com.kgc.controller;

import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.service.LeaderTiHuoService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class LeaderTiHuoController {
    @Autowired
    LeaderTiHuoService tiHuoService;

    @RequestMapping("/getTiHuoPage")
    public PageUtil<Leader_tihuo> getTiHuoPage(Integer index, Integer size, Integer LeaderId){
        return tiHuoService.getTiHuoPage(index, size, LeaderId);
    }

    @RequestMapping("/addTihuo")
    public int insertTihuo(Leader_tihuo tihuo){
        return tiHuoService.insertTihuo(tihuo);
    }

    @RequestMapping("/delTihuo")
    public int delTihuo(Integer id){
        return tiHuoService.delTihuo(id);
    }
}
