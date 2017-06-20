package com.huirong.ui.appsfrg.childmodel.finance;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.inject.ViewInject;
import com.huirong.model.applicationdetailmodel.FinancialAllModel;

/**
 * 应用-财务-借款详情
 * Created by sjy on 2017/2/25.
 */

public class FinancialLoanDetailActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;

    //金额
    @ViewInject(id = R.id.tv_fee)
    TextView tv_fee;

    //还款时间
    @ViewInject(id = R.id.tv_PlanbackTime)
    TextView tv_PlanbackTime;

    //说明
    @ViewInject(id = R.id.tv_reason, click = "ReasonExpended")
    TextView tv_reason;


    //申请人
    @ViewInject(id = R.id.tv_ApprovalPerson)
    TextView tv_ApprovalPerson;

    //部门
    @ViewInject(id = R.id.tv_approvaldept)
    TextView tv_approvaldept;

    //公司
    @ViewInject(id = R.id.tv_approvalCo)
    TextView tv_approvalCo;

    //申请时间
    @ViewInject(id = R.id.tv_approvalTime)
    TextView tv_approvalTime;


    //变量
    private FinancialAllModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_financial_loan_detail);


        initMyView();
        setShow();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.financial_loan));
        tv_right.setText("");
        Bundle bundle = this.getIntent().getExtras();
        model = (FinancialAllModel) bundle.getSerializable("FinancialAllModel");
    }

    private void setShow() {
        //
        tv_ApprovalPerson.setText(model.getEmployeeName());
        tv_approvaldept.setText(model.getDepartmentName());
        tv_approvalCo.setText(model.getStoreName());
        tv_approvalTime.setText(model.getCreateTime());

        //
        tv_fee.setText(model.getFee());
        tv_reason.setText(model.getReason());
    }
    /**
     * back
     *
     * @param view
     */

    public void forBack(View view) {
        this.finish();
    }
    private boolean isExpend = false;

    public void ReasonExpended(View view) {
        if (!isExpend) {
            tv_reason.setMinLines(0);
            tv_reason.setMaxLines(Integer.MAX_VALUE);
            isExpend = true;
        } else {
            tv_reason.setLines(3);
            isExpend = false;
        }

    }

}
