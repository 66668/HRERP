package com.huirong.ui.appsfrg.childmodel.finance;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.common.ImageLoadingConfig;
import com.huirong.common.MyException;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.AppFinancialModel;
import com.huirong.model.applicationdetailmodel.FinancialAllModel;
import com.huirong.utils.LogUtils;
import com.huirong.utils.PageUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * 应用-财务-付款 详情
 * Created by sjy on 2017/2/25.
 */

public class FinancialPayDetailActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;


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


    //付款方式
    @ViewInject(id = R.id.tv_feeType)
    TextView tv_feeType;

    //收款单位
    @ViewInject(id = R.id.tv_payOfficial)
    TextView tv_payOfficial;

    //账号
    @ViewInject(id = R.id.tv_Account)
    TextView tv_Account;

    //开户行
    @ViewInject(id = R.id.tv_bank)
    TextView tv_bank;
    //金额
    @ViewInject(id = R.id.tv_fee)
    TextView tv_fee;

    //备注
    @ViewInject(id = R.id.tv_remark, click = "RemarkExpended")
    TextView tv_remark;

    //获取子控件个数的父控件
    @ViewInject(id = R.id.layout_ll)
    LinearLayout layout_ll;

    //图片1
    @ViewInject(id = R.id.img_01, click = "imgDetail01")
    ImageView img_01;

    //图片2
    @ViewInject(id = R.id.img_02, click = "imgDetail02")
    ImageView img_02;

    //图片3
    @ViewInject(id = R.id.img_03, click = "imgDetail03")
    ImageView img_03;
    //常量
    public static final int POST_SUCCESS = 21;
    public static final int POST_FAILED = 22;
    //变量
    private AppFinancialModel appFinancialModel;

    private FinancialAllModel model;
    //imageLoader图片缓存
    private ImageLoader imgLoader;
    private DisplayImageOptions imgOptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_financial_pay_detail);

        initMyView();
        getDetailData();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.financial_pay));
        tv_right.setText("");

        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(this));
        imgOptions = ImageLoadingConfig.generateDisplayImageOptions(R.mipmap.ic_launcher);
        Bundle bundle = this.getIntent().getExtras();
        appFinancialModel = (AppFinancialModel) bundle.getSerializable("AppFinancialModel");
    }

    private void setShow() {
        //
        tv_ApprovalPerson.setText(model.getEmployeeName());
        tv_approvaldept.setText(model.getDepartmentName());
        tv_approvalCo.setText(model.getStoreName());
        tv_approvalTime.setText(model.getApplicationCreateTime());

        //
        tv_feeType.setText(model.getPaymentmethod());
        tv_payOfficial.setText(model.getCollectionunit());
        tv_Account.setText(model.getAccountnumber());
        tv_bank.setText(model.getBankaccount());
        tv_fee.setText(model.getFee());
        tv_remark.setText(model.getRemark());

        if (model.getImageLists().size() == 1) {
            imgLoader.displayImage(model.getImageLists().get(0), img_01, imgOptions);
        }

        if (model.getImageLists().size() == 2) {
            imgLoader.displayImage(model.getImageLists().get(0), img_01, imgOptions);
            imgLoader.displayImage(model.getImageLists().get(1), img_02, imgOptions);
        }

        if (model.getImageLists().size() == 3) {
            imgLoader.displayImage(model.getImageLists().get(0), img_01, imgOptions);
            imgLoader.displayImage(model.getImageLists().get(1), img_02, imgOptions);
            imgLoader.displayImage(model.getImageLists().get(2), img_03, imgOptions);
        }

    }
    private void getDetailData() {
        Loading.run(this, new Runnable() {
            @Override
            public void run() {
                //泛型
                try {
                    FinancialAllModel model1 = new UserHelper<>(FinancialAllModel.class)
                            .approvalDetailPost(FinancialPayDetailActivity.this,
                                    appFinancialModel.getApplicationID(),
                                    appFinancialModel.getApplicationType());

                    sendMessage(POST_SUCCESS, model1);
                } catch (MyException e) {
                    LogUtils.d("报销详情异常", e.toString());
                    sendMessage(POST_FAILED, e.getMessage());
                }
            }
        });
    }

    @Override
    protected void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case POST_SUCCESS:
                model = (FinancialAllModel) msg.obj;
                setShow();
                break;
            case POST_FAILED:
                PageUtil.DisplayToast((String) msg.obj);
                break;
            default:
                break;
        }
    }
    /**
     * back
     *
     * @param view
     */

    public void forBack(View view) {
        this.finish();
    }
    private boolean isRemarkExpend = false;

    public void RemarkExpended(View view) {
        if (!isRemarkExpend) {
            tv_remark.setMinLines(0);
            tv_remark.setMaxLines(Integer.MAX_VALUE);
            isRemarkExpend = true;
        } else {
            tv_remark.setLines(3);
            isRemarkExpend = false;
        }

    }
}
