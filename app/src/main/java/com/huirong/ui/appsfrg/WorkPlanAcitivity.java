package com.huirong.ui.appsfrg;

import android.os.Bundle;
import android.widget.ListView;

import com.huirong.R;
import com.huirong.base.BaseActivity;
import com.huirong.inject.ViewInject;

/**
 * Created by JackSong on 2016/10/25.
 */

public class WorkPlanAcitivity extends BaseActivity {

    @ViewInject(id = R.id.list_workplan, click = "listDetail")
    ListView list_workplan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apps_workplan);
    }
//    public void listDetail(View view){
//        startActivity(WorkPlanDetailActivity.class);
//    }
}
