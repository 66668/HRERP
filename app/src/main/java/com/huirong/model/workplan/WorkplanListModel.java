package com.huirong.model.workplan;

import java.io.Serializable;


/**
 * 工作计划model
 */

public class WorkplanListModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Title;
    private String UploaderDepartmentID;//接收部门

    private String UploaderEmployeeID;//发送人id
    private String ReceiveerEmployeeID;//接收人id

    private String Plancontent;//计划内容
    private String Schedules;//计划进度
    private String Completiontime;//完成时间

    private String Remark;
    private String StoreID;
    private String CreateTime;
    private String SeeType;

    public String getSeeType() {
        return SeeType;
    }

    public void setSeeType(String seeType) {
        SeeType = seeType;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUploaderEmployeeID() {
        return UploaderEmployeeID;
    }

    public void setUploaderEmployeeID(String uploaderEmployeeID) {
        UploaderEmployeeID = uploaderEmployeeID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUploaderDepartmentID() {
        return UploaderDepartmentID;
    }

    public void setUploaderDepartmentID(String uploaderDepartmentID) {
        UploaderDepartmentID = uploaderDepartmentID;
    }

    public String getReceiveerEmployeeID() {
        return ReceiveerEmployeeID;
    }

    public void setReceiveerEmployeeID(String receiveerEmployeeID) {
        ReceiveerEmployeeID = receiveerEmployeeID;
    }

    public String getPlancontent() {
        return Plancontent;
    }

    public void setPlancontent(String plancontent) {
        Plancontent = plancontent;
    }

    public String getSchedules() {
        return Schedules;
    }

    public void setSchedules(String schedules) {
        Schedules = schedules;
    }

    public String getCompletiontime() {
        return Completiontime;
    }

    public void setCompletiontime(String completiontime) {
        Completiontime = completiontime;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    @Override
    public String toString() {
        return "WorkplanListModel{" +
                "UploaderEmployeeID='" + UploaderEmployeeID + '\'' +
                ", Title='" + Title + '\'' +
                ", UploaderDepartmentID='" + UploaderDepartmentID + '\'' +
                ", ReceiveerEmployeeID='" + ReceiveerEmployeeID + '\'' +
                ", Plancontent='" + Plancontent + '\'' +
                ", Schedules='" + Schedules + '\'' +
                ", Completiontime='" + Completiontime + '\'' +
                ", Remark='" + Remark + '\'' +
                ", StoreID='" + StoreID + '\'' +
                '}';
    }
}
