package com.huirong.model;

import com.huirong.utils.NullObjectUtils;

import java.io.Serializable;


/**
 * Created by sjy on 2016/12/5.
 */

public class MyApprovalModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String YesOrNo;//审批人是否同意
    private String EmployeeID;
    private String EmployeeName;
    private String DepartmentID;
    private String DepartmentName;//
    private String Detail;//

    private String ApprovalDepartmentName;
    private String ApprovalDepartmentID;//审批部门（编号）
    private String ApprovalEmployeeID;//审批人
    private String ApprovalEmployeeName;
    private String ApprovalDate;//审批时间
    private String ApprovalStatus;
    private String Comment;

    private String CreateTimeForApp;//申请时间
    private String CreateTime;//申请时间
    private String StoreID;
    private String ApprovalID;
    private String ApplicationID;
    private String ApplicationTitle;
    private String ApplicationType;
    private String Remark;

    public String getYesOrNo() {
        return YesOrNo;
    }

    public void setYesOrNo(String yesOrNo) {
        YesOrNo = yesOrNo;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getApprovalDepartmentID() {
        return ApprovalDepartmentID;
    }

    public void setApprovalDepartmentID(String approvalDepartmentID) {
        ApprovalDepartmentID = approvalDepartmentID;
    }

    public String getApprovalDepartmentName() {
        return ApprovalDepartmentName;
    }

    public void setApprovalDepartmentName(String approvalDepartmentName) {
        ApprovalDepartmentName = approvalDepartmentName;
    }

    public String getApprovalEmployeeID() {
        return ApprovalEmployeeID;
    }

    public void setApprovalEmployeeID(String approvalEmployeeID) {
        ApprovalEmployeeID = approvalEmployeeID;
    }

    public String getApprovalEmployeeName() {
        return ApprovalEmployeeName;
    }

    public void setApprovalEmployeeName(String approvalEmployeeName) {
        ApprovalEmployeeName = approvalEmployeeName;
    }

    public String getApprovalDate() {
        return ApprovalDate;
    }

    public void setApprovalDate(String approvalDate) {
        ApprovalDate = approvalDate;
    }

    public String getApprovalStatus() {
        return ApprovalStatus == null? NullObjectUtils.getInstance().NullMessage():ApprovalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        ApprovalStatus = approvalStatus;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }



    public String getCreateTimeForApp() {
        return CreateTimeForApp;
    }

    public void setCreateTimeForApp(String createTimeForApp) {
        CreateTimeForApp = createTimeForApp;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public String getApprovalID() {
        return ApprovalID;
    }

    public void setApprovalID(String approvalID) {
        ApprovalID = approvalID;
    }

    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String applicationID) {
        ApplicationID = applicationID;
    }

    public String getApplicationTitle() {
        return ApplicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        ApplicationTitle = applicationTitle;
    }

    public String getApplicationType() {
        return ApplicationType;
    }

    public void setApplicationType(String applicationType) {
        ApplicationType = applicationType;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @Override
    public String toString() {
        return "MyApprovalModel{" +
                "YesOrNo='" + YesOrNo + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", DepartmentID='" + DepartmentID + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", Detail='" + Detail + '\'' +
                ", ApprovalDepartmentName='" + ApprovalDepartmentName + '\'' +
                ", ApprovalDepartmentID='" + ApprovalDepartmentID + '\'' +
                ", ApprovalEmployeeID='" + ApprovalEmployeeID + '\'' +
                ", ApprovalEmployeeName='" + ApprovalEmployeeName + '\'' +
                ", ApprovalDate='" + ApprovalDate + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", Comment='" + Comment + '\'' +
                ", CreateTimeForApp='" + CreateTimeForApp + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", ApprovalID='" + ApprovalID + '\'' +
                ", ApplicationID='" + ApplicationID + '\'' +
                ", ApplicationTitle='" + ApplicationTitle + '\'' +
                ", ApplicationType='" + ApplicationType + '\'' +
                ", Remark='" + Remark + '\'' +
                '}';
    }
}
