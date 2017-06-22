package com.huirong.ui.appsfrg.childmodel.workplan;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.inject.ViewInject;
import com.huirong.model.workplan.WorkplanListModel;

/**
 * 工作计划详情 收到
 * Created by sjy on 2017/2/25
 */

public class WorkplanReceiveDetailActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;



    //标题
    @ViewInject(id = R.id.tv_workplan_title)
    TextView tv_workplan_title;

    //时间
    @ViewInject(id = R.id.tv_time)
    TextView tv_time;

    //发件人
    @ViewInject(id = R.id.tv_to)
    TextView tv_to;

    //进度
    @ViewInject(id = R.id.tv_advance)
    TextView tv_advance;

    //完成时间
    @ViewInject(id = R.id.tv_completeTime)
    TextView tv_completeTime;

    //内容
    @ViewInject(id = R.id.tv_content)
    TextView tv_content;

    //备注
    @ViewInject(id = R.id.tv_remark)
    TextView tv_remark;



    private WorkplanListModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_workplan_receive_detail);
        initMyView();
        setShow();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.workplan_title_send));
        tv_right.setText("");

        //获取跳转值
        Bundle bundle = getIntent().getExtras();
        model = (WorkplanListModel) bundle.getSerializable("WorkplanListModel");
        //        readThisNotice(model);
    }

    private void setShow() {
        tv_workplan_title.setText(model.getTitle());
        tv_time.setText(model.getCreateTime());
        tv_to.setText(model.getUploaderEmployeeID());
        tv_advance.setText(model.getSchedules());
        tv_completeTime.setText(model.getCompletiontime());
        tv_content.setText(model.getPlancontent());
        tv_remark.setText(model.getRemark());
    }

    /**
     * 调接口 未读-->已读
     * @param model
     */
    //    private void readThisNotice(final WorkplanListModel model){
    //        Loading.noDialogRun(this, new Runnable() {
    //            @Override
    //            public void run() {
    //                try {
    //                    UserHelper.postReadThisNotice(WorkplanDetailActivity.this
    //                            ,model.getApplicationID());
    //                    Log.d("SJY", "成功");
    //                } catch (MyException e) {
    //                    e.printStackTrace();
    //                    Log.d("SJY", "已读异常="+e.getMessage());
    //                }
    //            }
    //        });
    //    }

    /**
     * back
     *
     * @param view
     */
    public void forBack(View view) {
        this.finish();
    }
}
