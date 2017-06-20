package com.huirong.ui.appsfrg.childmodel.examination.create;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.application.MyApplication;
import com.huirong.base.BaseActivity;
import com.huirong.inject.ViewInject;
import com.huirong.ui.appsfrg.childmodel.examination.create.financial.FinancialLoanActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.financial.FinancialPayActivity;
import com.huirong.ui.appsfrg.childmodel.examination.create.financial.FinancialReimburseActivity;

/**
 * 财务申请
 * Created by sjy on 2016/12/2.
 */

public class FinancialMainActivity extends BaseActivity {

    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;

    // 借款申请
    @ViewInject(id = R.id.btn_loan, click = "forLoan")
    RelativeLayout btn_loan;

    //报销申请
    @ViewInject(id = R.id.btn_reimburse, click = "forReimburse")
    RelativeLayout btn_reimburse;

    //付款申请
    @ViewInject(id = R.id.btn_pay, click = "forPay")
    RelativeLayout btn_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_financial);
        tv_title.setText(getResources().getString(R.string.financial_title));
        tv_right.setText("");

        //多页面finish使用
        MyApplication.getInstance().addACT(this);
    }

    /**
     * 借款
     */
    public void forLoan(View view) {
        startActivity(FinancialLoanActivity.class);
    }

    /**
     * 报销
     */
    public void forReimburse(View view) {
        startActivity(FinancialReimburseActivity.class);
    }



    /**
     * 付款申请
     */
    public void forPay(View view) {
        startActivity(FinancialPayActivity.class);
    }

    /**
     * back
     *
     * @param view
     */

    public void forBack(View view) {
        this.finish();
    }
}
