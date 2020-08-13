package com.kgc.pojo.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 团购订单
 */
public class TeamOrder {
    private Integer teamId; //团购类型id
    private Integer goodsId; //商品id
    private Integer leaderId; //团长id
    private Integer orderType; //订单类型
    private Integer goodsNumber; //商品剩余数量
    private Integer quota; //限购量
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date startTime;//开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endTime;//结束时间

    public TeamOrder() {
    }

    public TeamOrder(Integer teamId, Integer goodsId, Integer leaderId, Integer orderType, Integer goodsNumber, Integer quota, Date startTime, Date endTime) {
        this.teamId = teamId;
        this.goodsId = goodsId;
        this.leaderId = leaderId;
        this.orderType = orderType;
        this.goodsNumber = goodsNumber;
        this.quota = quota;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public Integer getQuota() {
        return quota;
    }

    public void setQuota(Integer quota) {
        this.quota = quota;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
