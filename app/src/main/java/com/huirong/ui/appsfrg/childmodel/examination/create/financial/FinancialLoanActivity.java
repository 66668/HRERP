package com.huirong.ui.appsfrg.childmodel.examination.create.financial;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.application.MyApplication;
import com.huirong.base.BaseActivity;
import com.huirong.common.MyException;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.ContactsEmployeeModel;
import com.huirong.ui.appsfrg.childmodel.examination.ZOAplicationListActivity;
import com.huirong.ui.contractsfrg.ContactsSelectActivity;
import com.huirong.utils.CameraGalleryUtils;
import com.huirong.utils.ImageUtils;
import com.huirong.utils.LogUtils;
import com.huirong.utils.PageUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 借款申请
 * Created by sjy on 2016/12/2.
 */

public class FinancialLoanActivity extends BaseActivity implements CameraGalleryUtils.ChoosePicCallBack {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right, click = "forCommit")
    TextView forCommit;


    //方式
    @ViewInject(id = R.id.layout_type, click = "loanType")
    LinearLayout layout_type;
    @ViewInject(id = R.id.tv_type)
    TextView tv_type;

    //用途
    @ViewInject(id = R.id.et_use)
    EditText et_use;

    //金额
    @ViewInject(id = R.id.et_Fee)
    EditText et_Fee;

    //备注
    @ViewInject(id = R.id.et_Reason)
    EditText et_Reason;


    //添加审批人
    @ViewInject(id = R.id.AddApprover, click = "forAddApprover")
    RelativeLayout AddApprover;

    //审批人
    @ViewInject(id = R.id.tv_Requester)
    TextView tv_Requester;

    //添加图片
    @ViewInject(id = R.id.addPicture, click = "ForAddPicture")
    RelativeLayout addPicture;

    //图片1
    @ViewInject(id = R.id.layout_img_01, click = "showDetailImg")
    RelativeLayout layout_img_01;
    @ViewInject(id = R.id.img_01)
    ImageView img_01;

    //图片2
    @ViewInject(id = R.id.layout_img_02, click = "showDetailImg")
    RelativeLayout layout_img_02;
    @ViewInject(id = R.id.img_02)
    ImageView img_02;

    //图片3
    @ViewInject(id = R.id.layout_img_03, click = "showDetailImg")
    RelativeLayout layout_img_03;
    @ViewInject(id = R.id.img_03)
    ImageView img_03;
    //常量
    public static final int POST_SUCCESS = 21;
    public static final int POST_FAILED = 22;
    public static final int PIC_SHOW = 17;//图片展示
    //变量
    private String type;
    private String use;
    private String approvalID = "";
    private String reason = "";
    private String fee = "";

    private CameraGalleryUtils cameraGalleryUtils;// 头像上传工具
    private String picPath;
    private File filePicPath;
    private List<Bitmap> listPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_financial_loan);

        tv_title.setText(getResources().getString(R.string.financial_loan));
        cameraGalleryUtils = new CameraGalleryUtils(this, this);
        listPic = new ArrayList<>();
        //多页面finish使用
        MyApplication.getInstance().addACT(this);

    }

    /**
     * 数据提交
     *
     * @param view
     */
    public void forCommit(View view) {
        use = et_use.getText().toString().trim();
        fee = et_Fee.getText().toString().trim();
        reason = et_Reason.getText().toString();
        if (TextUtils.isEmpty(type)) {
            PageUtil.DisplayToast("借款方式不能为空");
            return;
        }

        if (TextUtils.isEmpty(use)) {
            PageUtil.DisplayToast("用途不能为空");
            return;
        }
        if (TextUtils.isEmpty(fee)) {
            PageUtil.DisplayToast("金额不能为空");
            return;
        }

        if (TextUtils.isEmpty(reason)) {
            PageUtil.DisplayToast("借款事由不能为空");
            return;
        }

        if (TextUtils.isEmpty(approvalID)) {
            PageUtil.DisplayToast("审批人不能为s空");
            return;
        }

        Loading.run(FinancialLoanActivity.this, new Runnable() {
            @Override
            public void run() {
                try {

                    JSONObject js = new JSONObject();

                    //参数
                    js.put("Way", type);
                    js.put("Type", getResources().getString(R.string.financial_loan_apl));//借款
                    js.put("Useage", use);
                    js.put("Fee", fee);
                    js.put("Remark", reason);
                    js.put("ApprovalIDList", approvalID);

                    String resultMessage = UserHelper.LRApplicationPost(FinancialLoanActivity.this, js, filePicPath);

                    LogUtils.d("借款申请", "failed=" + resultMessage);
                    sendMessage(POST_SUCCESS, resultMessage);
                } catch (MyException e) {
                    LogUtils.d("借款申请", "failed=" + e.getMessage());
                    sendMessage(POST_FAILED, e.getMessage());

                } catch (JSONException e) {
                    e.printStackTrace();
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
                //多页面finish使用
                MyApplication.getInstance().closeACT();
                break;
            case POST_FAILED:
                PageUtil.DisplayToast((String) msg.obj);
                break;
            case PIC_SHOW://添加图片后，展示
                List<Bitmap> listpic = (List<Bitmap>) msg.obj;

                if (listpic.size() == 3) {
                    img_01.setVisibility(View.VISIBLE);
                    img_02.setVisibility(View.VISIBLE);
                    img_03.setVisibility(View.VISIBLE);

                    img_01.setImageBitmap(listpic.get(0));
                    img_02.setImageBitmap(listpic.get(1));
                    img_03.setImageBitmap(listpic.get(2));
                }
                if (listpic.size() == 2) {
                    img_01.setVisibility(View.VISIBLE);
                    img_02.setVisibility(View.VISIBLE);
                    img_03.setVisibility(View.INVISIBLE);

                    img_01.setImageBitmap(listpic.get(0));

                    img_02.setImageBitmap(listpic.get(1));

                }

                if (listpic.size() == 1) {
                    img_01.setVisibility(View.VISIBLE);
                    img_02.setVisibility(View.INVISIBLE);
                    img_03.setVisibility(View.INVISIBLE);

                    img_01.setImageBitmap(listpic.get(0));
                }
                break;
        }
    }

    /**
     * 添加图片
     */
    public void ForAddPicture(View view) {
        if (listPic.size() >= 1) {
            PageUtil.DisplayToast("最多添加1张图片");
            return;
        }
        cameraGalleryUtils.showChoosePhotoDialog(CameraGalleryUtils.IMG_TYPE_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //添加审批人 回调处理 待修改 0220
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
            //            approvalID = "0280c9c5-870c-46cf-aa95-cdededc7d86c,88dd7959-cb2f-40c6-947a-4d6801fc4765";
            approvalID = getApprovalID(employeeId.toString());
            LogUtils.d("借款申请", "approvalID=" + approvalID);
            tv_Requester.setText(name);
        }
        //相册
        cameraGalleryUtils.onActivityResultAction(requestCode, resultCode, data);
    }


    /**
     * 添加审批人
     *
     * @param view
     */
    public void forAddApprover(View view) {
        myStartForResult(ContactsSelectActivity.class, 0);
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
     * 方式
     *
     * @param view
     */
    public void loanType(View view) {
        //    设置一个单项选择下拉框
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
         * 第三个参数给每一个单选项绑定一个监听器
         */
        AlertDialog.Builder buidler = new AlertDialog.Builder(this);
        buidler.setTitle(getResources().getString(R.string.financial_loan_type));
        final String[] data = getResources().getStringArray(R.array.loanType);
        buidler.setSingleChoiceItems(data, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                type = data[which];
                tv_type.setText(data[which].trim());
                dialog.dismiss();
            }
        });
        buidler.show();
    }

    /**
     * back
     *
     * @param view
     */

    public void forBack(View view) {
        this.finish();
    }

    @Override
    public void updateAvatarSuccess(int updateType, String picpath, String avatarBase64) {
        picPath = picpath;

        Bitmap bitmap = BitmapFactory.decodeFile(picPath);
        Uri uri = ImageUtils.savePicture(this, bitmap);
        filePicPath = new File(ImageUtils.getImageAbsolutePath(this, uri));

        listPic.add(bitmap);
        sendMessage(PIC_SHOW, listPic);
    }

    @Override
    public void updateAvatarFailed(int updateType) {

    }

    @Override
    public void cancel() {

    }
}
