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
    public TeamOrder getTeamOrder(@RequestParam("teamId")Integer teamId){
        return teamOrderMapper.getTeamOrder(teamId);
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

    //修改库存
    @Transactional(rollbackFor = Exception.class)//开启事务注解
    @RequestMapping("/updateGoodsNum")
    public int updateGoodsNum(@RequestParam Map<String,Object> map) throws Exception{
        //从map中得到类MqMessVo的JSON字符串
        String mqJson=map.get("mqMessVo").toString();
        //JSON字符串转为类对象
        MqMessVo mqMessVo=JSON.parseObject(mqJson,MqMessVo.class);
        //从map中得到用户的信息
        String memberJson=map.get("member").toString();
        Member member=JSON.parseObject(memberJson,Member.class);
        //从map中得到token
        String token=map.get("token").toString();
        //得到redis的key值
        String key="TeamGoods_"+mqMessVo.getGoodsId();
        System.out.println(key+","+token);
        String TeamJson=redisUtils.get(key).toString();
        TeamOrder teamOrder= JSON.parseObject(TeamJson,TeamOrder.class);
        //根据团长id和商品id得到当前团购商品
        int versionValue=teamOrderMapper.getVersion(teamOrder.getTeamId());
        System.out.println(versionValue);
        HashMap<String, Object> upMap = new HashMap<>();
        upMap.put("teamId",teamOrder.getTeamId());
        upMap.put("versionValue",versionValue);
        upMap.put("goodsId",teamOrder.getGoodsId());
        upMap.put("goodsNumber",teamOrder.getGoodsNumber()-mqMessVo.getGoodsNum());
        try{
            if(teamOrderMapper.updateGoodsNum(upMap)>0){
                OrderDetail orderDetail=new OrderDetail();
                orderDetail.setUserId(member.getUserId());
                orderDetail.setGoodsId(teamOrder.getGoodsId());
                orderDetail.setGoodsNumber(mqMessVo.getGoodsNum());
                orderDetail.setLeaderId(teamOrder.getLeaderId());
                orderDetail.setSumMoney(mqMessVo.getSumMoney());
                orderDetail.setOrderState(1);
                orderDetail.setOrderType(1);
                detailMapper.add(orderDetail);
                Thread.sleep(1000*10);
                redisTemplate.delete(key);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

}
