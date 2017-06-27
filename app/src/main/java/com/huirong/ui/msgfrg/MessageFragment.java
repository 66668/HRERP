package com.huirong.ui.msgfrg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.common.MyException;
import com.huirong.db.sqlite.SQLiteScheduledb;
import com.huirong.dialog.Loading;
import com.huirong.helper.UserHelper;
import com.huirong.model.MessageFragmentListModel;
import com.huirong.model.NoticeListModel;
import com.huirong.model.NotificationListModel;
import com.huirong.model.ScheduleModel;
import com.huirong.model.workplan.WorkplanListModel;
import com.huirong.ui.appsfrg.NoticeListActivity;
import com.huirong.ui.appsfrg.NotificationListActivity;
import com.huirong.ui.appsfrg.ScheduleMainActivity;
import com.huirong.ui.appsfrg.childmodel.examination.ZOAplicationListActivity;
import com.huirong.ui.appsfrg.childmodel.examination.ZOApprovelListActivity;
import com.huirong.ui.appsfrg.childmodel.examination.ZOCopyListActivity;
import com.huirong.utils.LogUtils;
import com.huirong.utils.PageUtil;

import java.util.ArrayList;
import java.util.List;


/**
 * BottomBar 消息
 * Created by JackSong on 2016/10/9.
 */

public class MessageFragment extends com.huirong.base.BaseFragment {
    private static final String TAG = "MessageFragment";

    //变量
    com.huirong.db.sqlite.SQLiteScheduledb dao = null;


    //内容
    private TextView msg_content;
    private TextView notice_content;
    private TextView undo_content;
    private TextView schedule_content;
    private TextView mission_content;
    private TextView copy_content;
    private TextView workplan_content;

    //时间
    private TextView msg_time;
    private TextView notice_time;
    private TextView undo_time;
    private TextView schedule_time;
    private TextView mission_time;
    private TextView copy_time;
    private TextView workplan_time;

    //    //个数
    //    private TextView msg_number;
    //    private TextView notice_number;
    //    private TextView undo_number;
    //    private TextView schedule_number;
    //    private TextView mission_number;
    //    private TextView copy_number;
    //    private TextView workplan_number;

    //布局
    private RelativeLayout layout_notification;
    private RelativeLayout layout_notice;
    private RelativeLayout layout_undo;
    private RelativeLayout layout_schedule;
    private RelativeLayout layout_mission;
    private RelativeLayout layout_workplan;
    private RelativeLayout layout_copy;


    //日程
    private static final int GET_SCHEDULE_DATA = -39;
    private static final int NONE_SCHEDULE_DATA = -38;

    //公告
    private static final int GET_NOTICE_DATA = -37;//
    private static final int NONE_NOTICE_DATA = -36;//

    //通知
    private static final int GET_NOTIFICATION_DATA = -33;//
    private static final int NONE_NOTIFICATION_DATA = -32;//

    //其他通知
    private static final int GET_MESSAGE_DATA = -35;//
    private static final int NONE_MESSAGE_DATA = -34;//

    //工作计划 我收到的
    private static final int GET_WORKPLAN_DATA = -31;//
    private static final int NONE_WORKPLAN_DATA = -30;//


    //单例模式
    public static MessageFragment newInstance() {
        MessageFragment messageFragment = new MessageFragment();
        return messageFragment;
    }

    @Override
    public String getFragmentName() {
        return TAG;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //布局详细操作（可添加多个方法）
        initViews(view);
        initListener();
        getData();
    }

    //重新进入页面后，刷新数据
    @Override
    public void onResume() {
        super.onResume();
        getData();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    /**
     * 数据详细操作
     *
     * @param view
     */
    private void initViews(View view) {
        //消息
        msg_content = (TextView) view.findViewById(R.id.tv_msgContains);
        notice_content = (TextView) view.findViewById(R.id.tv_noticeContains);
        undo_content = (TextView) view.findViewById(R.id.tv_undoContains);
        schedule_content = (TextView) view.findViewById(R.id.tv_ScheduleContains);
        mission_content = (TextView) view.findViewById(R.id.tv_missionContains);
        copy_content = (TextView) view.findViewById(R.id.tv_copyContains);
        workplan_content = (TextView) view.findViewById(R.id.tv_workplanContains);

        //时间
        msg_time = (TextView) view.findViewById(R.id.tv_msgTime);
        notice_time = (TextView) view.findViewById(R.id.tv_noticeTime);
        undo_time = (TextView) view.findViewById(R.id.tv_undoTime);
        schedule_time = (TextView) view.findViewById(R.id.tv_scheduleTime);
        mission_time = (TextView) view.findViewById(R.id.tv_missionTime);
        copy_time = (TextView) view.findViewById(R.id.tv_copyTime);
        workplan_time = (TextView) view.findViewById(R.id.tv_workplanTime);

        //数量提醒
        //        msg_number = (TextView) view.findViewById(R.id.msg_number);
        //        notice_number = (TextView) view.findViewById(R.id.notice_number);
        //        undo_number = (TextView) view.findViewById(R.id.undo_number);
        //        schedule_number = (TextView) view.findViewById(R.id.schedule_number);
        //        mission_number = (TextView) view.findViewById(R.id.mission_number);
        //        copy_number = (TextView) view.findViewById(R.id.copy_number);
        //        workplan_number = (TextView) view.findViewById(R.id.workplan_number);

        layout_notification = (RelativeLayout) view.findViewById(R.id.layout_notification);
        layout_notice = (RelativeLayout) view.findViewById(R.id.layout_notice);
        layout_undo = (RelativeLayout) view.findViewById(R.id.layout_undo);
        layout_schedule = (RelativeLayout) view.findViewById(R.id.layout_schedule);
        layout_mission = (RelativeLayout) view.findViewById(R.id.layout_mission);
        layout_copy = (RelativeLayout) view.findViewById(R.id.layout_copy);
        layout_workplan = (RelativeLayout) view.findViewById(R.id.layout_workplan);
    }

    /**
     * 界面跳转
     */
    private void initListener() {
        //通知
        layout_notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NotificationListActivity.class);
                startActivity(intent);
            }
        });

        //公告
        layout_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), NoticeListActivity.class);
                startActivity(intent);
            }
        });

        //未审批
        layout_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZOApprovelListActivity.class);
                startActivity(intent);
            }
        });

        //日程
        layout_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ScheduleMainActivity.class);
                startActivity(intent);
            }
        });

        //会议
        layout_mission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZOAplicationListActivity.class);
                startActivity(intent);
            }
        });


        //已受理
        layout_workplan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZOAplicationListActivity.class);
                startActivity(intent);
            }
        });

        //抄送给我
        layout_copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ZOCopyListActivity.class);
                startActivity(intent);
            }
        });

    }

    /**
     * 访问服务端，获取数据
     */
    private void getData() {

        Loading.noDialogRun(getActivity(), new Runnable() {
            @Override
            public void run() {

                //日程表
                dao = new SQLiteScheduledb(getActivity(), UserHelper.getCurrentUser().getEmployeeID() + ".db");
                ArrayList<ScheduleModel> listSchedule = dao.getAllSchedule();
                int scheduleSize = -1;
                if (listSchedule != null) {
                    scheduleSize = listSchedule.size();
                    if (scheduleSize <= 0) {
                        handler.sendMessage(handler.obtainMessage(NONE_SCHEDULE_DATA));
                    } else {
                        handler.sendMessage(handler.obtainMessage(GET_SCHEDULE_DATA, scheduleSize));
                    }
                } else {
                    handler.sendMessage(handler.obtainMessage(NONE_SCHEDULE_DATA));
                }


                //公告
                try {
                    List<NoticeListModel> visitorModelList = UserHelper.GetAppNoticeList(
                            getActivity(),
                            "",//iMaxTime
                            "");

                    if (visitorModelList == null || visitorModelList.size() <= 0) {
                        handler.sendMessage(handler.obtainMessage(NONE_NOTICE_DATA, "没有最新公告"));
                    } else if (visitorModelList.size() > 0) {
                        handler.sendMessage(handler.obtainMessage(GET_NOTICE_DATA, visitorModelList));
                    }
                } catch (MyException e) {
                    Log.d("SJY", "公告异常= " + e.getMessage());
                    handler.sendMessage(handler.obtainMessage(NONE_NOTICE_DATA, "没有最新公告"));
                }

                //通知
                try {
                    List<NotificationListModel> visitorModelList = UserHelper.GetAppNotificationList(
                            getActivity(),
                            "",//iMaxTime
                            "");
                    if (visitorModelList == null) {
                        handler.sendMessage(handler.obtainMessage(NONE_NOTIFICATION_DATA, "没有最新通知"));
                    } else {
                        if (visitorModelList.size() <= 0) {
                            handler.sendMessage(handler.obtainMessage(NONE_NOTIFICATION_DATA, "没有最新通知"));
                        } else {
                            handler.sendMessage(handler.obtainMessage(GET_NOTIFICATION_DATA, visitorModelList));
                        }
                    }
                } catch (MyException e) {
                    Log.d("SJY", "通知异常= " + e.getMessage());
                    handler.sendMessage(handler.obtainMessage(NONE_NOTIFICATION_DATA, "没有最新通知"));
                }

                //其他消息
                try {
                    MessageFragmentListModel model = UserHelper.GetMassageFragmentList(
                            getActivity());
                    if (model == null) {
                        handler.sendMessage(handler.obtainMessage(NONE_MESSAGE_DATA, "没有最新通知"));
                    } else {
                        handler.sendMessage(handler.obtainMessage(GET_MESSAGE_DATA, model));
                    }
                } catch (MyException e) {
                    Log.d("SJY", "通知异常= " + e.toString());
                    handler.sendMessage(handler.obtainMessage(NONE_MESSAGE_DATA, "没有最新通知"));
                }

                //工作计划
                try {
                    List<WorkplanListModel> visitorModelList = UserHelper.GetWorkPlanList(
                            getActivity(),
                            "",//iMaxTime
                            "");

                    if (visitorModelList == null || visitorModelList.size() <= 0) {
                        handler.sendMessage(handler.obtainMessage(NONE_WORKPLAN_DATA, "没有最新通知"));
                    }

                    handler.sendMessage(handler.obtainMessage(GET_WORKPLAN_DATA, visitorModelList));
                } catch (MyException e) {
                    LogUtils.e("获取数据出错", e.toString());
                    handler.sendMessage(handler.obtainMessage(NONE_WORKPLAN_DATA, "没有最新通知"));
                }
            }
        });
    }

    /**
     * handler sendMessage的处理
     */
    @SuppressLint("HandlerLeak") // 确保类内部的handler不含有对外部类的隐式引用
    protected Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            // 调用下边的方法处理信息msg
            switch (msg.what) {
                case GET_MESSAGE_DATA://其他消息
                    MessageFragmentListModel msgmodel = (MessageFragmentListModel) msg.obj;
                    LogUtils.d("消息", msgmodel.toString());
                    showMessageList(msgmodel);
                    break;

                case GET_WORKPLAN_DATA://工作计划
                    List<WorkplanListModel> visitorModelList = (List<WorkplanListModel>) msg.obj;

                    break;

                case GET_NOTICE_DATA://公告
                    List<NoticeListModel> noticeList = (List<NoticeListModel>) msg.obj;
                    int noticeSize = splitNoticeDate(noticeList);
                    if (noticeSize == 0) {
                        handler.sendMessage(handler.obtainMessage(NONE_NOTICE_DATA, "没有最新公告"));

                    } else if (noticeSize > 0 && noticeSize <= 10) {

                        //内容
                        notice_content.setTextColor(getActivity().getResources().getColor(R.color.red));
                        notice_content.setText("您有 " + noticeSize + " 条公告未阅读");

                        //时间
                        notice_time.setVisibility(View.VISIBLE);
                        notice_time.setText(noticeList.get(0).getCreateTime());
                        //个数
                        //                        notice_number.setVisibility(View.VISIBLE);
                        //                        notice_number.setText("" + noticeSize);

                    } else if (noticeSize > 10) {
                        notice_content.setTextColor(getActivity().getResources().getColor(R.color.red));
                        notice_content.setText("您有 10+  条公告未阅读");
                        //时间
                        notice_time.setVisibility(View.VISIBLE);
                        notice_time.setText(noticeList.get(0).getCreateTime());

                        //个数
                        notice_time.setVisibility(View.VISIBLE);
                        //                        notice_number.setText("10+");
                    }

                    break;

                case GET_NOTIFICATION_DATA://通知
                    List<com.huirong.model.NotificationListModel> notificationList = (List<com.huirong.model.NotificationListModel>) msg.obj;
                    int notificationSize = splitNotificationDate(notificationList);
                    if (notificationSize == 0) {
                        handler.sendMessage(handler.obtainMessage(NONE_NOTIFICATION_DATA, "没有最新通知"));

                    } else if (notificationSize > 0 && notificationSize <= 10) {

                        //内容
                        msg_content.setTextColor(getActivity().getResources().getColor(R.color.red));
                        msg_content.setText("您有 " + notificationSize + " 条通知未阅读");

                        //时间
                        msg_time.setVisibility(View.VISIBLE);
                        msg_time.setText(notificationList.get(0).getCreateTime());

                        //个数
                        //                        msg_number.setVisibility(View.VISIBLE);
                        //                        msg_number.setText("" + notificationSize);

                    } else if (notificationSize > 10) {
                        msg_content.setTextColor(getActivity().getResources().getColor(R.color.red));
                        msg_content.setText("您有 10+  条通知未阅读");
                        //时间
                        msg_time.setVisibility(View.VISIBLE);
                        msg_time.setText(notificationList.get(0).getCreateTime());

                        //个数
                        //                        msg_number.setVisibility(View.VISIBLE);
                        //                        msg_number.setText("10+");
                    }

                    break;


                case GET_SCHEDULE_DATA://日程

                    int scheduleSize = (int) msg.obj;
                    if (scheduleSize > 0 && scheduleSize <= 10) {
                        //内容
                        schedule_content.setTextColor(getActivity().getResources().getColor(R.color.red));
                        schedule_content.setText("您有 " + scheduleSize + " 条日程要处理");
                        schedule_time.setText("");
                        //个数
                        //                        schedule_number.setText(scheduleSize + "");

                    } else if (scheduleSize > 10) {
                        //内容
                        schedule_content.setTextColor(getActivity().getResources().getColor(R.color.red));
                        schedule_content.setText("您有 10+ 条日程要处理");
                        schedule_time.setText("");
                        //个数
                        //                        schedule_number.setText("10+");
                    }
                    break;

                case NONE_NOTICE_DATA:

                    //内容
                    notice_content.setText((String) msg.obj);
                    notice_content.setTextColor(getActivity().getResources().getColor(R.color.textHintColor));

                    //时间
                    //                    notice_number.setVisibility(View.INVISIBLE);
                    //个数
                    notice_time.setVisibility(View.INVISIBLE);
                    break;
                case NONE_NOTIFICATION_DATA:

                    //内容
                    msg_content.setText((String) msg.obj);
                    msg_content.setTextColor(getActivity().getResources().getColor(R.color.textHintColor));
                    //时间
                    //                    msg_number.setVisibility(View.INVISIBLE);
                    //个数
                    msg_time.setVisibility(View.INVISIBLE);
                    break;


                case NONE_SCHEDULE_DATA:

                    //内容
                    schedule_content.setText("");
                    schedule_content.setTextColor(getActivity().getResources().getColor(R.color.textHintColor));

                    //时间
                    schedule_time.setText("");

                    //个数
                    //                    schedule_number.setVisibility(View.INVISIBLE);
                    break;
                case NONE_MESSAGE_DATA:
                    PageUtil.DisplayToast((String) msg.obj);
                    break;
                default:
                    break;
            }

            super.handleMessage(msg);
        }
    };

    private void showMessageList(MessageFragmentListModel model) {
        //待办事项 审批
        if (model.getApprovalCount() != null) {
            //            undo_number.setVisibility(View.VISIBLE);
            //            undo_number.setText(model.getApprovalCount());

            undo_content.setTextColor(getActivity().getResources().getColor(R.color.red));
            undo_content.setText("有" + model.getApprovalCount() + "条未办事项！");

            undo_time.setText(model.getApprovalCreateTime());

        } else {
            //            undo_number.setVisibility(View.INVISIBLE);
            undo_content.setText("");
            undo_time.setText("");
        }

        //抄送给我
        if (model.getApprovalCount1() != null) {
            //            copy_number.setVisibility(View.VISIBLE);
            //            copy_number.setText(model.getApprovalCount1());

            copy_content.setTextColor(getActivity().getResources().getColor(R.color.red));
            copy_content.setText("有" + model.getApprovalCount1() + "条抄送信息！");

            copy_time.setText(model.getApprovalCreateTime1());

        } else {
            //            copy_number.setVisibility(View.INVISIBLE);
            copy_content.setText("");
            copy_time.setText("");
        }

        //任务
        if (model.getMaintainCount() != null) {
            //            mission_number.setVisibility(View.VISIBLE);
            //            mission_number.setText(model.getMaintainCount());

            mission_content.setTextColor(getActivity().getResources().getColor(R.color.red));
            mission_content.setText("有" + model.getMaintainCount() + "条未阅读任务！");

            mission_time.setText(model.getMaintainCreateTime());

        } else {
            //            mission_number.setVisibility(View.INVISIBLE);
            mission_content.setText("");
            mission_time.setText("");
        }

        //工作计划
        if (model.getTaskScheduleCount() != null) {
            //            workplan_number.setVisibility(View.VISIBLE);
            //            workplan_number.setText(model.getTaskScheduleCount());

            workplan_content.setTextColor(getActivity().getResources().getColor(R.color.red));
            workplan_content.setText("有" + model.getTaskScheduleCount() + "条收到的工作计划！");

            workplan_time.setText(model.getTaskScheduleCreateTime());

        } else {
            //            workplan_number.setVisibility(View.INVISIBLE);
            workplan_content.setText("");
            workplan_time.setText("");
        }

    }

    //截取未读公告的list
    private int splitNoticeDate(List<NoticeListModel> list) {
        List<NoticeListModel> NoticeList = new ArrayList<NoticeListModel>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsRead().contains("0")) {
                NoticeList.add(list.get(i));
            }
        }
        int size = NoticeList.size();
        return size;

    }

    //获取通知! = 0的list
    private int splitNotificationDate(List<com.huirong.model.NotificationListModel> list) {
        List<com.huirong.model.NotificationListModel> NoticeList = new ArrayList<com.huirong.model.NotificationListModel>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsRead().contains("0")) {
                NoticeList.add(list.get(i));
            }
        }
        int size = NoticeList.size();
        return size;

    }


    //重写setMenuVisibility方法，不然会出现叠层的现象
    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }
}
