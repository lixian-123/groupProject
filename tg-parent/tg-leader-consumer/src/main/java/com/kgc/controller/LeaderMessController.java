package com.kgc.controller;

import com.kgc.pojo.leader.Leader_mess;
import com.kgc.service.LeaderMessService;
import com.kgc.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LeaderMessController {
    @Autowired
    LeaderMessService messService;
    @RequestMapping("showLeaderMess")
    public PageUtil<Leader_mess> getMessPage(Integer index, Integer size, Integer LeaderId){
        return messService.getMessPage(index, size, LeaderId);
    }
    @RequestMapping("addLeaderMess")
    public int insertMess(Leader_mess mess){
        return messService.insertMess(mess);
    }

    @RequestMapping("getMessById")
    public Leader_mess getMessById(Integer id){
        return messService.getMessById(id);
    }

    @RequestMapping("updateMess")
    public int updateMess(Leader_mess mess){
        return messService.updateMess(mess);
    }

    @RequestMapping("delMess")
    public int delMess(Integer id){
        return messService.delMess(id);
    }

    @RequestMapping("getAllMess")
    public List<Leader_mess> getAllMess(Integer LeaderId){
        return messService.getAllMess(LeaderId);
    }

}
