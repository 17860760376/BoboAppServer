package com.bobo.pojo;

import java.util.Date;

public class UserAttention {
    private Integer id;

    private String followBoboNumber;

    private String befollowBoboNumber;

    private Integer relationship;

    private Date focusOnTime;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFollowBoboNumber() {
        return followBoboNumber;
    }

    public void setFollowBoboNumber(String followBoboNumber) {
        this.followBoboNumber = followBoboNumber == null ? null : followBoboNumber.trim();
    }

    public String getBefollowBoboNumber() {
        return befollowBoboNumber;
    }

    public void setBefollowBoboNumber(String befollowBoboNumber) {
        this.befollowBoboNumber = befollowBoboNumber == null ? null : befollowBoboNumber.trim();
    }

    public Integer getRelationship() {
        return relationship;
    }

    public void setRelationship(Integer relationship) {
        this.relationship = relationship;
    }

    public Date getFocusOnTime() {
        return focusOnTime;
    }

    public void setFocusOnTime(Date focusOnTime) {
        this.focusOnTime = focusOnTime;
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