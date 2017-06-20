package com.huirong.ui.appsfrg;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.inject.ViewInject;
import com.huirong.ui.appsfrg.childmodel.examination.ZOAplicationListActivity;
import com.huirong.ui.appsfrg.childmodel.examination.ZOApprovelListActivity;
import com.huirong.ui.appsfrg.childmodel.examination.ZOCopyListActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.BeAwayActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.BookTicketsActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.DimissionActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.FinancialMainActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.LeaveActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.SignetActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.TakeDaysOffActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.TrainingActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.VehicleActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.VehicleMaintainActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.WorkOverTimeActivity;

/**
 * 审批
 * Created by JackSong on 2016/10/25.
 */

public class ExaminationAcitivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;


    //我的申请
    @ViewInject(id = R.id.btn_MyApplication, click = "myApplication")
    LinearLayout btn_MyApplication;

    //我的审批
    @ViewInject(id = R.id.btn_MyApproval, click = "myApproval")
    LinearLayout btn_MyApproval;

    //我的抄送
    @ViewInject(id = R.id.btn_copyReturn, click = "myCopyReturn")
    LinearLayout btn_copyReturn;

    //1请假
    @ViewInject(id = R.id.btn_forLeave, click = "forLeave")
    LinearLayout btn_forLeave;

    //2出差
    @ViewInject(id = R.id.btn_beAway, click = "forAway")
    LinearLayout btn_beAway;

    //3用车
    @ViewInject(id = R.id.btn_carused, click = "forCarused")
    LinearLayout btn_carused;

    //4车辆维护
    @ViewInject(id = R.id.btn_vehicleMaintenance, click = "forVehicleMaintenance")
    LinearLayout btn_vehicleMaintenance;

    //5加班
    @ViewInject(id = R.id.btn_overTime, click = "forWorkOverTime")
    LinearLayout btn_overTime;

    //6财务
    @ViewInject(id = R.id.btn_LoanReimbursement, click = "forLoanReimbursement")
    LinearLayout btn_LoanReimbursement;

    //7离职
    @ViewInject(id = R.id.btn_jobsLeave, click = "forJobsLeave")
    LinearLayout btn_jobsLeave;

    //8订票
    @ViewInject(id = R.id.btn_bookticket, click = "booktickets")
    LinearLayout btn_bookticket;

    //9调休
    @ViewInject(id = R.id.btn_rest, click = "forWorkRest")
    LinearLayout btn_rest;

    //10印章
    @ViewInject(id = R.id.btn_signet, click = "forSignet")
    LinearLayout btn_signet;

    //11培训
    @ViewInject(id = R.id.btn_training, click = "foTraining")
    LinearLayout btn_training;

    //```````````````````````````````````````````````````````````````````````````
    //    //招聘
    //    @ViewInject(id = R.id.btn_jobs, click = "forJobs")
    //    LinearLayout btn_jobs;
    //
    //    //借阅
    //    @ViewInject(id = R.id.btn_borrow, click = "forBorrow")
    //    LinearLayout btn_borrow;
    //
    //    //薪资调整
    //    @ViewInject(id = R.id.btn_Salaryadjust, click = "Salaryadjust")
    //    LinearLayout btn_Salaryadjust;
    //```````````````````````````````````````````````````````````````````````````

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination);
        tv_title.setText(getResources().getString(R.string.examination));
        tv_right.setText("");

    }

    /**
     * 我的申请
     *
     * @param view
     */
    public void myApplication(View view) {
        startActivity(ZOAplicationListActivity.class);

    }

    /**
     * 我的审批
     *
     * @param view
     */
    public void myApproval(View view) {
        startActivity(ZOApprovelListActivity.class);
    }

    /**
     * 我的抄送
     *
     * @param view
     */
    public void myCopyReturn(View view) {
        startActivity(ZOCopyListActivity.class);
    }


    //    /**
    //     * 01招聘
    //     *
    //     * @param view
    //     */
    //    public void forJobs(View view) {
    //        startActivity(RecruitmentActivity.class);
    //    }
    //    /**
    //     * 06借阅
    //     *
    //     * @param view
    //     */
    //    public void forBorrow(View view) {
    //        startActivity(BorrowActivity.class);
    //    }
    //    /**
    //     * 07薪资调整
    //     *
    //     * @param view
    //     */
    //    public void Salaryadjust(View view) {
    //        startActivity(SalaryadjustActivity.class);
    //    }


    /**
     * 01请假Leave
     *
     * @param view
     */
    public void forLeave(View view) {
        startActivity(LeaveActivity.class);
    }

    /**
     * 02出差
     *
     * @param view
     */
    public void forAway(View view) {
        startActivity(BeAwayActivity.class);
    }

    /**
     * 03用车
     *
     * @param view
     */
    public void forCarused(View view) {
        startActivity(VehicleActivity.class);
    }

    /**
     * 04车辆维护
     *
     * @param view
     */
    public void forVehicleMaintenance(View view) {
        startActivity(VehicleMaintainActivity.class);
    }

    /**
     * 05加班
     *
     * @param view
     */
    public void forWorkOverTime(View view) {
        startActivity(WorkOverTimeActivity.class);
    }

    /**
     * 06财务
     *
     * @param view
     */
    public void forLoanReimbursement(View view) {
        startActivity(FinancialMainActivity.class);
    }

    /**
     * 07离职jobsLeave
     *
     * @param view
     */
    public void forJobsLeave(View view) {
        startActivity(DimissionActivity.class);
    }

    /**
     * 08订票
     *
     * @param view
     */
    public void booktickets(View view) {
        startActivity(BookTicketsActivity.class);
    }


    /**
     * 09调休
     *
     * @param view
     */
    public void forWorkRest(View view) {
        startActivity(TakeDaysOffActivity.class);
    }

    /**
     * 10印章
     *
     * @param view
     */
    public void forSignet(View view) {
        startActivity(SignetActivity.class);
    }

    /**
     * 11培训
     *
     * @param view
     */
    public void foTraining(View view) {
        startActivity(TrainingActivity.class);
    }

    /**
     * back
     */

    public void forBack(View view) {
        this.finish();
    }
}
