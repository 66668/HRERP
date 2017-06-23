package com.huirong.ui.appsfrg.childmodel.examination.applicationdetail;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.inject.ViewInject;
import com.huirong.model.applicationdetailmodel.NotificationAndNoticeModel;

/**
 * 申请 通知公告详情
 * Created by sjy on 2017/1/16.
 */

public class NotificationAndNoticeDetailAplActivity2 extends BaseActivity {
    //back
    @ViewInject(id = R.id.layout_back, click = "forBack")
    RelativeLayout layout_back;

    //
    @ViewInject(id = R.id.tv_title)
    TextView tv_title;

    //
    @ViewInject(id = R.id.tv_right)
    TextView tv_right;
    //
    @ViewInject(id = R.id.tv_content)
    TextView tv_content;

    //变量
    private NotificationAndNoticeModel notificationAndNoticeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_examination_notificationandnotice_content);
        tv_title.setText(getResources().getString(R.string.notificaitonAndNotice_content));
        tv_right.setText("");

        Bundle bundle = this.getIntent().getExtras();
        notificationAndNoticeModel = (NotificationAndNoticeModel) bundle.getSerializable("notificationAndNoticeModel");
        setShow();
    }

    private void setShow() {
        tv_content.setText(notificationAndNoticeModel.getAbstract());
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
