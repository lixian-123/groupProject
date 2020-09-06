package com.kgc.pojo.order;





import java.io.Serializable;


/**
 * 团购订单
 */
public class TeamOrder implements Serializable {
    private Integer teamId; //团购类型id
    private Integer goodsId; //商品id
    private Integer leaderId; //团长id
    private Integer orderType; //订单类型
    private Integer goodsNumber; //商品剩余数量
    private Integer quota; //限购量
    private String startTime;//开始时间
    private String endTime;//结束时间
    private Integer version;//版本号

    public TeamOrder() {
    }

    public TeamOrder(Integer teamId, Integer goodsId, Integer leaderId, Integer orderType, Integer goodsNumber, Integer quota, String startTime, String endTime, Integer version) {
        this.teamId = teamId;
        this.goodsId = goodsId;
        this.leaderId = leaderId;
        this.orderType = orderType;
        this.goodsNumber = goodsNumber;
        this.quota = quota;
        this.startTime = startTime;
        this.endTime = endTime;
        this.version = version;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
