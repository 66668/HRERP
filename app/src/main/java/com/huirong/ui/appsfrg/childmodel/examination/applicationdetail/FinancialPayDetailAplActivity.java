package com.huirong.ui.appsfrg.childmodel.examination.applicationdetail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
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
import com.huirong.model.MyApplicationModel;
import com.huirong.model.applicationdetailmodel.FinancialAllModel;
import com.huirong.utils.LogUtils;
import com.huirong.utils.PageUtil;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

import static com.huirong.R.id.tv_contains;

/**
 * 借款详情
 * Created by sjy on 2016/12/2.
 */

public class FinancialPayDetailAplActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;

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

    //审批人
    @ViewInject(id = R.id.tv_Requester)
    TextView tv_Requester;

    //审批状况
    @ViewInject(id = R.id.tv_state_result)
    TextView tv_state_result;
    @ViewInject(id = R.id.layout_state, click = "forState")
    LinearLayout layout_state;

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

    //变量
    private Intent intent = null;
    private FinancialAllModel financialAllModel;
    private MyApplicationModel model;
    private List<FinancialAllModel.ApprovalInfoLists> modelList;

    //imageLoader图片缓存
    private ImageLoader imgLoader;
    private DisplayImageOptions imgOptions;

    //动态添加view 变量
    private List<View> ls_childView;//用于保存动态添加进来的View
    private View childView;
    private LayoutInflater inflater;//ViewHolder对象用来保存实例化View的子控件
    private List<ViewHolder> listViewHolder = new ArrayList<>();

    //常量
    public static final int POST_SUCCESS = 11;
    public static final int POST_FAILED = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_financial_pay_d);


        initMyView();


        getDetailModel(model);
    }
    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.financial_pay));
        tv_right.setText("");

        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(this));
        imgOptions = ImageLoadingConfig.generateDisplayImageOptions(R.mipmap.ic_launcher);

        intent = getIntent();
        model = (MyApplicationModel) intent.getSerializableExtra("MyApplicationModel");

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


        tv_feeType.setText(model.getPaymentmethod());
        tv_payOfficial.setText(model.getCollectionunit());
        tv_Account.setText(model.getAccountnumber());
        tv_bank.setText(model.getBankaccount());
        tv_fee.setText(model.getFee());
        tv_remark.setText(model.getRemark());



        modelList = model.getApprovalInfoLists();
        // 审批人
        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < modelList.size(); i++) {
            nameBuilder.append(modelList.get(i).getApprovalEmployeeName() + " ");
        }
        tv_Requester.setText(nameBuilder);

        //审批状态
        if (financialAllModel.getApprovalStatus().contains("0")) {
            tv_state_result.setText("未审批");
            tv_state_result.setTextColor(getResources().getColor(R.color.red));
        } else if (financialAllModel.getApprovalStatus().contains("1")) {
            tv_state_result.setText("已审批");
            tv_state_result.setTextColor(getResources().getColor(R.color.green));
        } else if (financialAllModel.getApprovalStatus().contains("2")) {
            tv_state_result.setText("审批中...");
            tv_state_result.setTextColor(getResources().getColor(R.color.black));
        } else {
            tv_state_result.setText("你猜猜！");
        }

        if (financialAllModel.getApprovalStatus().contains("1") || financialAllModel.getApprovalStatus().contains("2")) {
            //插入意见
            for (int i = 0, mark = layout_ll.getChildCount(); i < modelList.size(); i++, mark++) {//mark是布局插入位置，放在mark位置的后边（从1开始计数）
                ViewHolder vh = AddView(this,mark);//添加布局
                vh.tv_name.setText(modelList.get(i).getApprovalEmployeeName());
                vh.tv_time.setText(modelList.get(i).getApprovalDate());
                vh.tv_contains.setText(modelList.get(i).getComment());
                if (modelList.get(i).getYesOrNo().contains("0")) {
                    vh.tv_yesOrNo.setText("不同意");
                    vh.tv_yesOrNo.setTextColor(getResources().getColor(R.color.red));
                }else if(TextUtils.isEmpty(modelList.get(i).getYesOrNo())){
                    vh.tv_yesOrNo.setText("未审批");
                    vh.tv_yesOrNo.setTextColor(getResources().getColor(R.color.red));
                } else if ((modelList.get(i).getYesOrNo().contains("1"))) {
                    vh.tv_yesOrNo.setText("同意");
                    vh.tv_yesOrNo.setTextColor(getResources().getColor(R.color.green));
                } else{
                    vh.tv_yesOrNo.setText("yesOrNo为null");
                }
            }
        }

    }


    /**
     * 获取详情数据
     */
    public void getDetailModel(final MyApplicationModel model) {
        Loading.run(this, new Runnable() {
            @Override
            public void run() {

                //泛型
                try {
                    FinancialAllModel model1 = new UserHelper<>(FinancialAllModel.class)
                            .applicationDetailPost(FinancialPayDetailAplActivity.this,
                                    model.getApplicationID(),
                                    model.getApplicationType());
                    sendMessage(POST_SUCCESS, model1);
                } catch (MyException e) {
                    e.printStackTrace();
                    sendMessage(POST_FAILED, e.getMessage());
                }
            }
        });
    }

    @Override
    protected void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case POST_SUCCESS: // 1001
                financialAllModel = (FinancialAllModel) msg.obj;
                setShow(financialAllModel);
                break;
            case POST_FAILED: // 1001
                PageUtil.DisplayToast((String) msg.obj);
                break;
            default:
                break;
        }
    }

    /**
     * 动态插入view
     */
    public class ViewHolder {
        private int id = -1;
        private TextView tv_name;
        private TextView tv_yesOrNo;
        private TextView tv_time;
        private TextView tv_contains;
    }

    //初始化参数
    private ViewHolder AddView(Context context, int marks) {
        ls_childView = new ArrayList<View>();
        inflater = LayoutInflater.from(context);
        childView = inflater.inflate(R.layout.item_examination_status,  new LinearLayout(this), false);
        childView.setId(marks);
        layout_ll.addView(childView, marks);
        return getViewInstance(childView);

    }

    private ViewHolder getViewInstance(View childView) {
        ViewHolder vh = new ViewHolder();
        vh.id = childView.getId();
        vh.tv_name = (TextView) childView.findViewById(R.id.tv_name);
        vh.tv_yesOrNo = (TextView) childView.findViewById(R.id.tv_yesOrNo);
        vh.tv_time = (TextView) childView.findViewById(R.id.tv_time);
        vh.tv_contains = (TextView) childView.findViewById(tv_contains);
        listViewHolder.add(vh);
        ls_childView.add(childView);
        return vh;
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
