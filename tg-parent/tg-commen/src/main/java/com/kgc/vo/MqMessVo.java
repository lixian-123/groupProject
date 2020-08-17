package com.kgc.vo;

import java.io.Serializable;

/**
 * 消息中间件 类
 */
public class MqMessVo implements Serializable {
    private String token;
    private Integer goodsId;
    private Integer teamId;

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
}
