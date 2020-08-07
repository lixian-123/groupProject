package com.kgc.pojo.leader;

import java.io.Serializable;

/**
 * 提货记录表
 */
public class Leader_tihuo implements Serializable {
    //提货订单id
    private Integer id;
    //团长id
    private Integer leaderId;
    //订单id
    private Integer orderId;
    //提货时间
    private String time;

    public Leader_tihuo() {
    }

    public Leader_tihuo(Integer id, Integer orderId, String time,Integer leaderId) {
        this.id = id;
        this.orderId = orderId;
        this.time = time;
        this.leaderId=leaderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
    }
}
