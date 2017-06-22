package com.huirong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.application.MyApplication;
import com.huirong.model.ScheduleModel;
import com.huirong.common.calendarcommon.CalendarTpyeArray;

import java.util.ArrayList;


/**
 * 日程表 适配
 *
 * @author
 */

public class ScheduleListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<ScheduleModel> list;

    public ScheduleListAdapter(Context context, ArrayList<ScheduleModel> list) {
        super();
        this.context = context;
        this.list = list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        WidgetHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(MyApplication.getInstance()).inflate(R.layout.item_apps_schedule, new RelativeLayout(context), false);
            //该布局上的控件
            holder = new WidgetHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tvType = (TextView) convertView.findViewById(R.id.tv_type);
            convertView.setTag(holder);
        } else {
            holder = (WidgetHolder) convertView.getTag();
        }
        ScheduleModel model =  list.get(position);

        holder.tvType.setText("" + model.getScheduleDate());//提醒

        holder.tvTitle.setText("" + CalendarTpyeArray.sch_type[model.getScheduleTypeID()]);//日程类型
        return convertView;
    }

    public class WidgetHolder {
        public TextView tvTitle;//日程类型
        public TextView tvType;//提醒次数
    }


}
