package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_mess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

/**
 * 团长消息处理接口
 */
public interface Leader_messMapper {
    public List<Leader_mess> getAllLeaderMess(@Param("messTypeId")Integer messTypeId);
    public int add(Leader_mess leader_mess);

}
