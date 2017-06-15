package com.huirong.ui.appsfrg.childmodel.vehiclereturn;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.application.MyApplication;
import com.huirong.base.BaseActivity;
import com.huirong.common.MyException;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.VehicleReturnModel;
import com.huirong.model.copydetailmodel.VehicleCopylModel;
import com.huirong.utils.PageUtil;

/**
 * 用车-未交车界面
 * Created by sjy on 2017/2/14.
 */

public class VehicleReturnUseUncompleteActivity extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;

    //交车
    @ViewInject(id = R.id.btn_returnVehicle, click = "forVehicleReturn")
    Button btn_returnVehicle;

    //抄送人
    @ViewInject(id = R.id.tv_copyPerson)
    TextView tv_copyPerson;

    //抄送时间
    @ViewInject(id = R.id.tv_copyTime)
    TextView tv_copyTime;

    //目的地
    @ViewInject(id = R.id.tv_Destination)
    TextView tv_Destination;

    //计划用车时间
    @ViewInject(id = R.id.tv_PlanBorrowTime)
    TextView tv_PlanBorrowTime;

    //计划交车时间
    @ViewInject(id = R.id.tv_PlanReturnTime)
    TextView tv_PlanReturnTime;

    //用途
    @ViewInject(id = R.id.tv_purpose)
    TextView tv_purpose;

    //申请备注
    @ViewInject(id = R.id.tv_other)
    TextView tv_other;

    //变量
    private VehicleReturnModel model;
    //常量
    private static final int POST_SUCCESS = 11;
    private static final int POST_FAILED = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_vehicle_return_use);
        tv_title.setText(getResources().getString(R.string.vehicleRe));
        tv_right.setText("");

        //获取交车记录界面跳转值
        Bundle bundle = this.getIntent().getExtras();
        model = (VehicleReturnModel) bundle.getSerializable("VehicleReturnModel");

        getData(model);
        //多界面管理
        MyApplication.getInstance().addACT(this);

    }

    private void setShow(VehicleCopylModel model) {

        tv_copyPerson.setText(model.getEmployeeName());
        tv_copyTime.setText(model.getCopyTime());
        tv_Destination.setText(model.getDestination());
        tv_PlanBorrowTime.setText(model.getPlanBorrowTime());
        tv_PlanReturnTime.setText(model.getPlanReturnTime());
        tv_purpose.setText(model.getPurpose());
        tv_other.setText(model.getRemark());


    }

    private void getData(final VehicleReturnModel model) {
        //
        Loading.run(this, new Runnable() {
            @Override
            public void run() {//泛型
                try {
                    VehicleCopylModel vehicleCopylModel = new UserHelper<>(VehicleCopylModel.class)
                            .getVehicleReturnDetail(VehicleReturnUseUncompleteActivity.this
                                    , model.getApplicationID()
                                    , model.getApplicationType());
                    sendMessage(POST_SUCCESS, vehicleCopylModel);
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
                VehicleCopylModel vehicleCopylModel = (VehicleCopylModel) msg.obj;
                Log.d("SJY", "展示数据");
                setShow(vehicleCopylModel);
                break;
            case POST_FAILED:
                PageUtil.DisplayToast((String) msg.obj);
                break;
        }
    }


    public void forVehicleReturn(View view) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("VehicleReturnModel", model);
        startActivity(VehicleReturnUseToCompleteActivity.class,bundle);

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
