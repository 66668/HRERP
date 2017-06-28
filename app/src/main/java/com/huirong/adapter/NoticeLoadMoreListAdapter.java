package com.huirong.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseLoadMoreListAdapter;
import com.huirong.common.ImageLoadingConfig;
import com.huirong.model.NoticeListModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * 公告 适配
 *
 * @author
 */

public class NoticeLoadMoreListAdapter extends BaseLoadMoreListAdapter {
    private ImageLoader imgLoader;
    private DisplayImageOptions imgOptions;
    private Context context;

    public class WidgetHolder {
        public TextView tvTime;
        public TextView tvType;
        public TextView tvContent;
        public TextView tv_state;
    }

    public NoticeLoadMoreListAdapter(Context context, AdapterCallBack callBack) {
        super(context, callBack);
        this.context = context;
        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(context));
        imgOptions = ImageLoadingConfig.generateDisplayImageOptions(R.mipmap.ic_launcher);
    }

    @Override
    protected View inflateConvertView() {
        //一条记录的布局
        View view = inflater.inflate(R.layout.item_app_notification_notice_common, new LinearLayout(context), false);
        //该布局上的控件
        WidgetHolder holder = new WidgetHolder();
        holder.tvTime = (TextView) view.findViewById(R.id.tv_time);
        holder.tvType = (TextView) view.findViewById(R.id.tv_type);
        holder.tvContent = (TextView) view.findViewById(R.id.tv_content);
        holder.tv_state = (TextView) view.findViewById(R.id.tv_state);
        view.setTag(holder);
        return view;
    }

    @Override
    protected void initViewData(final int position, View convertView) {
        WidgetHolder holder = (WidgetHolder) convertView.getTag();//获取控件管理实例
        //获取一条信息
        NoticeListModel model = (NoticeListModel) entityList.get(position);
        holder.tvTime.setText(model.getCreateTime());
        holder.tvType.setText(model.getApplicationTitle());
        holder.tvContent.setText(model.getAbstract());
        holder.tv_state.setText("");
        //        if(model.getIsRead().contains("1")){
        //            holder.tv_state.setTextColor(context.getResources().getColor(R.color.green));
        //            holder.tv_state.setText("已读");
        //        }else{
        //            holder.tv_state.setTextColor(context.getResources().getColor(R.color.red));
        //            holder.tv_state.setText("未读");
        //        }

    }


    public void destroy() {
        imgLoader.clearMemoryCache();
        imgLoader.destroy();
    }

}
