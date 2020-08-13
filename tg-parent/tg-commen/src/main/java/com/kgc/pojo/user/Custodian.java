package com.kgc.pojo.user;

import java.io.Serializable;

public class Custodian implements Serializable {
    private Integer custId;//管理员编号
    private String custName;//昵称
    private String passWord;//密码
    private Integer goodsInfo;//管理商品信息权限
    private Integer userInfo;//用户信息权限
    private Integer orderInfo;//订单信息权限
    private Integer fundInfo;//资金信息权限

    public Custodian() {
    }

    public Custodian(Integer custId, String custName, String passWord, Integer goodsInfo, Integer userInfo, Integer orderInfo, Integer fundInfo) {
        this.custId = custId;
        this.custName = custName;
        this.passWord = passWord;
        this.goodsInfo = goodsInfo;
        this.userInfo = userInfo;
        this.orderInfo = orderInfo;
        this.fundInfo = fundInfo;
    }

    public Integer getCustId() {
        return custId;
    }

    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(Integer goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public Integer getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Integer userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(Integer orderInfo) {
        this.orderInfo = orderInfo;
    }

    public Integer getFundInfo() {
        return fundInfo;
    }

    public void setFundInfo(Integer fundInfo) {
        this.fundInfo = fundInfo;
    }
}
