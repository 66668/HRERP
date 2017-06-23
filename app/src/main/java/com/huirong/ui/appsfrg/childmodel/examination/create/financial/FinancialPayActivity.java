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
 * 付款申请
 * Created by sjy on 2016/12/2.
 */

public class FinancialPayActivity extends BaseActivity implements CameraGalleryUtils.ChoosePicCallBack {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right, click = "forCommit")
    TextView forCommit;

    //付款方式
    @ViewInject(id = R.id.layout_payWay, click = "useType")
    LinearLayout layout_payWay;
    @ViewInject(id = R.id.tv_payStyle)
    TextView tv_payStyle;

    //收款单位
    @ViewInject(id = R.id.et_offical)
    EditText et_offical;

    //账号
    @ViewInject(id = R.id.et_account)
    EditText et_account;

    //开户行
    @ViewInject(id = R.id.et_bank)
    EditText et_bank;

    //金额
    @ViewInject(id = R.id.et_Fee)
    EditText et_Fee;

    //备注
    @ViewInject(id = R.id.et_Remark)
    EditText et_remark;

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

    //添加审批人
    @ViewInject(id = R.id.AddApprover, click = "forAddApprover")
    RelativeLayout AddApprover;

    //审批人
    @ViewInject(id = R.id.tv_Requester)
    TextView tv_Requester;

    //常量
    public static final int POST_SUCCESS = 21;
    public static final int POST_FAILED = 22;
    public static final int PIC_SHOW = 17;//图片展示

    //变量
    private String approvalID = "";
    private String remark = "";
    private String fee = "";
    private String CollectionUnit = "";//收款单位
    private String BankAccount = "";//银行
    private String AccountNumber = "";//账号
    private String Way = "";//

    private CameraGalleryUtils cameraGalleryUtils;// 头像上传工具
    private File filePicPath;
    private List<Bitmap> listPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_financial_pay);
        tv_title.setText(getResources().getString(R.string.financial_pay));
        cameraGalleryUtils = new CameraGalleryUtils(this, this);
        listPic = new ArrayList<>();
        //多页面finish使用
        MyApplication.getInstance().addACT(this);
    }

    public void forCommit(View view) {
        fee = et_Fee.getText().toString().trim();
        remark = et_remark.getText().toString();
        CollectionUnit = et_offical.getText().toString();
        AccountNumber  =et_account.getText().toString();
        BankAccount = et_bank.getText().toString();

        if (TextUtils.isEmpty(Way)) {
            PageUtil.DisplayToast(getResources().getString(R.string.financial_pay_wayNUll));
            return;
        }
        if (TextUtils.isEmpty(CollectionUnit)) {
            PageUtil.DisplayToast(getResources().getString(R.string.financial_pay_officeNUll));
            return;
        }
        if (TextUtils.isEmpty(AccountNumber)) {
            PageUtil.DisplayToast(getResources().getString(R.string.financial_pay_acountNull));
            return;
        }
        if (TextUtils.isEmpty(BankAccount)) {
            PageUtil.DisplayToast(getResources().getString(R.string.financial_pay_bankNull));
            return;
        }
        if (TextUtils.isEmpty(fee)) {
            PageUtil.DisplayToast(getResources().getString(R.string.financial_reimburse_feeNull));
            return;
        }
        if (TextUtils.isEmpty(approvalID)) {
            PageUtil.DisplayToast(getResources().getString(R.string.financial_reimburse_RequesterNull));
            return;
        }

        Loading.run(FinancialPayActivity.this, new Runnable() {
            @Override
            public void run() {
                try {
                    JSONObject js = new JSONObject();

                    //参数
                    js.put("Type", getResources().getString(R.string.financial_pay_apl));
                    js.put("Fee", fee);
                    js.put("BankAccount", BankAccount);
                    js.put("CollectionUnit", CollectionUnit);
                    js.put("AccountNumber", AccountNumber);
                    js.put("Paymentmethod", Way);
                    js.put("Remark", remark);
                    js.put("ApprovalIDList", approvalID);

                    UserHelper.LRApplicationPost(FinancialPayActivity.this, js,filePicPath);
                    sendMessage(POST_SUCCESS);
                } catch (MyException e) {
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

    private void clear(){
        tv_payStyle.setText("");
        et_offical.setText("");
        et_account.setText("");
        et_bank.setText("");
        et_Fee.setText("");
        et_remark.setText("");
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
     * 付款方式
     */
    public void useType(View view) {
        //    设置一个单项选择下拉框
        /**
         * 第一个参数指定我们要显示的一组下拉单选框的数据集合
         * 第二个参数代表索引，指定默认哪一个单选框被勾选上，1表示默认'女' 会被勾选上
         * 第三个参数给每一个单选项绑定一个监听器
         */
        AlertDialog.Builder buidler = new AlertDialog.Builder(this);
        buidler.setTitle(getResources().getString(R.string.financial_pay_style));
        final String[] data = getResources().getStringArray(R.array.financialPayWay);
        buidler.setSingleChoiceItems(data, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Way = data[which];
                tv_payStyle.setText(data[which].trim());
                dialog.dismiss();
            }
        });
        buidler.show();
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
    public void updateAvatarSuccess(int updateType, String picpath, String avatarBase64) {

        Bitmap bitmap = BitmapFactory.decodeFile(picpath);
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
    /**
     * back
     *
     * @param view
     */

    public void forBack(View view) {
        this.finish();
    }
}
