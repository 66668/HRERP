package com.huirong.ui.appsfrg;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.huirong.R;
import com.huirong.adapter.AppsMenuAdapter;
import com.huirong.adapter.AppsViewPagerAdapter;
import com.huirong.base.BaseFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * BottomBar 应用
 */

public class AppsFragment extends BaseFragment {
    private static final String TAG = "AppsFragment";
    //    private LinePageIndicator mIndicator;//横条

    //单例模式
    public static AppsFragment newInstance() {
        AppsFragment appsFragment = new AppsFragment();
        return appsFragment;
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
        View view = inflater.inflate(R.layout.fragment_apps, container, false);
        initView(view);
        return view;
    }

    //界面详细
    public void initView(View view) {
        ViewPager  viewPager = (ViewPager) view.findViewById(R.id.myviewpager);

        //为按钮添加数据
        final List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("name", "工作计划");
        map1.put("icon", R.mipmap.app_conference);
        list.add(map1);


        HashMap<String, Object> map2 = new HashMap<String, Object>();
        map2.put("name", "任务");
        map2.put("icon", R.mipmap.app_performancemg);
        list.add(map2);

        HashMap<String, Object> map3 = new HashMap<String, Object>();
        map3.put("name", "考勤");
        map3.put("icon", R.mipmap.app_mapattend);
        list.add(map3);

        HashMap<String, Object> map4 = new HashMap<String, Object>();
        map4.put("name", "公告");
        map4.put("icon", R.mipmap.app_notice);
        list.add(map4);
        
        HashMap<String, Object> map5 = new HashMap<String, Object>();
        map5.put("name", "审批");
        map5.put("icon", R.mipmap.app_examination);
        list.add(map5);

        HashMap<String, Object> map6 = new HashMap<String, Object>();
        map6.put("name", "通知");
        map6.put("icon", R.mipmap.app_notification);
        list.add(map6);


        HashMap<String, Object> map7 = new HashMap<String, Object>();
        map7.put("name", "费用申请");
        map7.put("icon", R.mipmap.app_finance);
        list.add(map7);


        HashMap<String, Object> map8 = new HashMap<String, Object>();
        map8.put("name", "日程");
        map8.put("icon", R.mipmap.app_schedule);
        list.add(map8);

//        HashMap<String, Object> map9 = new HashMap<String, Object>();
//        map9.put("name", "采购领用");
//        map9.put("icon", R.mipmap.app_procure);
//        list.add(map9);
//
//        HashMap<String, Object> map10 = new HashMap<String, Object>();
//        map10.put("name", "交车");
//        map10.put("icon", R.mipmap.vehiclereturn);
//        list.add(map10);

//        HashMap<String, Object> map11 = new HashMap<String, Object>();
//        map11.put("name", "会议");
//        map11.put("icon", R.mipmap.app_conference);
//        list.add(map11);
//
//        HashMap<String, Object> map12 = new HashMap<String, Object>();
//        map12.put("name", "采购领用");
//        map12.put("icon", R.mipmap.app_performancemg);
//        list.add(map12);

        final int PageCount = 1;//分页
        ArrayList<GridView> array = new ArrayList<GridView>();
        for (int i = 0; i < PageCount; i++) {
            GridView appPage = new GridView(getActivity());
            //详细界面分析
            appPage.setAdapter(new AppsMenuAdapter(getActivity(), list, i));
            appPage.setNumColumns(3);
            appPage.setVerticalSpacing(80);
            array.add(appPage);
            viewPager.setAdapter(new AppsViewPagerAdapter(getActivity(), array));

            // 横条使用
            // mIndicator = (LinePageIndicator)view.findViewById(R.id.indicator);
            // mIndicator.setViewPager(viewPager);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public boolean hasMultiFragment() {
        return false;
    }

    @Override
    protected String setFragmentName() {
        return null;
    }

    //重写setMenuVisibility方法，不然会出现叠层的现象
    @Override
    public void setMenuVisibility(boolean menuVisible) {
        super.setMenuVisibility(menuVisible);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisible ? View.VISIBLE : View.GONE);
        }
    }

}
