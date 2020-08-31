package com.kgc.vo;

import java.io.Serializable;

/**
 * 消息中间件 类
 */
public class MqMessVo implements Serializable {
    private String token;//用户token
    private Integer goodsId;//商品
    private Integer teamId;//团购订单id
    private Integer goodsNum;//用户购买的数量
    private Double sumMoney;//用户支付的总价格

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(Double sumMoney) {
        this.sumMoney = sumMoney;
    }
}
