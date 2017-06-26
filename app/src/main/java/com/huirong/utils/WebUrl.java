package com.huirong.utils;

public class WebUrl {
    /**
     * 根接口
     */

    // 云端
    private static final String LOGIN_URL = "http://59.110.26.83:8083/";//测试
    //    private static final String LOGIN_URL = "http://59.110.26.83:8087/";//正式


    /**
     * 管理根目录
     */
    public static final String LOGIN_FLODER_USER = "openapi/";

    /**
     * 使用者管理
     *
     * @author JackSong
     */
    public class UserManager {


        /**
         * 01 密码登录
         */
        public static final String LOGIN_POST = LOGIN_URL + LOGIN_FLODER_USER + "User/LoginByPassword";


        /**
         * 02 修改登录密码
         * http://192.168.1.127:9012/openapi/User/ChangePasswordN
         */
        public static final String CHANGE_PASSWORD = LOGIN_URL + LOGIN_FLODER_USER + "Password/UpdatePassword";

    }

    /**
     * 应用主接口
     */
    public class AppsManager {


        /**
         * 应用-工作计划 接口
         *
         * #############################################################################################
         */

        /**
         * 02-01 工作计划 记录
         */
        public static final String WORKPLANLIST = LOGIN_URL + LOGIN_FLODER_USER + "TaskSchedule/TaskScheduleList";

        /**
         * 02-02 工作计划 添加
         */
        public static final String ADDWORKPLAN = LOGIN_URL + LOGIN_FLODER_USER + "TaskSchedule/TaskScheduleAdd";

        /**
         * 应用-任务 接口
         *
         * #############################################################################################
         */
        /**
         * 03-01 任务 记录
         */
        public static final String MISSIONLIST = LOGIN_URL + LOGIN_FLODER_USER + "Maintain/MaintainList";

        /**
         * 03-02 任务 添加
         */
        public static final String ADDMISSION = LOGIN_URL + LOGIN_FLODER_USER + "Maintain/MaintainlAdd";

        /**
         * 03-03 任务详情，修改已读
         */
        public static final String MISSIONISREAD = LOGIN_URL + LOGIN_FLODER_USER + "Maintain/MaintainID";

        /**
         * 03-04 任务详情，修改完成
         */
        public static final String MISSIONISCOMPLETE = LOGIN_URL + LOGIN_FLODER_USER + "Maintain/MaintainEdit";
        /**
         * 03-04 任务 通讯录
         */
        public static final String MISSIONISCONTACTS = LOGIN_URL + LOGIN_FLODER_USER + "GetApplication/GetApplicationByEmployeeList";

        /**
         * 应用-地图签到 接口
         * #############################################################################################
         */

        /**
         * 03地图签到
         */
        public static final String ATTENDRECORD = LOGIN_URL + LOGIN_FLODER_USER + "Attence/AttenceRecord";

        /**
         * 03-02获取地图考勤记录
         */
        public static final String GETATTENDRECORD = LOGIN_URL + LOGIN_FLODER_USER + "AttenceRecord/GetAttenceRecord";

        /**
         * 应用-公告 通知 接口
         * #############################################################################################
         */

        /**
         * 04 应用 公告 获取列表
         */
        public static final String GETNOTICELIST = LOGIN_URL + LOGIN_FLODER_USER + "AfficheList/MyAfficheList";

        /**
         * 04-02 应用 公告 获取列表
         */
        public static final String READTHISNOTICE = LOGIN_URL + LOGIN_FLODER_USER + "UpdateIsread/UpdateIsreads";

        /**
         * 05 应用 通知 列表
         */
        public static final String GETNOTIFICATIONLIST = LOGIN_URL + LOGIN_FLODER_USER + "NoticeList/MyNoticeList";
        /**
         * 应用-费用（财务） 接口
         * #############################################################################################
         */
        public static final String FINCANCIALLIST = LOGIN_URL + LOGIN_FLODER_USER + "LRApplicationInfo/LRApplicationInfoList";
        /**
         * 应用-审批 接口
         *  我的申请 我的审批 抄送 及详情 接口
         * #############################################################################################
         */

        /**
         * 01-01获取 我的申请 记录
         */
        public static final String GETMYAPPLICATIONRECORD = LOGIN_URL + LOGIN_FLODER_USER + "ApprovalInfo/GetMyApplicationSearchResults";
        /**
         * 01-01-获取 申请详情
         */
        public static final String APPLICATIONDETAIL = LOGIN_URL + LOGIN_FLODER_USER + "AllApplicationInfo/GetAllApplicationInfoByAppID";


        /**
         * 01-02获取 我的审批 记录
         */
        public static final String GETMYAPPROVALRECORD = LOGIN_URL + LOGIN_FLODER_USER + "Approval/GetApprovalSearchResults";

        /**
         * 01-02获取 审批详情 记录
         */
        public static final String GETMYAPPROVALDETAIL = LOGIN_URL + LOGIN_FLODER_USER + "AllApprovalInfo/GetAllApprovalInfoByAppID";

        /**
         * 01-02-01/02 审批 同意/驳回
         */
        public static final String APPROVALE_AGREE_DISAGREE = LOGIN_URL + LOGIN_FLODER_USER + "Approval/ApprovalMyAppRecord";

        /**
         * 01-02-03审批 转发
         */
        public static final String APPROVAL_TRANSFORTO = LOGIN_URL + LOGIN_FLODER_USER + "Approval/TurnMyApprovalRecord";

        /**
         * 01-02-04审批 抄送
         */
        public static final String APPROVAL_COPYTO = LOGIN_URL + LOGIN_FLODER_USER + "Approvals/CopyMyApprovalRecord";


        /**
         * 01-03获取 我的抄送 记录
         */
        public static final String GETCOPYLIST = LOGIN_URL + LOGIN_FLODER_USER + "Mycopy/MycopyList";
        /**
         * 01-03获取 抄送详情
         */
        public static final String GETCOPYDETAIL = LOGIN_URL + LOGIN_FLODER_USER + "AllCopyListInfo/GetAllCopyListInfo";

        /**
         * 01-04-01 请假申请
         */
        public static final String LEAVEPOST = LOGIN_URL + LOGIN_FLODER_USER + "Leave/LeavePost";

        /**
         * 01-04-02 出差申请
         */
        public static final String BEAWAY = LOGIN_URL + LOGIN_FLODER_USER + "BusinessTrip/BusinessTripPost";

        /*
         * 01-04-03 用车申请
         */
        public static final String VEHICLEPOST = LOGIN_URL + LOGIN_FLODER_USER + "Vehicle/VehiclePost";

        /*
         * 01-04-04 车辆维护申请
         */
        public static final String MAINTENANCE = LOGIN_URL + LOGIN_FLODER_USER + "Maintenance/MaintenancePost";

        /**
         * 01-04-05 加班申请
         */
        public static final String OVERAPPROVALPOST = LOGIN_URL + LOGIN_FLODER_USER + "OverApproval/OverApprovalPost";

        /*
                * 01-04-6 费用申请
                */
        public static final String LRAPPLICATIONPOST = LOGIN_URL + LOGIN_FLODER_USER + "LRApplicationInfo/LRApplicationInfoPost";
        /**
         * 01-04-07 离职申请
         */
        public static final String DIMISSIONPOST = LOGIN_URL + LOGIN_FLODER_USER + "Dimission/DimissionPost";

        /**
         * 01-04-08 订票申请
         */
        public static final String BOOKTICKET = LOGIN_URL + LOGIN_FLODER_USER + "OrderTickets/OrderTicketsPost";

        /**
         * 01-04-09 09调休申请
         */
        public static final String TAKEDAYSOFFPOST = LOGIN_URL + LOGIN_FLODER_USER + "TakeDaysOff/TakeDaysOffPost";

        /**
         * 01-04-010 印章申请
         */
        public static final String SIGNET = LOGIN_URL + LOGIN_FLODER_USER + "Stamprecord/StamprecordPost";

        /**
         * 01-04-11 培训申请
         */
        public static final String TRAINING = LOGIN_URL + LOGIN_FLODER_USER + "TrainingInfo/TrainingInfoPost";


        /**
         * 不适用 招聘申请
         */
        public static final String RECRUITMENTPOST = LOGIN_URL + LOGIN_FLODER_USER + "Recruitment/RecruitmentPost";
        /*
         * 不适用 借阅申请
         */
        public static final String BORROWPOST = LOGIN_URL + LOGIN_FLODER_USER + "Borrow/BorrowPost";

        /*
         * 不适用 调薪申请
         */
        public static final String CHANGESALARY = LOGIN_URL + LOGIN_FLODER_USER + "ChangeSalary/ChangeSalaryPost";

        /**
         *
         * #############################################################################################
         */

        /**
         * 07-01 应用 会议 列表
         */
        public static final String CONFERENCELIST = LOGIN_URL + LOGIN_FLODER_USER + "ConferenceList/MyConferenceList";


        /**
         * 08-01 应用 采购 列表
         */
        public static final String PROCUREMENTLIST = LOGIN_URL + LOGIN_FLODER_USER + "ProcureRecord/GetProcureRecord";

        /**
         * 08-02 应用 领用 列表
         */
        public static final String RECEIVELIST = LOGIN_URL + LOGIN_FLODER_USER + "ReceptionRecord/GetReceptionRecord";

    }

    /**
     * 通讯录接口
     */
    public class ContactsManager {
        /*
        *  获取整个公司所有分公司员工信息接口
        */
        public static final String GETCOMPANYSONOFCO = LOGIN_URL + LOGIN_FLODER_USER + "Contacts/GetStoreInfoByStoreId";

        /*
          *  获取分公司所有部门员工信息接口
          */
        public static final String DEPTINFOBYSTOREID = LOGIN_URL + LOGIN_FLODER_USER + "Contacts/GetDeptInfoByStoreId";

        /*
          *  获取分公司所有部门员工信息接口
          */
        public static final String EMPLOYEEINFOBYDEPTID = LOGIN_URL + LOGIN_FLODER_USER + "Contacts/GetEmployeeInfoByDeptId";

        /*
          * 选择审批人
          */
        public static final String CONTACTSSELECTCO = LOGIN_URL + LOGIN_FLODER_USER + "GetApplication/GetApplicationByThisEmp";

    }

}
