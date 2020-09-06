package com.kgc.service;

import com.kgc.mapper.Leader_yongjinMapper;
import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestLeaderYJService {
    @Autowired
    Leader_yongjinMapper yongjinMapper;

    @RequestMapping("/getYongJinByLeader/{leaderId}")
    public Leader_yongjin getYongJinByLeader(@PathVariable("leaderId") Integer leaderId){
        return yongjinMapper.getYongJinByLeader(leaderId);
    }

    @RequestMapping("/updateYongjin")
    public int updateYongjin(@RequestBody Leader_yongjin yongjin){
        return yongjinMapper.updateYongJinByLeader(yongjin);
    }

    @RequestMapping("/addYongjin")
    public int addYongjin(@RequestBody Leader_yongjin yongjin){
        return yongjinMapper.insertYongJin(yongjin);
    }


}
