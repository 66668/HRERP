package com.huirong.ui.appsfrg.childmodel.mission;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.application.MyApplication;
import com.huirong.base.BaseActivity;
import com.huirong.common.MyException;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.mission.MissionListModel;
import com.huirong.utils.PageUtil;

/**
 * 完成界面
 * 任务 我负责的
 * Created by sjy on 2017/1/17.
 */

public class CommonCompleteActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;
    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right, click = "forApprove")
    TextView tv_right;

    //内容
    @ViewInject(id = R.id.et_container)
    EditText et_container;

    //变量
    private MissionListModel model;
    private String comment;

    //常量
    private static final int POST_SUCCESS = 11;
    private static final int POST_FAILED = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_mission_complete);
        tv_title.setText(getResources().getString(R.string.msn_complete));

        //获取调转对象
        Bundle bundle = getIntent().getExtras();
        model = (MissionListModel) bundle.getSerializable("MissionListModel");

        MyApplication.getInstance().addACT(this);
    }

    /**
     * 提交 完成任务
     *
     * @param view
     */
    public void forApprove(View view) {
        comment = et_container.getText().toString();
        if (TextUtils.isEmpty(comment)) {
            PageUtil.DisplayToast("提交内容不能为空");
            return;
        }
        Loading.run(this, new Runnable() {

            @Override
            public void run() {
                try {
                    UserHelper.toCompleteMission(CommonCompleteActivity.this
                            , model.getMaintainID()
                            , comment);

                    sendMessage(POST_SUCCESS);
                } catch (MyException e) {
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
                PageUtil.DisplayToast("提交成功");

                MyApplication.getInstance().closeACT();
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
}
