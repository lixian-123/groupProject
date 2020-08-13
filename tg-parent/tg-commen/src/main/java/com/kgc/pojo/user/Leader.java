package com.kgc.pojo.user;

import java.io.Serializable;

public class Leader implements Serializable {
    private Integer leaderId;//团长编号
    private String nickname;//昵称
    private String passWord;//密码
    private String leaderName ;//团长姓名
    private Integer leaderAge ;//年龄
    private String leaderAddress ;//住址
    private String leaderPhone ;//手机号
    private String card;//身份证
    private String leaderArea ;//负责区域

    //无参
    public Leader() {
    }

    //有参

    public Leader(String nickname, String passWord){
        this.nickname = nickname;
        this.passWord = passWord;

    }
    public Leader(Integer leaderId, String nickname, String passWord, String leaderName, Integer leaderAge, String leaderAddress, String leaderPhone, String card, String leaderArea) {
        this.leaderId = leaderId;
        this.nickname = nickname;
        this.passWord = passWord;
        this.leaderName = leaderName;
        this.leaderAge = leaderAge;
        this.leaderAddress = leaderAddress;
        this.leaderPhone = leaderPhone;
        this.card = card;
        this.leaderArea = leaderArea;
    }

    public Integer getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Integer leaderId) {
        this.leaderId = leaderId;
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

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public Integer getLeaderAge() {
        return leaderAge;
    }

    public void setLeaderAge(Integer leaderAge) {
        this.leaderAge = leaderAge;
    }

    public String getLeaderAddress() {
        return leaderAddress;
    }

    public void setLeaderAddress(String leaderAddress) {
        this.leaderAddress = leaderAddress;
    }

    public String getLeaderPhone() {
        return leaderPhone;
    }

    public void setLeaderPhone(String leaderPhone) {
        this.leaderPhone = leaderPhone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getLeaderArea() {
        return leaderArea;
    }

    public void setLeaderArea(String leaderArea) {
        this.leaderArea = leaderArea;
    }
}
