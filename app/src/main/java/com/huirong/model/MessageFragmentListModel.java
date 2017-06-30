package com.huirong.model;

import java.io.Serializable;

/**
 * 消息 统一listmodel
 * Created by sjy on 2016/11/29.
 */

public class MessageFragmentListModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ApprovalCreateTime;//审批
    private String ApprovalCreateTime1;//抄送
    private String maintainCreateTime;//任务
    private String TaskScheduleCreateTime;//计划
    private String NoticeTime;//通知
    private String AfficheTime;//公告

    private String ApprovalCount1;
    private String ApprovalCount;
    private String maintainCount;
    private String NoticeCount;
    private String AfficheCount;
    private String TaskScheduleCount;

    public String getNoticeTime() {
        return NoticeTime;
    }

    public void setNoticeTime(String noticeTime) {
        NoticeTime = noticeTime;
    }

    public String getAfficheTime() {
        return AfficheTime;
    }

    public void setAfficheTime(String afficheTime) {
        AfficheTime = afficheTime;
    }

    public String getNoticeCount() {
        return NoticeCount;
    }

    public void setNoticeCount(String noticeCount) {
        NoticeCount = noticeCount;
    }

    public String getAfficheCount() {
        return AfficheCount;
    }

    public void setAfficheCount(String afficheCount) {
        AfficheCount = afficheCount;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getApprovalCreateTime() {
        return ApprovalCreateTime;
    }

    public void setApprovalCreateTime(String approvalCreateTime) {
        ApprovalCreateTime = approvalCreateTime;
    }

    public String getApprovalCreateTime1() {
        return ApprovalCreateTime1;
    }

    public void setApprovalCreateTime1(String approvalCreateTime1) {
        ApprovalCreateTime1 = approvalCreateTime1;
    }

    public String getMaintainCreateTime() {
        return maintainCreateTime;
    }

    public void setMaintainCreateTime(String maintainCreateTime) {
        this.maintainCreateTime = maintainCreateTime;
    }

    public String getTaskScheduleCreateTime() {
        return TaskScheduleCreateTime;
    }

    public void setTaskScheduleCreateTime(String taskScheduleCreateTime) {
        TaskScheduleCreateTime = taskScheduleCreateTime;
    }

    public String getApprovalCount1() {
        return ApprovalCount1;
    }

    public void setApprovalCount1(String approvalCount1) {
        ApprovalCount1 = approvalCount1;
    }

    public String getApprovalCount() {
        return ApprovalCount;
    }

    public void setApprovalCount(String approvalCount) {
        ApprovalCount = approvalCount;
    }

    public String getMaintainCount() {
        return maintainCount;
    }

    public void setMaintainCount(String maintainCount) {
        this.maintainCount = maintainCount;
    }

    public String getTaskScheduleCount() {
        return TaskScheduleCount;
    }

    public void setTaskScheduleCount(String taskScheduleCount) {
        TaskScheduleCount = taskScheduleCount;
    }

    @Override
    public String toString() {
        return "MessageFragmentListModel{" +
                "ApprovalCreateTime='" + ApprovalCreateTime + '\'' +
                ", ApprovalCreateTime1='" + ApprovalCreateTime1 + '\'' +
                ", maintainCreateTime='" + maintainCreateTime + '\'' +
                ", TaskScheduleCreateTime='" + TaskScheduleCreateTime + '\'' +
                ", ApprovalCount1='" + ApprovalCount1 + '\'' +
                ", ApprovalCount='" + ApprovalCount + '\'' +
                ", maintainCount='" + maintainCount + '\'' +
                ", TaskScheduleCount='" + TaskScheduleCount + '\'' +
                '}';
    }
}
