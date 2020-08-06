package com.kgc.pojo.shops;

import java.io.Serializable;

public class ShopCar implements Serializable {
    private Integer shopId;//购物车编号
    private Integer userId;//用户编号
    private Integer goodsId;//商品编号
    private Integer goodsNumber;//商品数量
    private String shopTime;//加入时间

    public ShopCar() {
    }

    public ShopCar(Integer shopId, Integer userId, Integer goodsId, Integer goodsNumber, String shopTime) {
        this.shopId = shopId;
        this.userId = userId;
        this.goodsId = goodsId;
        this.goodsNumber = goodsNumber;
        this.shopTime = shopTime;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getShopTime() {
        return shopTime;
    }

    public void setShopTime(String shopTime) {
        this.shopTime = shopTime;
    }
}
