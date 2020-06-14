package com.bobo.pojo;

import java.util.Date;

public class CommunityActivitys {
    private Integer id;

    private Integer communityId;

    private String activityLabel;

    private Integer activityFocusonNumber;

    private Integer activityHeat;

    private String activityName;

    private Date activityTime;

    private String activityAddress;

    private Date createTime;

    private Date updateTime;

    private String activitiContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getActivityLabel() {
        return activityLabel;
    }

    public void setActivityLabel(String activityLabel) {
        this.activityLabel = activityLabel == null ? null : activityLabel.trim();
    }

    public Integer getActivityFocusonNumber() {
        return activityFocusonNumber;
    }

    public void setActivityFocusonNumber(Integer activityFocusonNumber) {
        this.activityFocusonNumber = activityFocusonNumber;
    }

    public Integer getActivityHeat() {
        return activityHeat;
    }

    public void setActivityHeat(Integer activityHeat) {
        this.activityHeat = activityHeat;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public String getActivityAddress() {
        return activityAddress;
    }

    public void setActivityAddress(String activityAddress) {
        this.activityAddress = activityAddress == null ? null : activityAddress.trim();
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

    public String getActivitiContent() {
        return activitiContent;
    }

    public void setActivitiContent(String activitiContent) {
        this.activitiContent = activitiContent == null ? null : activitiContent.trim();
    }
}