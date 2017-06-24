package com.huirong.ui.appsfrg.childmodel.examination.create;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.huirong.ui.appsfrg.childmodel.examination.ZOAplicationListActivity;
import com.huirong.ui.contractsfrg.ContactsSelectActivity;
import com.huirong.utils.PageUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 培训申请
 */

public class TrainingActivity extends BaseActivity {

    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right, click = "forCommit")
    TextView forCommit;


    //培训方式
    @ViewInject(id = R.id.layout_type, click = "forMode")
    LinearLayout layout_type;
    @ViewInject(id = R.id.tv_mode)
    TextView tv_mode;

    //培训形式
    @ViewInject(id = R.id.layout_way, click = "forForm")
    LinearLayout layout_way;
    @ViewInject(id = R.id.tv_form)
    TextView tv_form;

    //开始时间
    @ViewInject(id = R.id.layout_startTime, click = "startTime")
    LinearLayout layout_startTime;
    @ViewInject(id = R.id.tv_timeStart)
    TextView tv_timeStart;


    //结束时间
    @ViewInject(id = R.id.layout_endTime, click = "endTime")
    LinearLayout layout_end;
    @ViewInject(id = R.id.tv_endTime)
    TextView tv_endTime;

    //备注
    @ViewInject(id = R.id.et_remark)
    EditText et_remark;

    //内容
    @ViewInject(id = R.id.et_content)
    EditText et_content;

    //培训人员
    @ViewInject(id = R.id.et_person)
    EditText et_person;

    //培训费用
    @ViewInject(id = R.id.et_fee)
    EditText et_fee;

    //培训地址
    @ViewInject(id = R.id.et_place)
    EditText et_place;


    //添加图片
    @ViewInject(id = R.id.addPicture, click = "ForAddPicture")
    RelativeLayout addPicture;

    //添加审批人
    @ViewInject(id = R.id.AddApprover, click = "forAddApprover")
    RelativeLayout AddApprover;

    //审批人
    @ViewInject(id = R.id.tv_Requester)
    TextView tv_Requester;


    //变量
    private String mode;
    private String form;
    private String startDate;
    private String endDates;
    private String person;
    private String fee;
    private String place;
    private String content;
    private String remark = "";
    private String approvalID = "";

    //常量
    public static final int POST_SUCCESS = 15;
    public static final int POST_FAILED = 16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_training);

        initMyView();
        initListener();
    }

    private void initMyView() {
        tv_title.setText(getResources().getString(R.string.training));
    }

    private void initListener() {

    }

    public void forCommit(View view) {
        content = et_content.getText().toString();
        remark = et_remark.getText().toString();
        person = et_person.getText().toString();
        fee = et_fee.getText().toString();
        place = et_place.getText().toString();
        remark = et_remark.getText().toString();


        if (TextUtils.isEmpty(mode)) {
            PageUtil.DisplayToast("培训方式不能为空");
            return;
        }

        if (TextUtils.isEmpty(form)) {
            PageUtil.DisplayToast("培形式不能为空");
            return;
        }
        if (TextUtils.isEmpty(content)) {
            PageUtil.DisplayToast("培形式不能为空");
            return;
        }

        if (TextUtils.isEmpty(startDate) || TextUtils.isEmpty(endDates)) {
            PageUtil.DisplayToast("培训时间不能为空");
            return;
        }

        if (TextUtils.isEmpty(approvalID)) {
            PageUtil.DisplayToast("审批人不能为空");
            return;
        }
        Loading.run(TrainingActivity.this, new Runnable() {
            @Override
            public void run() {
                try {


                    JSONObject js = new JSONObject();
                    js.put("TrainingMode", mode);
                    js.put("TrainingForm", form);
                    js.put("BeginTime", startDate);
                    js.put("FinishTime", endDates);
                    js.put("Cost", fee);
                    js.put("Person", person);
                    js.put("Content", content);
                    js.put("TrainingSite", place);
                    js.put("Remark", remark);
                    js.put("ApprovalIDList", approvalID);

                    UserHelper.trainingPost(TrainingActivity.this, js);
                    sendMessage(POST_SUCCESS);
                } catch (MyException e) {
                    sendMessage(POST_FAILED, e.getMessage());

                } catch (JSONException e) {
                    Log.d("SJY", e.getMessage());
                }
            }
        });

    }

    @Override
    protected void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case POST_SUCCESS:
                PageUtil.DisplayToast(getResources().getString(R.string.approval_success));
                //                clear();
                startActivity(ZOAplicationListActivity.class);
                this.finish();
                break;
            case POST_FAILED:
                PageUtil.DisplayToast((String) msg.obj);
                break;

        }
    }

    private void clear() {
        et_person.setText("");
        et_fee.setText("");
        et_place.setText("");
        et_remark.setText("");
        tv_timeStart.setText("");
        tv_endTime.setText("");
        tv_Requester.setText("");
        startDate = null;
        endDates = null;
        approvalID = null;
    }


    /**
     * 培训方式
     *
     * @param view
     */
    public void forMode(View view) {
        //    设置一个单项选择下拉框
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
         * 第三个参数给每一个单选项绑定一个监听器
         */
        AlertDialog.Builder buidler = new AlertDialog.Builder(this);
        buidler.setTitle(getResources().getString(R.string.train_mode_title));
        final String[] data = getResources().getStringArray(R.array.mode);
        buidler.setSingleChoiceItems(data, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mode = data[which];
                tv_mode.setText(data[which].trim());
                dialog.dismiss();
            }
        });
        buidler.show();
    }

    /**
     * 培训形式
     *
     * @param view
     */
    public void forForm(View view) {
        //    设置一个单项选择下拉框
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
         * 第三个参数给每一个单选项绑定一个监听器
         */
        AlertDialog.Builder buidler = new AlertDialog.Builder(this);
        buidler.setTitle(getResources().getString(R.string.train_form_title));
        final String[] data = getResources().getStringArray(R.array.form);
        buidler.setSingleChoiceItems(data, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                form = data[which];
                tv_form.setText(data[which].trim());
                dialog.dismiss();
            }
        });
        buidler.show();
    }

    /**
     * 开始时间
     *
     * @param view
     */
    public void startTime(View view) {
        DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(TrainingActivity.this,
                new DateChooseWheelViewDialog.DateChooseInterface() {
                    @Override
                    public void getDateTime(String time, boolean longTimeChecked) {
                        startDate = time;
                        tv_timeStart.setText(time);
                    }
                });
        //        endDateChooseDialog.setTimePickerGone(true);
        endDateChooseDialog.setDateDialogTitle("开始时间");
        endDateChooseDialog.showDateChooseDialog();
    }

    /**
     * 结束时间
     *
     * @param view
     */
    public void endTime(View view) {
        DateChooseWheelViewDialog endDateChooseDialog = new DateChooseWheelViewDialog(TrainingActivity.this,
                new DateChooseWheelViewDialog.DateChooseInterface() {
                    @Override
                    public void getDateTime(String time, boolean longTimeChecked) {
                        endDates = time;
                        tv_endTime.setText(time);
                    }
                });
        //        endDateChooseDialog.setTimePickerGone(true);
        endDateChooseDialog.setDateDialogTitle("结束时间");
        endDateChooseDialog.showDateChooseDialog();
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
            if (data != null && data.getSerializableExtra("data") != null) {
                list = (List<ContactsEmployeeModel>) data.getSerializableExtra("data");
            } else {

            }
            StringBuilder name = new StringBuilder();
            StringBuilder employeeId = new StringBuilder();
            for (int i = 0; i < list.size(); i++) {
                name.append(list.get(i).getsEmployeeName() + "  ");
                employeeId.append(list.get(i).getsEmployeeID() + ",");
            }
            //            approvalID = "0280c9c5-870c-46cf-aa95-cdededc7d86c,88dd7959-cb2f-40c6-947a-4d6801fc4765";
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
     * back
     *
     * @param view
     */
    public void forBack(View view) {
        this.finish();
    }


}

