package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.mapper.OrderDetailMapper;
import com.kgc.mapper.TeamOrderMapper;
import com.kgc.pojo.order.OrderDetail;
import com.kgc.pojo.order.RetailOrder;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.pojo.user.Member;
import com.kgc.util.RedisDataSourceTransaction;
import com.kgc.util.RedisUtils;
import com.kgc.vo.MqMessVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RestTeamOrderService {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    RedisDataSourceTransaction redisDataSourceTransaction;
    @Autowired
    OrderDetailMapper detailMapper;
    @Autowired
    TeamOrderMapper teamOrderMapper;
    @Resource
    RedisTemplate redisTemplate;
    @RequestMapping("/showTeam")
    public List<TeamOrder> showTeam(@RequestParam("leaderId")Integer leaderId){
        return  teamOrderMapper.getAllTeam(leaderId);
    }
    @RequestMapping("/getTeamOrder")
    public TeamOrder getTeamOrder(@RequestParam("startTime")String startTime,@RequestParam("endTime")String endTime){
        return teamOrderMapper.getTeamOrder(startTime, endTime);
    }
    @RequestMapping("/addTeam")
    public int addTeam(@RequestBody TeamOrder teamOrder){
        return  teamOrderMapper.add(teamOrder);
    }
    @RequestMapping("/updateTeam")
    public int updateTeam(@RequestBody TeamOrder teamOrder,@RequestParam("versionValue")Integer versionValue){
        return  teamOrderMapper.update(teamOrder,versionValue);
    }
    @RequestMapping("/deleteTeam")
    public int deleteTeam(@RequestParam("teamId")Integer teamId){
        return teamOrderMapper.delete(teamId);
    }
    @RequestMapping("/getVersion")
    public int getVersion(@RequestParam("teamId")Integer teamId){
        return  teamOrderMapper.getVersion(teamId);
    }

    @Transactional(rollbackFor = Exception.class)//开启事务注解
    @RequestMapping("/updateGoodsNum")
    public int updateGoodsNum(@RequestParam Map<String,Object> map) throws Exception{

        TransactionStatus transactionStatus=null;
        String mqJson=(String) map.get("mqMessVo");
        MqMessVo mqMessVo=JSON.parseObject(mqJson,MqMessVo.class);
        String memberJson=(String)map.get("member");
        Member member=JSON.parseObject(memberJson,Member.class);
        String token=(String)map.get("token");
        String key="TeamGoods_"+mqMessVo.getGoodsId();
        System.out.println(key+","+token);
        String TeamJson=redisUtils.get(key).toString();
        TeamOrder teamOrder= JSON.parseObject(TeamJson,TeamOrder.class);
        int versionValue=teamOrderMapper.getVersion(teamOrder.getTeamId());
        map.put("teamId",teamOrder.getTeamId());
        map.put("versionValue",versionValue);
        map.put("goodsNumber",teamOrder.getGoodsNumber());
        try{
            transactionStatus=redisDataSourceTransaction.begin();
            //更改redis缓存的数据
            teamOrder.setGoodsNumber(teamOrder.getGoodsNumber()-mqMessVo.getGoodsNum());
            teamOrder.setVersion(teamOrder.getVersion()+1);
            redisTemplate.opsForValue().set(key,JSON.toJSONString(teamOrder));
        }catch (Exception e){
            throw new Exception("sad");
        }
        try{
            if(teamOrderMapper.updateGoodsNum(map)>0){
                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setUserId(member.getUserId());
                orderDetail.setGoodsId(teamOrder.getGoodsId());
                orderDetail.setGoodsNumber(mqMessVo.getGoodsNum());
                orderDetail.setLeaderId(teamOrder.getLeaderId());
                orderDetail.setSumMoney(mqMessVo.getSumMoney());
                orderDetail.setOrderState(1);
                orderDetail.setOrderType(1);
                detailMapper.add(orderDetail);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

}
