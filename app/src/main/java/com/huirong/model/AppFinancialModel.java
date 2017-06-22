package com.huirong.model;

import java.io.Serializable;

/**
 * 应用-费用listmodel
 *
 * 没见过这么low的后台，拼音撒
 * Created by sjy on 2016/12/26.
 */

public class AppFinancialModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //公用参数
    public String ID;
    public String Detail;
    public String StoreID;
    public String CreateTime;
    public String CreateTimeForApp;
    public String ActiveFlg;
    public String Comment;
    public String ApprovalStatus;
    public String ApprovalDate;
    public String ApprovalEmployeeName;
    public String ApprovalEmployeeID;
    public String ApprovalDepartmentName;
    public String ApprovalDepartmentID;
    public String DepartmentName;
    public String DepartmentID;
    public String EmployeeName;
    public String EmployeeID;
    public String YesOrNo;
    public String ApplicationType;
    public String ApplicationTitle;
    public String ApplicationID;
    public String ApprovalID;
    public String ApprovalInfomodel;
    public String PublishDeptName;
    public String IsRead;
    public String Abstract;
    public String PublishTime;
    public String Temp;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getCreateTimeForApp() {
        return CreateTimeForApp;
    }

    public void setCreateTimeForApp(String createTimeForApp) {
        CreateTimeForApp = createTimeForApp;
    }

    public String getActiveFlg() {
        return ActiveFlg;
    }

    public void setActiveFlg(String activeFlg) {
        ActiveFlg = activeFlg;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        ApprovalStatus = approvalStatus;
    }

    public String getApprovalDate() {
        return ApprovalDate;
    }

    public void setApprovalDate(String approvalDate) {
        ApprovalDate = approvalDate;
    }

    public String getApprovalEmployeeName() {
        return ApprovalEmployeeName;
    }

    public void setApprovalEmployeeName(String approvalEmployeeName) {
        ApprovalEmployeeName = approvalEmployeeName;
    }

    public String getApprovalEmployeeID() {
        return ApprovalEmployeeID;
    }

    public void setApprovalEmployeeID(String approvalEmployeeID) {
        ApprovalEmployeeID = approvalEmployeeID;
    }

    public String getApprovalDepartmentName() {
        return ApprovalDepartmentName;
    }

    public void setApprovalDepartmentName(String approvalDepartmentName) {
        ApprovalDepartmentName = approvalDepartmentName;
    }

    public String getApprovalDepartmentID() {
        return ApprovalDepartmentID;
    }

    public void setApprovalDepartmentID(String approvalDepartmentID) {
        ApprovalDepartmentID = approvalDepartmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getYesOrNo() {
        return YesOrNo;
    }

    public void setYesOrNo(String yesOrNo) {
        YesOrNo = yesOrNo;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public void setApplicationType(String applicationType) {
        ApplicationType = applicationType;
    }

    public String getApplicationTitle() {
        return ApplicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        ApplicationTitle = applicationTitle;
    }

    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String applicationID) {
        ApplicationID = applicationID;
    }

    public String getApprovalID() {
        return ApprovalID;
    }

    public void setApprovalID(String approvalID) {
        ApprovalID = approvalID;
    }

    public String getApprovalInfomodel() {
        return ApprovalInfomodel;
    }

    public void setApprovalInfomodel(String approvalInfomodel) {
        ApprovalInfomodel = approvalInfomodel;
    }

    public String getPublishDeptName() {
        return PublishDeptName;
    }

    public void setPublishDeptName(String publishDeptName) {
        PublishDeptName = publishDeptName;
    }

    public String getIsRead() {
        return IsRead;
    }

    public void setIsRead(String isRead) {
        IsRead = isRead;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String publishTime) {
        PublishTime = publishTime;
    }

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String temp) {
        Temp = temp;
    }

    @Override
    public String toString() {
        return "AppFinancialModel{" +
                "ID='" + ID + '\'' +
                ", Detail='" + Detail + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", CreateTimeForApp='" + CreateTimeForApp + '\'' +
                ", ActiveFlg='" + ActiveFlg + '\'' +
                ", Comment='" + Comment + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", ApprovalDate='" + ApprovalDate + '\'' +
                ", ApprovalEmployeeName='" + ApprovalEmployeeName + '\'' +
                ", ApprovalEmployeeID='" + ApprovalEmployeeID + '\'' +
                ", ApprovalDepartmentName='" + ApprovalDepartmentName + '\'' +
                ", ApprovalDepartmentID='" + ApprovalDepartmentID + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", DepartmentID='" + DepartmentID + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", YesOrNo='" + YesOrNo + '\'' +
                ", ApplicationType='" + ApplicationType + '\'' +
                ", ApplicationTitle='" + ApplicationTitle + '\'' +
                ", ApplicationID='" + ApplicationID + '\'' +
                ", ApprovalID='" + ApprovalID + '\'' +
                ", ApprovalInfomodel='" + ApprovalInfomodel + '\'' +
                ", PublishDeptName='" + PublishDeptName + '\'' +
                ", IsRead='" + IsRead + '\'' +
                ", Abstract='" + Abstract + '\'' +
                ", PublishTime='" + PublishTime + '\'' +
                ", Temp='" + Temp + '\'' +
                '}';
    }
}
