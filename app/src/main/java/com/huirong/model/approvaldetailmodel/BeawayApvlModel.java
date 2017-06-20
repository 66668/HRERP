package com.huirong.model.approvaldetailmodel;

import java.io.Serializable;
import java.util.List;

/**
 * 我的申请/我的审批
 * 出差详情
 * Created by sjy on 2016/12/26.
 */

public class BeawayApvlModel implements Serializable {
    private static final long serialVersionUID = 1L;


    public String ApplicationID;//
    public String ApplicationTitle;//
    public String EmployeeID;//
    public String EmployeeName;//
    public String Reason;//
    public String StartTripDate;//


    public String EndTripDate;
    public String TripDays;
    public String TripAddress;
    public String Traffic;//交通工具
    public String Attendance;
    public String Remark;
    public String ActiveFlg;
    public String CreateTime;
    public String ApplicationCreateTime;
    public String StoreID;
    public String Temp;
    public String AppDepartmentID;
    public String DepartmentName;
    public String StoreName;
    public String ApprovalStatus;

    public List<ApprovalInfoLists> ApprovalInfoLists ;



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

    public List<BeawayApvlModel.ApprovalInfoLists> getApprovalInfoLists() {
        return ApprovalInfoLists;
    }

    public void setApprovalInfoLists(List<BeawayApvlModel.ApprovalInfoLists> approvalInfoLists) {
        this.ApprovalInfoLists = approvalInfoLists;
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

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getStartTripDate() {
        return StartTripDate;
    }

    public void setStartTripDate(String startTripDate) {
        StartTripDate = startTripDate;
    }

    public String getEndTripDate() {
        return EndTripDate;
    }

    public void setEndTripDate(String endTripDate) {
        EndTripDate = endTripDate;
    }

    public String getTripDays() {
        return TripDays;
    }

    public void setTripDays(String tripDays) {
        TripDays = tripDays;
    }

    public String getTripAddress() {
        return TripAddress;
    }

    public void setTripAddress(String tripAddress) {
        TripAddress = tripAddress;
    }

    public String getTraffic() {
        return Traffic;
    }

    public void setTraffic(String traffic) {
        Traffic = traffic;
    }

    public String getAttendance() {
        return Attendance;
    }

    public void setAttendance(String attendance) {
        Attendance = attendance;
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

    public String getAppDepartmentID() {
        return AppDepartmentID;
    }

    public void setAppDepartmentID(String appDepartmentID) {
        AppDepartmentID = appDepartmentID;
    }

    @Override
    public String toString() {
        return "BeawayModel{" +
                "ApplicationID='" + ApplicationID + '\'' +
                ", ApplicationTitle='" + ApplicationTitle + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", Reason='" + Reason + '\'' +
                ", StartTripDate='" + StartTripDate + '\'' +
                ", EndTripDate='" + EndTripDate + '\'' +
                ", TripDays='" + TripDays + '\'' +
                ", TripAddress='" + TripAddress + '\'' +
                ", Traffic='" + Traffic + '\'' +
                ", Attendance='" + Attendance + '\'' +
                ", Remark='" + Remark + '\'' +
                ", ActiveFlg='" + ActiveFlg + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", ApplicationCreateTime='" + ApplicationCreateTime + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", Temp='" + Temp + '\'' +
                ", AppDepartmentID='" + AppDepartmentID + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", StoreName='" + StoreName + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", ApprovalInfoLists=" + ApprovalInfoLists +
                '}';
    }
}
