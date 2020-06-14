package com.bobo.pojo;

import java.util.Date;

public class Dynamicment {
    private Integer id;

    private String publisherBoboNumber;

    private String dynamicmentCategory;

    private String publisherPort;

    private String publisherName;

    private Date publishTime;

    private Date createTime;

    private Date updateTime;

    private Integer dynamicmentPariserNumber;

    private Integer dynamicCommentNumber;

    private Integer dynamicTranmitNumber;

    private String dynamicmentContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPublisherBoboNumber() {
        return publisherBoboNumber;
    }

    public void setPublisherBoboNumber(String publisherBoboNumber) {
        this.publisherBoboNumber = publisherBoboNumber == null ? null : publisherBoboNumber.trim();
    }

    public String getDynamicmentCategory() {
        return dynamicmentCategory;
    }

    public void setDynamicmentCategory(String dynamicmentCategory) {
        this.dynamicmentCategory = dynamicmentCategory == null ? null : dynamicmentCategory.trim();
    }

    public String getPublisherPort() {
        return publisherPort;
    }

    public void setPublisherPort(String publisherPort) {
        this.publisherPort = publisherPort == null ? null : publisherPort.trim();
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName == null ? null : publisherName.trim();
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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

    public Integer getDynamicmentPariserNumber() {
        return dynamicmentPariserNumber;
    }

    public void setDynamicmentPariserNumber(Integer dynamicmentPariserNumber) {
        this.dynamicmentPariserNumber = dynamicmentPariserNumber;
    }

    public Integer getDynamicCommentNumber() {
        return dynamicCommentNumber;
    }

    public void setDynamicCommentNumber(Integer dynamicCommentNumber) {
        this.dynamicCommentNumber = dynamicCommentNumber;
    }

    public Integer getDynamicTranmitNumber() {
        return dynamicTranmitNumber;
    }

    public void setDynamicTranmitNumber(Integer dynamicTranmitNumber) {
        this.dynamicTranmitNumber = dynamicTranmitNumber;
    }

    public String getDynamicmentContent() {
        return dynamicmentContent;
    }

    public void setDynamicmentContent(String dynamicmentContent) {
        this.dynamicmentContent = dynamicmentContent == null ? null : dynamicmentContent.trim();
    }
}