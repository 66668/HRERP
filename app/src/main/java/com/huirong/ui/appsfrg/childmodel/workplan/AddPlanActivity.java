package com.huirong.ui.appsfrg.childmodel.workplan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.common.MyException;
import com.huirong.dialog.DateChooseWheelViewDialog;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.ContactsEmployeeModel;
import com.huirong.ui.contractsfrg.ContactsSelectActivity;
import com.huirong.utils.LogUtils;
import com.huirong.utils.PageUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * 添加 工作计划
 */

public class AddPlanActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right, click = "forCommit")
    TextView forCommit;


    //标题
    @ViewInject(id = R.id.et_planTitle)
    EditText et_planTitle;

    //进度
    @ViewInject(id = R.id.et_advance)
    EditText et_advance;

    //完成时间
    @ViewInject(id = R.id.layout_startTime, click = "startTime")
    LinearLayout layout_startTime;
    @ViewInject(id = R.id.tv_timeStart)
    TextView tv_timeStart;

    //完成内容
    @ViewInject(id = R.id.et_planContent)
    EditText et_planContent;

    //备注
    @ViewInject(id = R.id.et_remark)
    EditText et_remark;


    //添加审批人
    @ViewInject(id = R.id.AddApprover, click = "forAddApprover")
    RelativeLayout AddApprover;

    //审批人
    @ViewInject(id = R.id.tv_Requester)
    TextView tv_Requester;


    //变量
    private String planTitle;
    private String planAdvance;
    private String planCompleteTime;
    private String planContent;
    private String remark;
    private String approvalID = "";


    //常量
    public static final int POST_SUCCESS = 15;
    public static final int POST_FAILED = 16;
    public static final String TAG = "工作计划";//图片展示


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_workplan_add);

        initMyView();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.workplan_add));
    }

    public void forCommit(View view) {

        planContent = et_planContent.getText().toString();
        remark = et_remark.getText().toString();
        planTitle = et_planTitle.getText().toString();
        planAdvance = et_advance.getText().toString().trim();

        if (TextUtils.isEmpty(planTitle)) {
            PageUtil.DisplayToast("标题不能为空");
            return;
        }
        if (TextUtils.isEmpty(planAdvance)) {
            PageUtil.DisplayToast("进度不能为空");
            return;
        }
        if (TextUtils.isEmpty(planCompleteTime)) {
            PageUtil.DisplayToast("时间不能为空");
            return;
        }
        if (TextUtils.isEmpty(planContent)) {
            PageUtil.DisplayToast("内容不能为空");
            return;
        }

        if (TextUtils.isEmpty(approvalID)) {
            PageUtil.DisplayToast("审批人不能为空");
            return;
        }

        Loading.run(AddPlanActivity.this, new Runnable() {
            @Override
            public void run() {
                try {

                    JSONObject js = new JSONObject();
                    js.put("UploaderEmployeeID", UserHelper.getCurrentUser().getEmployeeID());
                    js.put("Title", planTitle);
                    js.put("Plancontent", planContent);
                    js.put("Schedules", planAdvance);
                    js.put("Completiontime", planCompleteTime);
                    js.put("Remark", remark);
                    js.put("RecipientIDList", approvalID);

                    UserHelper.addWorkplan(AddPlanActivity.this, js);
                    sendMessage(POST_SUCCESS);
                } catch (MyException e) {
                    sendMessage(POST_FAILED, e.getMessage());

                } catch (JSONException e) {
                    LogUtils.e(TAG, e.getMessage());
                }
            }
        });

    }

    @Override
    protected void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case POST_SUCCESS:
                PageUtil.DisplayToast("添加计划成功");
                this.finish();
                break;
            case POST_FAILED:
                PageUtil.DisplayToast((String) msg.obj);
                break;
        }
    }

    private void clear() {

    }


    /**
     * 添加审批人
     *
     * @param view
     */
    public void forAddApprover(View view) {
        myStartForResult(ContactsSelectActivity.class, 0);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && resultCode == 0) {
            //判断返回值是否为空
            List<ContactsEmployeeModel> list = new ArrayList<>();
            if (data != null && (List<ContactsEmployeeModel>) data.getSerializableExtra("data") != null) {
                list = (List<ContactsEmployeeModel>) data.getSerializableExtra("data");
            } else {

            }
            StringBuilder name = new StringBuilder();
            StringBuilder employeeId = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                name.append(list.get(i).getsEmployeeName() + "  ");
                employeeId.append(list.get(i).getsEmployeeID() + ",");
            }
            approvalID = getApprovalID(employeeId.toString());
            Log.d("SJY", "approvalID=" + approvalID);
            tv_Requester.setText(name);
        }
    }

    /*
     *处理字符串，去除末尾逗号
     */
    private String getApprovalID(String str) {
        if (str.length() > 1) {
            return str.substring(0, str.length() - 1);
        } else {
            return "";
        }
    }

    /**
     * 完成时间
     *
     * @param view
     */
    public void startTime(View view) {
        DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(AddPlanActivity.this,
                new DateChooseWheelViewDialog.DateChooseInterface() {
                    @Override
                    public void getDateTime(String time, boolean longTimeChecked) {
                        planCompleteTime = time;
                        tv_timeStart.setText(time);
                    }
                });
        endDateChooseDialog.setDateDialogTitle("开始时间");
//        endDateChooseDialog.setTimePickerGone(true);
        endDateChooseDialog.showDateChooseDialog();
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
