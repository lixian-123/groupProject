package com.kgc.servie.impl;

import com.alibaba.fastjson.JSON;
import com.kgc.feign.OrderDetailFeign;
import com.kgc.feign.TeamOrderFeign;
import com.kgc.pojo.order.OrderDetail;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.pojo.user.Member;
import com.kgc.servie.TeamOrderService;
import com.kgc.util.RedisUtils;
import com.kgc.vo.MqMessVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamOrderServiceImpl implements TeamOrderService {
    @Autowired
    TeamOrderFeign teamOrderFeign;
    @Autowired
    OrderDetailFeign orderDetailFeign;
    @Autowired
    RedisUtils redisUtils;
    @Override
    public List<TeamOrder> getAllTeam(Integer leaderId) {
        return teamOrderFeign.showTeam(leaderId);
    }

    @Override
    public int add(TeamOrder teamOrder) {
        return teamOrderFeign.addTeam(teamOrder);
    }



    @Override
    public int update(TeamOrder teamOrder) {
        return 0;
    }

    @Override
    public int delete(Integer teamId) {
        return 0;
    }

    @Override
    public int updateGoodsNum(Map<String, Object> map) {
        String mqJson=map.get("mqMessVo").toString();
        MqMessVo mqMessVo= JSON.parseObject(mqJson,MqMessVo.class);
        String memberJson=map.get("member").toString();
        Member member=JSON.parseObject(memberJson,Member.class);
        String key="TeamGoods_"+mqMessVo.getGoodsId();
        String TeamJson=redisUtils.get(key).toString();
        TeamOrder teamOrder= JSON.parseObject(TeamJson,TeamOrder.class);
        int versionValue=teamOrderFeign.getVersion(teamOrder.getTeamId());
        Map<String,Object> teamMap=new HashMap<>();
        teamMap.put("teamId",teamOrder.getTeamId());
        teamMap.put("versionValue",versionValue);
        teamMap.put("goodsNumber",teamOrder.getGoodsNumber()-mqMessVo.getGoodsNum());
        Map<String,Object> DetailMap=new HashMap<>();
        DetailMap.put("UserId",member.getUserId());
        DetailMap.put("goodsId",teamOrder.getGoodsId());
        DetailMap.put("goodsNum",mqMessVo.getGoodsNum());
        DetailMap.put("leaderId",teamOrder.getLeaderId());
        DetailMap.put("sumMoney",mqMessVo.getSumMoney());
        try {
            this.updateTeam(teamMap,DetailMap);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
    @Transactional(rollbackFor = Exception.class)
    public void updateTeam(Map<String,Object> teamMap,Map<String,Object> DetailMap){
        try{
            teamOrderFeign.updateGoodsNum(teamMap);
            OrderDetail orderDetail=new OrderDetail();
            orderDetail.setUserId(Integer.parseInt(DetailMap.get("UserId").toString()));
            orderDetail.setGoodsId(Integer.parseInt(DetailMap.get("goodsId").toString()));
            orderDetail.setGoodsNumber(Integer.parseInt(DetailMap.get("goodsNum").toString()));
            orderDetail.setLeaderId(Integer.parseInt(DetailMap.get("leaderId").toString()));
            orderDetail.setSumMoney(Double.parseDouble(DetailMap.get("sumMoney").toString()));
            orderDetail.setOrderState(1);
            orderDetail.setOrderType(1);
            orderDetailFeign.addDetail(orderDetail);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
