package com.huirong.model.mission;

import java.io.Serializable;


/**
 * 任务 model
 */

public class MissionListModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String maintainID;//编号
    private String misssiontheme;//

    private String misssionContent;//
    private String misssionType;//

    private String misssionSite;//
    private String maintainMan;//维修维护人
    private String repairsMan;//报修人

    private String ContactWay;//联系方式
    private String finishtime;//完成时间
    private String payoutman;//派发人
    private String IsYesNo;//是否完成
    private String IsRead;//是否阅读
    private String UpdetTime;//完成时间
    private String ISremark;//完成说明
    private String remark;//备注
    private String StoreID;//公司编号

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getMaintainID() {
        return maintainID;
    }

    public void setMaintainID(String maintainID) {
        this.maintainID = maintainID;
    }

    public String getMisssiontheme() {
        return misssiontheme;
    }

    public void setMisssiontheme(String misssiontheme) {
        this.misssiontheme = misssiontheme;
    }

    public String getMisssionContent() {
        return misssionContent;
    }

    public void setMisssionContent(String misssionContent) {
        this.misssionContent = misssionContent;
    }

    public String getMisssionType() {
        return misssionType;
    }

    public void setMisssionType(String misssionType) {
        this.misssionType = misssionType;
    }

    public String getMisssionSite() {
        return misssionSite;
    }

    public void setMisssionSite(String misssionSite) {
        this.misssionSite = misssionSite;
    }

    public String getMaintainMan() {
        return maintainMan;
    }

    public void setMaintainMan(String maintainMan) {
        this.maintainMan = maintainMan;
    }

    public String getRepairsMan() {
        return repairsMan;
    }

    public void setRepairsMan(String repairsMan) {
        this.repairsMan = repairsMan;
    }

    public String getContactWay() {
        return ContactWay;
    }

    public void setContactWay(String contactWay) {
        ContactWay = contactWay;
    }

    public String getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(String finishtime) {
        this.finishtime = finishtime;
    }

    public String getPayoutman() {
        return payoutman;
    }

    public void setPayoutman(String payoutman) {
        this.payoutman = payoutman;
    }

    public String getIsYesNo() {
        return IsYesNo;
    }

    public void setIsYesNo(String isYesNo) {
        IsYesNo = isYesNo;
    }

    public String getIsRead() {
        return IsRead;
    }

    public void setIsRead(String isRead) {
        IsRead = isRead;
    }

    public String getUpdetTime() {
        return UpdetTime;
    }

    public void setUpdetTime(String updetTime) {
        UpdetTime = updetTime;
    }

    public String getISremark() {
        return ISremark;
    }

    public void setISremark(String ISremark) {
        this.ISremark = ISremark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    @Override
    public String toString() {
        return "MissionListModel{" +
                "maintainID='" + maintainID + '\'' +
                ", misssiontheme='" + misssiontheme + '\'' +
                ", misssionContent='" + misssionContent + '\'' +
                ", misssionType='" + misssionType + '\'' +
                ", misssionSite='" + misssionSite + '\'' +
                ", maintainMan='" + maintainMan + '\'' +
                ", repairsMan='" + repairsMan + '\'' +
                ", ContactWay='" + ContactWay + '\'' +
                ", finishtime='" + finishtime + '\'' +
                ", payoutman='" + payoutman + '\'' +
                ", IsYesNo='" + IsYesNo + '\'' +
                ", IsRead='" + IsRead + '\'' +
                ", UpdetTime='" + UpdetTime + '\'' +
                ", ISremark='" + ISremark + '\'' +
                ", remark='" + remark + '\'' +
                ", StoreID='" + StoreID + '\'' +
                '}';
    }
}
