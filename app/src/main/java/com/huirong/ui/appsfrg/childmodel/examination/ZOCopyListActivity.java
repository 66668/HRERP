package com.huirong.ui.appsfrg.childmodel.examination;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.adapter.ZOCopyLoadMoreListAdapter;
import com.huirong.base.BaseActivity;
import com.huirong.base.BaseLoadMoreListAdapter;
import com.huirong.common.MyException;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.inject.ViewInject;
import com.huirong.model.MyCopyModel;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.BeawayDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.BookTicketsDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.DimissionDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.FinancialLoanDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.FinancialPayDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.FinancialReimburseDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.LeaveDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.PositionReplaceDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.ProcurementDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.RecruitmentDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.SignetDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.TakeDaysOffDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.TrainingDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.VehicleDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.VehicleMaintainDetailCopyActivity;
import com.huirong.ui.appsfrg.childmodel.examination.copydetail.WorkOverTimeDetailCopyActivity;
import com.huirong.utils.PageUtil;
import com.huirong.widget.RefreshListView;

import java.util.ArrayList;
import java.util.List;


/**
 * 我的抄送
 * Created by sjy on 2016/12/2.
 */

public class ZOCopyListActivity extends BaseActivity implements RefreshListView.IReflashListener {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;

    @ViewInject(id = R.id.myapprovalList)
    RefreshListView myListView;

    private ZOCopyLoadMoreListAdapter vAdapter;//记录适配
    private boolean ifLoading = false;//标记
    private int pageSize = 20;
    private ArrayList<MyCopyModel> list = null;
    private String IMaxtime = null;
    private String IMinTime = null;

    //常量
    private static final int GET_MORE_DATA = -38;//上拉加载
    private static final int GET_NEW_DATA = -37;//上拉加载
    private static final int GET_REFRESH_DATA = -36;//上拉加载
    private static final int GET_NONE_NEWDATA = -35;//没有新数据

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_list);
        tv_right.setText("");
        tv_title.setText(getResources().getString(R.string.MyCopyto));

        myListView.setInterFace(this);//下拉刷新监听
        vAdapter = new ZOCopyLoadMoreListAdapter(ZOCopyListActivity.this, adapterCallBack);// 上拉加载
        myListView.setAdapter(vAdapter);
        initListener();

        getNewData();
    }

    private void initListener() {
        // 点击一条记录后，跳转到登记时详细的信息
        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int headerViewsCount = myListView.getHeaderViewsCount();//得到header的总数量
                int newPosition = position - headerViewsCount;//得到新的修正后的position

                MyCopyModel myApprovalModel = (MyCopyModel) vAdapter.getItem(newPosition);//
                Log.d("SJY", "copyListActivity--MyCopyModel==null?" + (myApprovalModel == null));
                String type = myApprovalModel.getApplicationType();//申请类型

                //                跳转调用
                myApprovalTransfer(type, myApprovalModel);
            }
        });
    }

    public void getNewData() {
        Log.d("SJY", "ZOCopyListActivity--getNewData");
        Loading.run(ZOCopyListActivity.this, new Runnable() {
            @Override
            public void run() {
                ifLoading = true;//
                String storeID = UserHelper.getCurrentUser().getStoreID();
                try {
                    List<MyCopyModel> visitorModelList = UserHelper.getMyCopyList(
                            ZOCopyListActivity.this,
                            "",//iMaxTime
                            "");

                    if (visitorModelList == null) {
                        vAdapter.IsEnd = true;
                    } else if (visitorModelList.size() < pageSize) {
                        vAdapter.IsEnd = true;
                    }


                    sendMessage(GET_NEW_DATA, visitorModelList);
                } catch (MyException e) {
                    sendMessage(GET_NONE_NEWDATA, e.getMessage());
                }
            }
        });
    }

    //RefreshListView.IReflashListener接口 下拉刷新
    @Override
    public void onRefresh() {
        Loading.run(ZOCopyListActivity.this, new Runnable() {

            @Override
            public void run() {
                ifLoading = true;//
                try {
                    List<MyCopyModel> visitorModelList = UserHelper.getMyCopyList(
                            ZOCopyListActivity.this,
                            IMaxtime,//iMaxTime
                            "");

                    Log.d("SJY", "loadMore--min=" + IMaxtime);
                    if (visitorModelList == null) {
                        vAdapter.IsEnd = true;
                    } else if (visitorModelList.size() < pageSize) {
                        vAdapter.IsEnd = true;
                    }


                    sendMessage(GET_REFRESH_DATA, visitorModelList);

                } catch (MyException e) {
                    sendMessage(GET_NONE_NEWDATA, e.getMessage());
                }
            }

        });
    }

    // 上拉加载
    BaseLoadMoreListAdapter.AdapterCallBack adapterCallBack = new BaseLoadMoreListAdapter.AdapterCallBack() {
        @Override
        public void loadMore() {

            if (ifLoading) {
                return;
            }

            Loading.run(ZOCopyListActivity.this, new Runnable() {

                @Override
                public void run() {

                    ifLoading = true;//
                    try {
                        List<MyCopyModel> visitorModelList = UserHelper.getMyCopyList(
                                ZOCopyListActivity.this,
                                "",//iMaxTime
                                IMinTime);

                        Log.d("SJY", "loadMore--min=" + IMaxtime);
                        if (visitorModelList == null) {
                            vAdapter.IsEnd = true;
                        } else if (visitorModelList.size() < pageSize) {
                            vAdapter.IsEnd = true;
                        }
                        sendMessage(GET_MORE_DATA, visitorModelList);

                    } catch (MyException e) {
                        sendMessage(GET_NONE_NEWDATA, e.getMessage());
                    }
                }
            });

        }
    };

    @Override
    protected void handleMessage(Message msg) {
        switch (msg.what) {
            case GET_NEW_DATA://进入页面加载最新
                // 数据显示
                list = (ArrayList<MyCopyModel>) msg.obj;
                vAdapter.setEntityList(list);
                //数据处理，获取iLastUpdateTime参数方便后续上拉/下拉使用
                setIMinTime(list);
                setIMaxTime(list);
                myListView.reflashComplete();
                ifLoading = false;
                break;
            case GET_REFRESH_DATA://刷新
                list = (ArrayList<MyCopyModel>) msg.obj;
                vAdapter.insertEntityList(list);
                //数据处理/只存最大值,做刷新新数据使用
                setIMaxTime(list);
                ifLoading = false;
                break;

            case GET_MORE_DATA://加载
                list = (ArrayList<MyCopyModel>) msg.obj;
                vAdapter.addEntityList(list);
                //数据处理，只存最小值
                setIMinTime(list);
                ifLoading = false;
                break;

            case GET_NONE_NEWDATA://没有获取新数据
                //                vAdapter.insertEntityList(null);
                sendToastMessage((String) msg.obj);
                myListView.reflashComplete();
                ifLoading = false;
                break;

            default:
                break;
        }
        super.handleMessage(msg);
    }

    public void setIMaxTime(ArrayList<MyCopyModel> list) {
        IMaxtime = list.get(0).getCreateTime();
    }

    public void setIMinTime(ArrayList<MyCopyModel> list) {
        IMinTime = list.get(list.size() - 1).getCreateTime();
    }

    /**
     * 申请跳转详细
     */

    private void myApprovalTransfer(String type, MyCopyModel model) {

        Bundle bundle = new Bundle();
        bundle.putSerializable("MyCopyModel", model);
        switch (type) {

            case "请假申请"://01
                startActivity(LeaveDetailCopyActivity.class, bundle);
                ;
                break;

            case "出差申请"://02
                startActivity(BeawayDetailCopyActivity.class, bundle);
                break;

            case "用车申请"://03
                startActivity(VehicleDetailCopyActivity.class, bundle);
                ;
                break;

            case "车辆维保"://04
                startActivity(VehicleMaintainDetailCopyActivity.class, bundle);
                break;

            case "加班申请"://05
                startActivity(WorkOverTimeDetailCopyActivity.class, bundle);
                break;

            case "财务申请"://06
                //根据type决定跳转到具体界面
                if (model.getApplicationTitle().contains("借款")) {
                    startActivity(FinancialLoanDetailCopyActivity.class, bundle);
                } else if (model.getApplicationTitle().contains("付款")) {
                    startActivity(FinancialPayDetailCopyActivity.class, bundle);
                } else if (model.getApplicationTitle().contains("报销")) {
                    startActivity(FinancialReimburseDetailCopyActivity.class, bundle);
                } else {
                    PageUtil.DisplayToast("error!");
                }
                break;


            case "离职申请"://07
                startActivity(DimissionDetailCopyActivity.class, bundle);
                break;

            case "订票申请"://08
                startActivity(BookTicketsDetailCopyActivity.class, bundle);
                break;

            case "调休申请"://09
                startActivity(TakeDaysOffDetailCopyActivity.class, bundle);
                break;

            case "印章申请"://10
                startActivity(SignetDetailCopyActivity.class, bundle);
                break;

            case "培训申请"://11
                startActivity(TrainingDetailCopyActivity.class, bundle);
                break;

            case "调动申请"://12
                startActivity(PositionReplaceDetailCopyActivity.class, bundle);
                break;

            case "招聘申请"://13
                startActivity(RecruitmentDetailCopyActivity.class, bundle);
                break;

            case "采购申请"://14
                startActivity(ProcurementDetailCopyActivity.class, bundle);
                break;


//            case "借阅申请"://06
//                startActivity(BorrowDetailCopyActivity.class, bundle);
//                break;
//            case "调薪申请"://07
//                startActivity(SalaryadjustDetailCopyActivity.class, bundle);
//                break;
//            case "通知公告申请"://13
//                startActivity(NotificationAndNoticeDetailCopyActivity.class, bundle);
//                break;
//            case "办公室申请"://14
//                startActivity(OfficeDetailCopyActivity.class, bundle);
//                break;
//            case "领用申请"://15
//                startActivity(ReceiveDetailCopyActivity.class, bundle);
//                break;
//            case "合同文件申请"://16
//                startActivity(ContractFileDetailCopyActivity.class, bundle);
//                break;
//            case "复试申请"://18
//                startActivity(RetestDetailCopyActivity.class, bundle);
//                break;
//            case "会议申请"://19
//                startActivity(ConferenceDetailCopyActivity.class, bundle);
//                break;
        }
    }

    /**
     * @param v
     */

    public void forBack(View v) {
        this.finish();
    }
}
