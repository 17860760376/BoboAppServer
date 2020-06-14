package com.bobo.pojo;

import java.util.Date;

public class Communitys {
    private Integer id;

    private String communityName;

    private String communityCreater;

    private String communitySymbol;

    private Integer communityHeat;

    private Integer communityLoginNumber;

    private Integer communityMemberNumber;

    private Integer communityFocusonNumber;

    private Date createTime;

    private Date updateTime;

    private Integer communityActivityNumber;

    private String communityIntroduction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommunityName() {
        return communityName;
    }

    public void setCommunityName(String communityName) {
        this.communityName = communityName == null ? null : communityName.trim();
    }

    public String getCommunityCreater() {
        return communityCreater;
    }

    public void setCommunityCreater(String communityCreater) {
        this.communityCreater = communityCreater == null ? null : communityCreater.trim();
    }

    public String getCommunitySymbol() {
        return communitySymbol;
    }

    public void setCommunitySymbol(String communitySymbol) {
        this.communitySymbol = communitySymbol == null ? null : communitySymbol.trim();
    }

    public Integer getCommunityHeat() {
        return communityHeat;
    }

    public void setCommunityHeat(Integer communityHeat) {
        this.communityHeat = communityHeat;
    }

    public Integer getCommunityLoginNumber() {
        return communityLoginNumber;
    }

    public void setCommunityLoginNumber(Integer communityLoginNumber) {
        this.communityLoginNumber = communityLoginNumber;
    }

    public Integer getCommunityMemberNumber() {
        return communityMemberNumber;
    }

    public void setCommunityMemberNumber(Integer communityMemberNumber) {
        this.communityMemberNumber = communityMemberNumber;
    }

    public Integer getCommunityFocusonNumber() {
        return communityFocusonNumber;
    }

    public void setCommunityFocusonNumber(Integer communityFocusonNumber) {
        this.communityFocusonNumber = communityFocusonNumber;
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

    public Integer getCommunityActivityNumber() {
        return communityActivityNumber;
    }

    public void setCommunityActivityNumber(Integer communityActivityNumber) {
        this.communityActivityNumber = communityActivityNumber;
    }

    public String getCommunityIntroduction() {
        return communityIntroduction;
    }

    public void setCommunityIntroduction(String communityIntroduction) {
        this.communityIntroduction = communityIntroduction == null ? null : communityIntroduction.trim();
    }
}