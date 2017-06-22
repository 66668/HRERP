package com.huirong.ui.appsfrg.childmodel.mission;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.common.MyException;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.mission.MissionListModel;
import com.huirong.utils.LogUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 工作计划详情 发出
 * Created by sjy on 2017/2/25
 */

public class MissionSendDetailActivity extends BaseActivity {
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
    @ViewInject(id = R.id.tv_msnTitle)
    TextView tv_msnTitle;

    //内容
    @ViewInject(id = R.id.tv_msnContent,click = "ContentExpended")
    TextView tv_msnContent;

    //任务类型
    @ViewInject(id = R.id.tv_msnType)
    TextView tv_msnType;

    //维修地点
    @ViewInject(id = R.id.tv_msnPlace)
    TextView tv_msnPlace;

    //维修维护人
    @ViewInject(id = R.id.tv_maintainMan)
    TextView tv_maintainMan;

    //联系方式
    @ViewInject(id = R.id.tv_repairWay)
    TextView tv_repairWay;

    //完成时间
    @ViewInject(id = R.id.tv_completeTime)
    TextView tv_completeTime;


    //备注
    @ViewInject(id = R.id.tv_remark,click = "RemarkExpended")
    TextView tv_remark;


    private MissionListModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_mission_send_detail);
        initMyView();
        setShow();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.workplan_title_send));
        tv_right.setText("");

        //获取跳转值
        Bundle bundle = getIntent().getExtras();
        model = (MissionListModel) bundle.getSerializable("MissionListModel");
        readThisNotice(model);
    }

    private void setShow() {

//        tv_workplan_title.setText(model.getTitle());
//        tv_time.setText(model.getCreateTime());
//        tv_to.setText(model.getUploaderEmployeeID());
//        tv_rec.setText(model.getReceiveerEmployeeID());
//        tv_advance.setText(model.getSchedules());
//        tv_completeTime.setText(model.getCompletiontime());
//        tv_content.setText(model.getPlancontent());
//        tv_remark.setText(model.getRemark());
    }

    /**
     * 调接口 未读-->已读
     *
     * @param model
     */
    private void readThisNotice(final MissionListModel model) {
        Loading.noDialogRun(this, new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject js = new JSONObject();
                    try {
                        js.put("maintainID",model.getMaintainID());
                        js.put("employeeId",UserHelper.getCurrentUser().getEmployeeID());
                        js.put("IsYesNo","已完成");
                        js.put("ISremark","已完成");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    UserHelper.postReadThisMission(MissionSendDetailActivity.this, js);
                    LogUtils.d("SJY", "成功");
                } catch (MyException e) {
                    e.printStackTrace();
                    LogUtils.d("SJY", "已读异常=" + e.getMessage());
                }
            }
        });
    }

    /**
     * 备注显示扩展
     */
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

    /**
     * 内容显示扩展
     */
    private boolean isContentExpend = false;

    public void ContentExpended(View view) {
        if (!isContentExpend) {
            tv_msnContent.setMinLines(0);
            tv_msnContent.setMaxLines(Integer.MAX_VALUE);
            isContentExpend = true;
        } else {
//            tv_msnContent.setLines(5);
            tv_msnContent.setMaxLines(Integer.MAX_VALUE);
            isContentExpend = false;
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
