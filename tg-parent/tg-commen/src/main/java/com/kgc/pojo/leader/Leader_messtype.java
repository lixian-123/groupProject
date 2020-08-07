package com.kgc.pojo.leader;

import java.io.Serializable;

/**
 * 团长信息分类表
 */
public class Leader_messtype implements Serializable {
    //分类id
    private Integer typeId;
    //分类名
    private String typeName;

    public Leader_messtype() {
    }

    public Leader_messtype(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
