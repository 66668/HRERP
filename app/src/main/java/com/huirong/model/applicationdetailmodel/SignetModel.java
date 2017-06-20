package com.huirong.model.applicationdetailmodel;

import java.io.Serializable;
import java.util.List;

/**
 * 印章
 * Created by sjy on 2016/12/26.
 */

public class SignetModel implements Serializable {
    private static final long serialVersionUID = 1L;


    public String ApplicationID;//
    public String EmployeeID;//
    public String EmployeeName;//
    public String StartTime;//
    public String EndTime;//
    public String SignatureName;//


    public String Purpose;
    public String Copies;
    public String AppDepartmentID;
    public String ApprovalID;
    public String CreateTime;
    public String LastApprovalStatusID;
    public String LastComment;
    public String Remark;
    public String ActiveFlg;
    public String LastUpdateTime;
    public String OperatorName;
    public String StoreName;
    public String StoreID;
    public String ApprovalStatus;
    public String ApplicationCreateTime;
    public String ApprovalIDList;
    public String DepartmentName;

    public List<SignetModel.ApprovalInfoLists> ApprovalInfoLists ;



    public static class ApprovalInfoLists implements Serializable {
        public String Comment = "";
        public String ApprovalDate = "";
        public String YesOrNo= "";
        public String ApprovalEmployeeName= "";

        public String getComment() {
            return Comment;
        }

        public void setComment(String comment) {
            Comment = comment;
        }

        public String getApprovalDate() {
            return ApprovalDate;
        }

        public void setApprovalDate(String approvalDate) {
            ApprovalDate = approvalDate;
        }

        public String getYesOrNo() {
            return YesOrNo;
        }

        public void setYesOrNo(String yesOrNo) {
            YesOrNo = yesOrNo;
        }

        public String getApprovalEmployeeName() {
            return ApprovalEmployeeName;
        }

        public void setApprovalEmployeeName(String approvalEmployeeName) {
            ApprovalEmployeeName = approvalEmployeeName;
        }
    }

    public List<SignetModel.ApprovalInfoLists> getApprovalInfoLists() {
        return ApprovalInfoLists;
    }

    public void setApprovalInfoLists(List<SignetModel.ApprovalInfoLists> approvalInfoLists) {
        this.ApprovalInfoLists = approvalInfoLists;
    }



    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }


    public String getApprovalStatus() {
        return ApprovalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        ApprovalStatus = approvalStatus;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String departmentName) {
        DepartmentName = departmentName;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getApplicationCreateTime() {
        return ApplicationCreateTime;
    }

    public void setApplicationCreateTime(String applicationCreateTime) {
        ApplicationCreateTime = applicationCreateTime;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String applicationID) {
        ApplicationID = applicationID;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getSignatureName() {
        return SignatureName;
    }

    public void setSignatureName(String signatureName) {
        SignatureName = signatureName;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }

    public String getCopies() {
        return Copies;
    }

    public void setCopies(String copies) {
        Copies = copies;
    }

    public String getAppDepartmentID() {
        return AppDepartmentID;
    }

    public void setAppDepartmentID(String appDepartmentID) {
        AppDepartmentID = appDepartmentID;
    }

    public String getApprovalID() {
        return ApprovalID;
    }

    public void setApprovalID(String approvalID) {
        ApprovalID = approvalID;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getLastApprovalStatusID() {
        return LastApprovalStatusID;
    }

    public void setLastApprovalStatusID(String lastApprovalStatusID) {
        LastApprovalStatusID = lastApprovalStatusID;
    }

    public String getLastComment() {
        return LastComment;
    }

    public void setLastComment(String lastComment) {
        LastComment = lastComment;
    }

    public String getActiveFlg() {
        return ActiveFlg;
    }

    public void setActiveFlg(String activeFlg) {
        ActiveFlg = activeFlg;
    }

    public String getLastUpdateTime() {
        return LastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        LastUpdateTime = lastUpdateTime;
    }

    public String getOperatorName() {
        return OperatorName;
    }

    public void setOperatorName(String operatorName) {
        OperatorName = operatorName;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public String getApprovalIDList() {
        return ApprovalIDList;
    }

    public void setApprovalIDList(String approvalIDList) {
        ApprovalIDList = approvalIDList;
    }
}
