package com.kgc.pojo.goods;

public class Category {
    private int categoryid;//  序号
    private String type;//  商品种类

    public Category() {
    }

    public Category(int categoryid, String type) {
        this.categoryid = categoryid;
        this.type = type;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
