package com.bobo.pojo;

import java.util.Date;

public class Comments {
    private Integer id;

    private Integer status;

    private Integer dynamicOrCommentId;

    private String commentPublisherName;

    private Date commentPublishTime;

    private Date createTime;

    private Date updateTime;

    private Integer commentPariserNumber;

    private String commentContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDynamicOrCommentId() {
        return dynamicOrCommentId;
    }

    public void setDynamicOrCommentId(Integer dynamicOrCommentId) {
        this.dynamicOrCommentId = dynamicOrCommentId;
    }

    public String getCommentPublisherName() {
        return commentPublisherName;
    }

    public void setCommentPublisherName(String commentPublisherName) {
        this.commentPublisherName = commentPublisherName == null ? null : commentPublisherName.trim();
    }

    public Date getCommentPublishTime() {
        return commentPublishTime;
    }

    public void setCommentPublishTime(Date commentPublishTime) {
        this.commentPublishTime = commentPublishTime;
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

    public Integer getCommentPariserNumber() {
        return commentPariserNumber;
    }

    public void setCommentPariserNumber(Integer commentPariserNumber) {
        this.commentPariserNumber = commentPariserNumber;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }
}