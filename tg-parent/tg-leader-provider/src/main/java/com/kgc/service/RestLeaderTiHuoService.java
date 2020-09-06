package com.kgc.service;

import com.kgc.mapper.Leader_tihuoMapper;
import com.kgc.pojo.leader.Leader_tihuo;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class RestLeaderTiHuoService {
    @Autowired
    Leader_tihuoMapper tihuoMapper;

    @RequestMapping("/getTiHuoPage")
    public PageUtil<Leader_tihuo> getTiHuoPage(@RequestParam Map<String,Object> map){
        PageUtil page=new PageUtil();
        page.setPageIndex(Integer.parseInt(map.get("index").toString()));
        page.setPageSize(Integer.parseInt(map.get("size").toString()));
        int count=tihuoMapper.getCount(map);
        List<Leader_tihuo> list=tihuoMapper.getTiHuoPage(map);
        page.setTotalCount(count);
        page.setList(list);
        return page;
    }

    @RequestMapping("/addTihuo")
    public int insertTihuo(@RequestBody Leader_tihuo tihuo){
        return tihuoMapper.add(tihuo);
    }

    @RequestMapping("/delTihuo/{id}")
    public int delTihuo(@PathVariable("id") Integer id){
        return tihuoMapper.delTihuo(id);
    }



}
