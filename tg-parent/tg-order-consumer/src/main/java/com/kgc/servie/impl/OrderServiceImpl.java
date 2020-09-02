package com.kgc.servie.impl;

import com.alibaba.fastjson.JSON;

import com.kgc.config.RabbitConfig;
import com.kgc.feign.GoodsFeign;
import com.kgc.feign.MemberFeign;
import com.kgc.feign.TeamOrderFeign;

import com.kgc.pojo.order.TeamOrder;
import com.kgc.pojo.user.Member;
import com.kgc.servie.OrderService;
import com.kgc.vo.Dto;
import com.kgc.vo.DtoUtil;
import com.kgc.vo.MqMessVo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    MemberFeign memberFeign;
    @Autowired
    GoodsFeign goodsFeign;
    @Autowired
    TeamOrderFeign teamOrderFeign;

    @Autowired
    RabbitConfig rabbitConfig;
    @Autowired
    RabbitTemplate rabbitTemplate;
    //封装消息并发送到Rabbit中
    public Dto UserMess(Map<String,Object> map){
        MqMessVo mqMessVo=new MqMessVo();
        Integer goodsId=Integer.parseInt((String) map.get("goodsId"));
        String token=(String) map.get("token");
        Integer goodsNum=Integer.parseInt((String)map.get("goodsNum"));
        Integer teamId=Integer.parseInt((String) map.get("teamId"));
        Double sumMoney=Double.parseDouble((String)map.get("sumMoney"));
        mqMessVo.setGoodsId(goodsId);
        mqMessVo.setGoodsNum(goodsNum);
        mqMessVo.setToken(token);
        mqMessVo.setTeamId(teamId);
        mqMessVo.setSumMoney(sumMoney);
        rabbitConfig.createSMSQueue();
        rabbitTemplate.convertAndSend("TGExchangeTopics","inform.email.sms",mqMessVo);
        return DtoUtil.returnSuccess("正在排队中");
    }
    @RabbitListener(queues ="tg")
    public void getUserMess(MqMessVo mqMessVo){
        try{
            String token=mqMessVo.getToken();
            Member member=memberFeign.getMemberFromRedis(token);
            String memberJSON=JSON.toJSONString(member);
            String mqMessVoJSON=JSON.toJSONString(mqMessVo);
            if(member==null) {
                return;
            }
            String key="TeamGoods_"+mqMessVo.getGoodsId();
            int num=goodsFeign.checkNumberTeam(mqMessVo.getGoodsId());
            if(num<=0){
                System.out.println("库存不足");
                return;
            }
            Map<String,Object> map=new HashMap<>();
            map.put("token",token);
            map.put("member",memberJSON);
            map.put("mqMessVo",mqMessVoJSON);
            int check=teamOrderFeign.updateGoodsNum(map);
            if(check==0){
                System.out.println("下单失败");
                return;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
