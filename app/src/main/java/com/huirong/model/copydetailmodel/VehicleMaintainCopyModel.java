package com.huirong.model.copydetailmodel;

import java.io.Serializable;
import java.util.List;

/**
 * 车辆维保
 * Created by sjy on 2016/12/26.
 */

public class VehicleMaintainCopyModel implements Serializable {
    private static final long serialVersionUID = 1L;
    public String EstimateFee;//
    public String TravelKilmetre;//
    public String MaintenanceTime;//
    public String MaintenanceEndTime;//
    public String Remark;
    public String MaintenanceNumber;
    public String StoreName;
    public String ApprovalStatus;
    public String DepartmentName;
    public String EmployeeName;
    public String ApplicationCreateTime;


    public String MaintenanceType;//状态
    public String MaintenanceProject;
    public String VehicleState;
    public String MaintenancePlace;
    public String CopyTime;
    public String ActualBorrowTime;
    public String ActualReturnTime;
    public String Passenger;
    public String BackRemark;
    public String Purpose;
    public String StoreID;

    public List<VehicleMaintainCopyModel.ApprovalInfoLists> ApprovalInfoLists ;


    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public String getBackRemark() {
        return BackRemark;
    }

    public void setBackRemark(String backRemark) {
        BackRemark = backRemark;
    }

    public static class ApprovalInfoLists{
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

    public List<VehicleMaintainCopyModel.ApprovalInfoLists> getApprovalInfoLists() {
        return ApprovalInfoLists;
    }

    public void setApprovalInfoLists(List<VehicleMaintainCopyModel.ApprovalInfoLists> approvalInfoLists) {
        this.ApprovalInfoLists = approvalInfoLists;
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

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
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

    public String getApplicationCreateTime() {
        return ApplicationCreateTime;
    }

    public void setApplicationCreateTime(String applicationCreateTime) {
        ApplicationCreateTime = applicationCreateTime;
    }

    public String getPurpose() {
        return Purpose;
    }

    public void setPurpose(String purpose) {
        Purpose = purpose;
    }



    public String getMaintenanceType() {
        return MaintenanceType;
    }

    public void setMaintenanceType(String maintenanceType) {
        MaintenanceType = maintenanceType;
    }

    public String getMaintenanceProject() {
        return MaintenanceProject;
    }

    public void setMaintenanceProject(String maintenanceProject) {
        MaintenanceProject = maintenanceProject;
    }

    public String getVehicleState() {
        return VehicleState;
    }

    public void setVehicleState(String vehicleState) {
        VehicleState = vehicleState;
    }



    public String getEstimateFee() {
        return EstimateFee;
    }

    public void setEstimateFee(String estimateFee) {
        EstimateFee = estimateFee;
    }

    public String getActualBorrowTime() {
        return ActualBorrowTime;
    }

    public void setActualBorrowTime(String actualBorrowTime) {
        ActualBorrowTime = actualBorrowTime;
    }

    public String getActualReturnTime() {
        return ActualReturnTime;
    }

    public void setActualReturnTime(String actualReturnTime) {
        ActualReturnTime = actualReturnTime;
    }

    public String getPassenger() {
        return Passenger;
    }

    public void setPassenger(String passenger) {
        Passenger = passenger;
    }


    public String getCopyTime() {
        return CopyTime;
    }

    public void setCopyTime(String copyTime) {
        CopyTime = copyTime;
    }

    public String getTravelKilmetre() {
        return TravelKilmetre;
    }

    public void setTravelKilmetre(String travelKilmetre) {
        TravelKilmetre = travelKilmetre;
    }

    public String getMaintenanceTime() {
        return MaintenanceTime;
    }

    public void setMaintenanceTime(String maintenanceTime) {
        MaintenanceTime = maintenanceTime;
    }

    public String getMaintenanceEndTime() {
        return MaintenanceEndTime;
    }

    public void setMaintenanceEndTime(String maintenanceEndTime) {
        MaintenanceEndTime = maintenanceEndTime;
    }

    public String getMaintenanceNumber() {
        return MaintenanceNumber;
    }

    public void setMaintenanceNumber(String maintenanceNumber) {
        MaintenanceNumber = maintenanceNumber;
    }

    public String getMaintenancePlace() {
        return MaintenancePlace;
    }

    public void setMaintenancePlace(String maintenancePlace) {
        MaintenancePlace = maintenancePlace;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }
}
