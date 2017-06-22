package com.huirong.ui.appsfrg.childmodel.finance;

import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
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
 * 应用-财务-报销 详情
 * Created by sjy on 2017/2/25.
 */

public class FinancialRemburseDetailActivity extends BaseActivity {

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


    //1
    @ViewInject(id = R.id.tv_feeOne)
    TextView tv_feeOne;
    //1
    @ViewInject(id = R.id.tv_useageOne)
    TextView tv_useageOne;
    //2
    @ViewInject(id = R.id.tv_feeTwo)
    TextView tv_feeTwo;
    //2
    @ViewInject(id = R.id.tv_useageTwo)
    TextView tv_useageTwo;
    //3
    @ViewInject(id = R.id.tv_feeThree)
    TextView tv_feeThree;
    //3
    @ViewInject(id = R.id.tv_useageThree)
    TextView tv_useageThree;
    //
    @ViewInject(id = R.id.tv_totle)
    TextView tv_totle;
    //备注
    @ViewInject(id = R.id.tv_remark, click = "RemarkExpended")
    TextView tv_remark;

    //图片1
    @ViewInject(id = R.id.img_01, click = "imgDetail01")
    ImageView img_01;

    //图片2
    @ViewInject(id = R.id.img_02, click = "imgDetail02")
    ImageView img_02;

    //图片3
    @ViewInject(id = R.id.img_03, click = "imgDetail03")
    ImageView img_03;

    //变量
    private AppFinancialModel appFinancialModel;

    private FinancialAllModel model;

    //imageLoader图片缓存
    private ImageLoader imgLoader;
    private DisplayImageOptions imgOptions;
    //常量
    public static final int POST_SUCCESS = 21;
    public static final int POST_FAILED = 22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_financial_reimburse_detail);

        initMyView();
        getDetailData();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.financial_reimburse));
        tv_right.setText("");

        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(this));
        imgOptions = ImageLoadingConfig.generateDisplayImageOptions(R.mipmap.ic_launcher);

        Bundle bundle = this.getIntent().getExtras();
        appFinancialModel = (AppFinancialModel) bundle.getSerializable("AppFinancialModel");
    }

    private void setShow(FinancialAllModel model) {
        LogUtils.d("SJY", "图片size=" + model.getImageLists().size());

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
        //
        tv_ApprovalPerson.setText(model.getEmployeeName());
        tv_approvaldept.setText(model.getDepartmentName());
        tv_approvalCo.setText(model.getStoreName());
        tv_approvalTime.setText(model.getApplicationCreateTime());

        //
        tv_feeOne.setText(model.getJine1());
        tv_feeTwo.setText(model.getJine2());
        tv_feeThree.setText(model.getJine3());

        tv_useageOne.setText(model.getZhaiyao1());
        tv_useageTwo.setText(model.getZhaiyao2());
        tv_useageThree.setText(model.getZhaiyao3());

        tv_totle.setText(model.getHeji());
        tv_remark.setText(model.getRemark());
    }

    private void getDetailData() {
        Loading.run(this, new Runnable() {
            @Override
            public void run() {
                //泛型
                try {
                    FinancialAllModel model1 = new UserHelper<>(FinancialAllModel.class)
                            .approvalDetailPost(FinancialRemburseDetailActivity.this,
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
                setShow(model);
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