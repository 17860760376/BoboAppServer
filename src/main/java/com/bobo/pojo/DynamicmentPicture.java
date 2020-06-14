package com.bobo.pojo;

import java.util.Date;

public class DynamicmentPicture {
    private Integer id;

    private Integer dynamicmentId;

    private String picture;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDynamicmentId() {
        return dynamicmentId;
    }

    public void setDynamicmentId(Integer dynamicmentId) {
        this.dynamicmentId = dynamicmentId;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}