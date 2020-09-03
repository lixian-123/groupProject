package com.kgc.service.impl;

import com.kgc.Feign.MemberFeignClient;
import com.kgc.config.RabbitConfig;
import com.kgc.pojo.user.Member;
import com.kgc.service.MemberService;
import com.kgc.vo.Dto;
import com.kgc.vo.DtoUtil;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberFeignClient memberFeignClient;

    @Autowired
    private RabbitConfig rabbitConfig;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public Member getLogin(String nickname,String passWord) {
        Map<String,Object> param=new HashMap<>();
        param.put("nickname",nickname);
        param.put("passWord",passWord);
        return memberFeignClient.getLogin(param);
    }

    @Override
    public Member getMemberById(Integer id) {
        return memberFeignClient.getMemberById(id);
    }

    @Override
    public int update(Member member) {
        return memberFeignClient.update(member);
    }

    @Override
    public int add(Member member) {
        return memberFeignClient.add(member);
    }

    @Override
    public int delete(Integer id) {
        return memberFeignClient.delete(id);
    }

    @Override
    public Member getMemberFromRedis(String token) {
        System.out.println("service"+token);
        return memberFeignClient.getMemberFromRedis(token);
    }

    @Override
    public Dto messToRabbit(String name, String number) {
        rabbitConfig.createSGExchange();
        rabbitTemplate.convertAndSend("SGExchangeTopics","inform.sms",name+"参加了您发起的"+number+"团购");
        return DtoUtil.returnSuccess("发送成功");
    }

    @RabbitListener(queues = "tg")
    public void getMessFormRabbit(String mess){
        System.out.println(mess);
    }

    /*@Override
    public String aliPay(String subjectName, String orderNo, String amount) {
        return memberFeignClient.aliPay(subjectName,orderNo,amount);
    }*/
}
