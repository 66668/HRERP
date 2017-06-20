package com.huirong.model.applicationdetailmodel;

import java.io.Serializable;
import java.util.List;

/**
 * 应用-审批 我的申请 财务详情model
 * 没见过这么low的后台，拼音撒
 * Created by sjy on 2016/12/26.
 */

public class FinancialAllModel implements Serializable {
    private static final long serialVersionUID = 1L;

    //公用参数
    public String Fee;
    public String Remark;
    public List<String> ImageLists;//图片路径集合;
    public String ApprovalStatus;
    public String StoreName;
    public String DepartmentName;
    public String EmployeeName;
    public String ApplicationCreateTime;
    public String EmployeeID;
    public String ApplicationID;
    public String ApplicationTitle;

    //报销
    public String Types;
    public String Way;
    public String Useage;
    public String zhaiyao1;
    public String jine1;
    public String zhaiyao2;
    public String jine2;
    public String zhaiyao3;
    public String jine3;
    public String heji;

    // 借款
    public String Reason;//借款事由
    public String LastComment;//LastComment
    public String ActiveFlg;//ActiveFlg
    public String LastUpdateTime;//LastUpdateTime
    public String OperatorName;//OperatorName
    public String CreateTime;//CreateTime
    public String StoreID;//StoreID


    //付款参数
    public String Paymentmethod;
    public String Bankaccount;//开户行
    public String Accountnumber;//账号
    public String Collectionunit;//收款单位


    public List<FinancialAllModel.ApprovalInfoLists> ApprovalInfoLists;

    public List<String> getImageLists() {
        return ImageLists;
    }

    public void setImageLists(List<String> imageLists) {
        ImageLists = imageLists;
    }

    public String getApplicationTitle() {
        return ApplicationTitle;
    }

    public void setApplicationTitle(String applicationTitle) {
        ApplicationTitle = applicationTitle;
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

    public static class ApprovalInfoLists implements Serializable {
        public String Comment;
        public String ApprovalDate;
        public String YesOrNo;
        public String ApprovalEmployeeName;

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

    public List<FinancialAllModel.ApprovalInfoLists> getApprovalInfoLists() {
        return ApprovalInfoLists;
    }

    public void setApprovalInfoLists(List<FinancialAllModel.ApprovalInfoLists> ApprovalInfoLists) {
        this.ApprovalInfoLists = ApprovalInfoLists;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getApplicationID() {
        return ApplicationID;
    }

    public void setApplicationID(String applicationID) {
        ApplicationID = applicationID;
    }

    public String getTypes() {
        return Types;
    }

    public void setTypes(String Types) {
        Types = Types;
    }

    public String getWay() {
        return Way;
    }

    public void setWay(String way) {
        Way = way;
    }

    public String getFee() {
        return Fee;
    }

    public void setFee(String fee) {
        Fee = fee;
    }


    public String getUseage() {
        return Useage;
    }

    public void setUseage(String useage) {
        Useage = useage;
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




    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getPaymentmethod() {
        return Paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        Paymentmethod = paymentmethod;
    }

    public String getBankaccount() {
        return Bankaccount;
    }

    public void setBankaccount(String bankaccount) {
        Bankaccount = bankaccount;
    }

    public String getAccountnumber() {
        return Accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        Accountnumber = accountnumber;
    }

    public String getCollectionunit() {
        return Collectionunit;
    }

    public void setCollectionunit(String collectionunit) {
        Collectionunit = collectionunit;
    }

    public String getZhaiyao1() {
        return zhaiyao1;
    }

    public void setZhaiyao1(String zhaiyao1) {
        this.zhaiyao1 = zhaiyao1;
    }

    public String getJine1() {
        return jine1;
    }

    public void setJine1(String jine1) {
        this.jine1 = jine1;
    }

    public String getZhaiyao2() {
        return zhaiyao2;
    }

    public void setZhaiyao2(String zhaiyao2) {
        this.zhaiyao2 = zhaiyao2;
    }

    public String getJine2() {
        return jine2;
    }

    public void setJine2(String jine2) {
        this.jine2 = jine2;
    }

    public String getZhaiyao3() {
        return zhaiyao3;
    }

    public void setZhaiyao3(String zhaiyao3) {
        this.zhaiyao3 = zhaiyao3;
    }

    public String getJine3() {
        return jine3;
    }

    public void setJine3(String jine3) {
        this.jine3 = jine3;
    }

    public String getHeji() {
        return heji;
    }

    public void setHeji(String heji) {
        this.heji = heji;
    }

    @Override
    public String toString() {
        return "FinancialAllModel{" +
                "Fee='" + Fee + '\'' +
                ", Remark='" + Remark + '\'' +
                ", ImageLists=" + ImageLists +
                ", ApprovalStatus='" + ApprovalStatus + '\'' +
                ", StoreName='" + StoreName + '\'' +
                ", DepartmentName='" + DepartmentName + '\'' +
                ", EmployeeName='" + EmployeeName + '\'' +
                ", ApplicationCreateTime='" + ApplicationCreateTime + '\'' +
                ", EmployeeID='" + EmployeeID + '\'' +
                ", ApplicationID='" + ApplicationID + '\'' +
                ", ApplicationTitle='" + ApplicationTitle + '\'' +
                ", Types='" + Types + '\'' +
                ", Way='" + Way + '\'' +
                ", Useage='" + Useage + '\'' +
                ", zhaiyao1='" + zhaiyao1 + '\'' +
                ", jine1='" + jine1 + '\'' +
                ", zhaiyao2='" + zhaiyao2 + '\'' +
                ", jine2='" + jine2 + '\'' +
                ", zhaiyao3='" + zhaiyao3 + '\'' +
                ", jine3='" + jine3 + '\'' +
                ", heji='" + heji + '\'' +
                ", Reason='" + Reason + '\'' +
                ", LastComment='" + LastComment + '\'' +
                ", ActiveFlg='" + ActiveFlg + '\'' +
                ", LastUpdateTime='" + LastUpdateTime + '\'' +
                ", OperatorName='" + OperatorName + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", StoreID='" + StoreID + '\'' +
                ", Paymentmethod='" + Paymentmethod + '\'' +
                ", Bankaccount='" + Bankaccount + '\'' +
                ", Accountnumber='" + Accountnumber + '\'' +
                ", Collectionunit='" + Collectionunit + '\'' +
                ", ApprovalInfoLists=" + ApprovalInfoLists +
                '}';
    }
}
