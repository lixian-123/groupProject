package com.kgc.service;

import com.alibaba.fastjson.JSON;
import com.kgc.pojo.order.TeamOrder;
import com.kgc.util.DateUtil;
import com.kgc.util.RedisUtils;
import nl.bitwalker.useragentutils.UserAgent;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;

@RestController
public class RestLeaderService {
    @Resource
    RedisUtils redisUtils;
    @RequestMapping("/saveTeamRedis")
    public boolean saveTeamRedis(@RequestBody TeamOrder teamOrder) throws ParseException {
        String key="TeamGoods_"+teamOrder.getGoodsId();
        Date startTime= DateUtil.parse(teamOrder.getStartTime(),"yyyy-MM-dd hh:mm:ss");
        Date endTime=DateUtil.parse(teamOrder.getEndTime(),"yyyy-MM-dd hh:mm:ss");
        long betweenTime=DateUtil.getSecond(startTime,endTime);
        if(redisUtils.set(key, JSON.toJSONString(teamOrder))){
            return redisUtils.expire(key,betweenTime);
        }
        return false;

    }

}
