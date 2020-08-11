package com.kgc.service;

import com.kgc.mapper.Leader_yongjinMapper;
import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestLeaderYJ {
    @Autowired
    Leader_yongjinMapper yongjinMapper;
    @RequestMapping("/showLeaderYJ")
    public List<Leader_yongjin> getAllYongJin(@RequestParam("leaderId") Integer leaderId){
        return yongjinMapper.getAllYongJin(leaderId);
    }
    @RequestMapping("/addLeaderYJ")
    public int add(@RequestBody Leader_yongjin leader_yongjin){
        return yongjinMapper.add(leader_yongjin);
    }
    @RequestMapping("/updateLeaderYJ")
    public int update(@RequestBody Leader_yongjin leader_yongjin){
        return yongjinMapper.update(leader_yongjin);
    }
}
