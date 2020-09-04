package com.kgc.mapper;

import com.kgc.pojo.leader.Leader_mess;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 团长消息处理接口
 */
public interface Leader_messMapper {
    /**
     *  消息分页显示数据
     * @param param
     * @return
     */
    List<Leader_mess> getAllMessPage(Map<String,Object> param);

    /**
     * 消息总条数
     * @param param
     * @return
     */
    int getCount(Map<String,Object> param);

    /**
     * 消息添加
     * @param leader_mess
     * @return
     */
    int addMess(Leader_mess leader_mess);

    /**
     * 查询单个消息详情
     * @param id
     * @return
     */
    Leader_mess getMessById(Integer id);

    /**
     * 消息更新
     * @param leader_mess
     * @return
     */
    int updateMess(Leader_mess leader_mess);

    /**
     * 删除消息
     * @param id
     * @return
     */
    int delMess(Integer id);

    /**
     * 查询某团长所有的消息
     * @return
     */
    List<Leader_mess> getAllMess(Integer LeaderId);

}
