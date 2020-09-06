package com.kgc.pojo.leader;

import java.io.Serializable;

/**
 * 团长业绩表
 */
public class Leader_sale implements Serializable {
    //业绩信息表id
    private Integer id;
    //团长id
    private Integer LeaderId;
    //提成
    private double Ticheng;
    //订单号
    private Integer Dingdan;
    //销售额
    private double Salemoney;
    private String data;

    public Leader_sale() {
    }

    public Leader_sale(Integer id, Integer leaderId, double ticheng, Integer Dingdan, double salemoney, String data) {
        this.id = id;
        LeaderId = leaderId;
        Ticheng = ticheng;
        this.Dingdan = Dingdan;
        Salemoney = salemoney;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLeaderId() {
        return LeaderId;
    }

    public void setLeaderId(Integer leaderId) {
        LeaderId = leaderId;
    }

    public double getTicheng() {
        return Ticheng;
    }

    public void setTicheng(double ticheng) {
        Ticheng = ticheng;
    }

    public Integer getDingdan() {
        return Dingdan;
    }

    public void setDingdan(Integer Dingdan) {
        this.Dingdan = Dingdan;
    }

    public double getSalemoney() {
        return Salemoney;
    }

    public void setSalemoney(double salemoney) {
        Salemoney = salemoney;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
