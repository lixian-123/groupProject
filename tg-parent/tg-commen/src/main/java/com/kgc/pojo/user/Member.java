package com.kgc.pojo.user;

import java.io.Serializable;

public class Member implements Serializable {
    private Integer userId;//用户编号
    private String nickname;//昵称
    private String passWord;//密码
    private String userName;//用户姓名
    private Integer userAge;//年龄
    private String userAddress;//住址
    private String userPhone;//手机号
    private String card;//身份证
    private Integer userVIP;//是否为VIP
    private String userCreateTime;//注册时间
    private Integer cloenelId;//团长编号

    public Member() {
    }

    public Member(Integer userId, String nickname, String passWord, String userName, Integer userAge, String userAddress, String userPhone, String card, Integer userVIP, String userCreateTime, Integer cloenelId) {
        this.userId = userId;
        this.nickname = nickname;
        this.passWord = passWord;
        this.userName = userName;
        this.userAge = userAge;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.card = card;
        this.userVIP = userVIP;
        this.userCreateTime = userCreateTime;
        this.cloenelId = cloenelId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public Integer getUserVIP() {
        return userVIP;
    }

    public void setUserVIP(Integer userVIP) {
        this.userVIP = userVIP;
    }

    public String getUserCreateTime() {
        return userCreateTime;
    }

    public void setUserCreateTime(String userCreateTime) {
        this.userCreateTime = userCreateTime;
    }

    public Integer getCloenelId() {
        return cloenelId;
    }

    public void setCloenelId(Integer cloenelId) {
        this.cloenelId = cloenelId;
    }
}
