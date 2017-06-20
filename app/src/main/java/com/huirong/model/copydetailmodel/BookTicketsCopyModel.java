package com.huirong.model.copydetailmodel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by sjy on 2016/12/26.
 */

public class BookTicketsCopyModel implements Serializable {
    private static final long serialVersionUID = 1L;


    public String ApplicationID;//
    public String ApplicationTitle;//
    public String Traffic;//
    public String EmployeeID;//
    public String EmployeeName;//
    public String StartAddress;//


    public String EndAddress;
    public String StartTime;
    public String EndTime;
    public String Reason;
    public String Remark;
    public String ActiveFlg;
    public String CreateTime;
    public String ApplicationCreateTime;
    public String StoreID;
    public String Temp;
    public String DepartmentID;
    public String DepartmentName;
    public String ApprovalStatus;
    public String StoreName;

    public List<BookTicketsCopyModel.ApprovalInfoLists> ApprovalInfoLists ;



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

    public List<BookTicketsCopyModel.ApprovalInfoLists> getApprovalInfoLists() {
        return ApprovalInfoLists;
    }

    public void setApprovalInfoLists(List<BookTicketsCopyModel.ApprovalInfoLists> approvalInfoLists) {
        this.ApprovalInfoLists = approvalInfoLists;
    }


    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getTraffic() {
        return Traffic;
    }

    public void setTraffic(String traffic) {
        Traffic = traffic;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getStartAddress() {
        return StartAddress;
    }

    public void setStartAddress(String startAddress) {
        StartAddress = startAddress;
    }

    public String getEndAddress() {
        return EndAddress;
    }

    public void setEndAddress(String endAddress) {
        EndAddress = endAddress;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getActiveFlg() {
        return ActiveFlg;
    }

    public void setActiveFlg(String activeFlg) {
        ActiveFlg = activeFlg;
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

    public String getTemp() {
        return Temp;
    }

    public void setTemp(String temp) {
        Temp = temp;
    }

    public String getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(String departmentID) {
        DepartmentID = departmentID;
    }

    @Override
    public String toString() {
        return "BookTicketsModel{" +
                "ApplicationID='" + ApplicationID + '\'' +
                ", ApplicationTitle='" + ApplicationTitle + '\'' +
                ", Traffic='" + Traffic + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", StartAddress='" + StartAddress + '\'' +
                ", EndAddress='" + EndAddress + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                ", Reason='" + Reason + '\'' +
                ", Remark='" + Remark + '\'' +
                ", ActiveFlg='" + ActiveFlg + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", ApplicationCreateTime='" + ApplicationCreateTime + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", Temp='" + Temp + '\'' +
                ", DepartmentID='" + DepartmentID + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", StoreName='" + StoreName + '\'' +
                ", ApprovalInfoLists=" + ApprovalInfoLists +
                '}';
    }
}
