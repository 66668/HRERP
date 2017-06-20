package com.huirong.model.approvaldetailmodel;

import java.io.Serializable;
import java.util.List;

/**
 * 培训
 * Created by sjy on 2016/12/26.
 */

public class TrainingApvlModel implements Serializable {
    private static final long serialVersionUID = 1L;


    public String ApplicationID;//
    public String TrainingMode;//
    public String EmployeeID;//
    public String EmployeeName;//
    public String TrainingForm;//
    public String BeginTime;//


    public String FinishTime;
    public String TrainingSite;
    public String Cost;
    public String Person;
    public String Remark;
    public String ActiveFlg;
    public String CreateTime;
    public String DepartmentName;
    public String StoreID;
    public String StoreName;
    public String Content;
    public String ApprovalStatus;
    public String ApplicationCreateTime;
    public String ApprovalIDList;

    public List<TrainingApvlModel.ApprovalInfoLists> ApprovalInfoLists ;



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

    public List<TrainingApvlModel.ApprovalInfoLists> getApprovalInfoLists() {
        return ApprovalInfoLists;
    }

    public void setApprovalInfoLists(List<TrainingApvlModel.ApprovalInfoLists> approvalInfoLists) {
        this.ApprovalInfoLists = approvalInfoLists;
    }


    public String getFinishTime() {
        return FinishTime;
    }

    public void setFinishTime(String finishTime) {
        FinishTime = finishTime;
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

    public String getTrainingMode() {
        return TrainingMode;
    }

    public void setTrainingMode(String trainingMode) {
        TrainingMode = trainingMode;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getTrainingForm() {
        return TrainingForm;
    }

    public void setTrainingForm(String trainingForm) {
        TrainingForm = trainingForm;
    }

    public String getBeginTime() {
        return BeginTime;
    }

    public void setBeginTime(String beginTime) {
        BeginTime = beginTime;
    }

    public String getTrainingSite() {
        return TrainingSite;
    }

    public void setTrainingSite(String trainingSite) {
        TrainingSite = trainingSite;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getPerson() {
        return Person;
    }

    public void setPerson(String person) {
        Person = person;
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

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }


    public String getApprovalIDList() {
        return ApprovalIDList;
    }

    public void setApprovalIDList(String approvalIDList) {
        ApprovalIDList = approvalIDList;
    }

    public String getStoreName() {
        return StoreName;
    }

    public void setStoreName(String storeName) {
        StoreName = storeName;
    }

    @Override
    public String toString() {
        return "TrainingModel{" +
                "ApplicationID='" + ApplicationID + '\'' +
                ", TrainingMode='" + TrainingMode + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", TrainingForm='" + TrainingForm + '\'' +
                ", BeginTime='" + BeginTime + '\'' +
                ", FinishTime='" + FinishTime + '\'' +
                ", TrainingSite='" + TrainingSite + '\'' +
                ", Cost='" + Cost + '\'' +
                ", Person='" + Person + '\'' +
                ", Remark='" + Remark + '\'' +
                ", ActiveFlg='" + ActiveFlg + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", Content='" + Content + '\'' +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", ApplicationCreateTime='" + ApplicationCreateTime + '\'' +
                ", ApprovalIDList='" + ApprovalIDList + '\'' +
                ", ApprovalInfoLists=" + ApprovalInfoLists +
                '}';
    }
}
