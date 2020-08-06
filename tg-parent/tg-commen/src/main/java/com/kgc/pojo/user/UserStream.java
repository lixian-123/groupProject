package com.kgc.pojo.user;

import java.io.Serializable;

public class UserStream implements Serializable {
    private Integer id;//流水编号
    private Integer orderId;//订单编号
    private Double monry;//

    public UserStream() {
    }

    public UserStream(Integer id, Integer orderId, Double monry) {
        this.id = id;
        this.orderId = orderId;
        this.monry = monry;
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

    public Double getMonry() {
        return monry;
    }

    public void setMonry(Double monry) {
        this.monry = monry;
    }
}
