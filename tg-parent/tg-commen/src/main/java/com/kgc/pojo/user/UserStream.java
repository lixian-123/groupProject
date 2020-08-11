package com.kgc.pojo.user;

import java.io.Serializable;

public class UserStream implements Serializable {
    private Integer id;//流水编号
    private Integer orderId;//订单编号
    private Double money;//

    public UserStream() {
    }

    public UserStream(Integer id, Integer orderId, Double money) {
        this.id = id;
        this.orderId = orderId;
        this.money = money;
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

    public Double getMoney() {
        return money;
    }

    public void setMonry(Double money) {
        this.money = money;
    }
}
