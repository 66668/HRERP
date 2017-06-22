package com.huirong.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseListAdapter;
import com.huirong.common.ImageLoadingConfig;
import com.huirong.model.mission.MissionListModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * 任务 适配
 *
 * @author
 */

public class MissionListAdapter extends BaseListAdapter {
    private ImageLoader imgLoader;
    private DisplayImageOptions imgOptions;

    public class WidgetHolder {
        public TextView tvTitle;
        public TextView tvTime;
        public ImageView img;
    }

    public MissionListAdapter(Context context) {
        super(context);
        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(context));
        imgOptions = ImageLoadingConfig.generateDisplayImageOptions(R.mipmap.ic_launcher);
    }

    @Override
    protected View inflateConvertView() {
        //一条记录的布局
        View view = inflater.inflate(R.layout.item_mission, null);
        //该布局上的控件
        WidgetHolder holder = new WidgetHolder();

        holder.tvTitle = (TextView) view.findViewById(R.id.tv_missionTitle);
        holder.tvTime = (TextView) view.findViewById(R.id.tv_time);
        holder.img = (ImageView) view.findViewById(R.id.img_status);
        view.setTag(holder);
        return view;
    }

    @Override
    protected void initViewData(final int position, View convertView) {
        WidgetHolder holder = (WidgetHolder) convertView.getTag();//获取控件管理实例
        //获取一条信息
        //?java.lang.ClassCastException: java.util.ArrayList cannot be cast to com.yvision.model.VisitorBModel
        MissionListModel model = (MissionListModel) entityList.get(position);

        holder.tvTitle.setText(model.getMisssiontheme());
        holder.tvTime.setText(model.getUpdetTime());

        //状态
        if (model.getIsYesNo() != null && TextUtils.isEmpty(model.getIsYesNo())) {//排除后台 null和""情况
            if (model.getIsYesNo().contains("已完成")) {
                holder.img.setImageResource(R.mipmap.ic_launcher);
            }
        }

    }

    public void destroy() {
        imgLoader.clearMemoryCache();
        imgLoader.destroy();
    }

}
