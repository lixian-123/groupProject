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
public class RestLeaderYJService {
    @Autowired
    Leader_yongjinMapper yongjinMapper;

}
