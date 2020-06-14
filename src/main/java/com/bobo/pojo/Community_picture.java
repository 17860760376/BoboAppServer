package com.bobo.pojo;

import java.util.Date;

public class Community_picture {
    private Integer id;

    private String theCommunityName;

    private String communityPicture;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTheCommunityName() {
        return theCommunityName;
    }

    public void setTheCommunityName(String theCommunityName) {
        this.theCommunityName = theCommunityName == null ? null : theCommunityName.trim();
    }

    public String getCommunityPicture() {
        return communityPicture;
    }

    public void setCommunityPicture(String communityPicture) {
        this.communityPicture = communityPicture == null ? null : communityPicture.trim();
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