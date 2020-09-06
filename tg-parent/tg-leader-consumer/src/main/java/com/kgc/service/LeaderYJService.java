package com.kgc.service;

import com.kgc.pojo.leader.Leader_yongjin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface LeaderYJService {

    public Leader_yongjin getYongJinByLeader(Integer leaderId);

    public int updateYongjin(Leader_yongjin yongjin);

    public int addYongjin(Leader_yongjin yongjin);

    //计算订单佣金
    public void DingDanYongJin();
}
