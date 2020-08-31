package com.kgc.servie.impl;

import com.alibaba.fastjson.JSON;

import com.kgc.config.RabbitConfig;
import com.kgc.feign.GoodsFeign;
import com.kgc.feign.MemberFeign;
import com.kgc.feign.TeamOrderFeign;

import com.kgc.pojo.order.TeamOrder;
import com.kgc.pojo.user.Member;
import com.kgc.vo.Dto;
import com.kgc.vo.DtoUtil;
import com.kgc.vo.MqMessVo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    MemberFeign memberFeign;
    @Autowired
    GoodsFeign goodsFeign;
    @Autowired
    TeamOrderFeign teamOrderFeign;
    @Resource
    MqMessVo mqMessVo;
    @Autowired
    RabbitConfig rabbitConfig;
    @Autowired
    RabbitTemplate rabbitTemplate;
    //封装消息并发送到Rabbit中
    @RequestMapping("/UserMess")
    public Dto UserMess(String token, @RequestParam("goodsId") Integer goodsId, @RequestParam("teamId")Integer teamId){
        mqMessVo.setGoodsId(goodsId);
        mqMessVo.setToken(token);
        mqMessVo.setTeamId(teamId);
        rabbitConfig.createSMSQueue("tg");
        rabbitTemplate.convertAndSend("myexchangeTopics","inform.email.sms",mqMessVo);
        return DtoUtil.returnSuccess("正在排队中");
    }
    @RabbitListener(queues ="tg")
    public void getUserMess(MqMessVo mqMessVo){
        String token=mqMessVo.getToken();
        Member member=memberFeign.getMemberFromRedis(token);
        if(member==null) {
            return;
        }
        String key="TeamGoods_"+mqMessVo.getGoodsId();
        try{
        try{
            String key="TeamGoods_"+mqMessVo.getGoodsId();

            redisTemplate.watch(key);
            redisTemplate.multi();
            int num=goodsFeign.checkNumberTeam(mqMessVo.getGoodsId());
            if(num<=0){
                return;
            }
            String TeamJson=redisTemplate.opsForValue().get(token).toString();
            TeamOrder teamOrder= JSON.parseObject(TeamJson,TeamOrder.class);
            int versionValue=teamOrder.getVersion();
            teamOrder.setGoodsNumber(teamOrder.getGoodsNumber()-mqMessVo.getGoodsNum());
            redisTemplate.opsForValue().set(key,teamOrder);
            teamOrderFeign.updateTeam(teamOrder);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
