package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_yongjin;

import java.util.List;

/**
 * 团长佣金处理接口
 */
public interface Leader_yongjinMapper {
    /**
     * 查询某个团长的佣金信息
     * @param leader
     * @return
     */
    Leader_yongjin getYongJinByLeader(Integer leader);

    /**
     * 更改某个团长的佣金
     * @param yongjin
     * @return
     */
    int updateYongJinByLeader(Leader_yongjin yongjin);

    /**
     * 添加佣金信息
     * @param yongjin
     * @return
     */
    int insertYongJin(Leader_yongjin yongjin);
}
