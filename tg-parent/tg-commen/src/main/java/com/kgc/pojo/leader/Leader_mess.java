package com.kgc.pojo.leader;

import java.io.Serializable;

/**
 * 团长消息表
 */
public class Leader_mess implements Serializable {
    //消息id
    private Integer id;
    //消息内容
    private String content;
    //消息类型id
    private Integer messTypeId;
    private String time;
    private Integer MemberId;
    private Integer LeaderId;

    public Leader_mess() {
    }

    public Leader_mess(Integer id, String content, Integer messTypeId, String time, Integer memberId, Integer leaderId) {
        this.id = id;
        this.content = content;
        this.messTypeId = messTypeId;
        this.time = time;
        MemberId = memberId;
        LeaderId = leaderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getMessTypeId() {
        return messTypeId;
    }

    public void setMessTypeId(Integer messTypeId) {
        this.messTypeId = messTypeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getMemberId() {
        return MemberId;
    }

    public void setMemberId(Integer memberId) {
        MemberId = memberId;
    }

    public Integer getLeaderId() {
        return LeaderId;
    }

    public void setLeaderId(Integer leaderId) {
        LeaderId = leaderId;
    }
}
