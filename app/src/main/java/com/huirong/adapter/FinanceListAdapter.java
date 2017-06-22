package com.huirong.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.huirong.R;
import com.huirong.base.BaseListAdapter;
import com.huirong.common.ImageLoadingConfig;
import com.huirong.model.AppFinancialModel;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * 应用 费用 适配
 *
 * @author
 */

public class FinanceListAdapter extends BaseListAdapter {
    private ImageLoader imgLoader;
    private DisplayImageOptions imgOptions;
    private Context context;


    public class WidgetHolder {
        public TextView tv_finaceTitle;
        public TextView tvTime;
    }

    public FinanceListAdapter(Context context) {
        super(context);
        this.context = context;
        imgLoader = ImageLoader.getInstance();
        imgLoader.init(ImageLoaderConfiguration.createDefault(context));
        imgOptions = ImageLoadingConfig.generateDisplayImageOptions(R.mipmap.ic_launcher);
    }

    @Override
    protected View inflateConvertView() {
        //一条记录的布局
        View view = inflater.inflate(R.layout.item_finance,  new LinearLayout(context), false);
        //该布局上的控件
        WidgetHolder holder = new WidgetHolder();
        holder.tv_finaceTitle = (TextView) view.findViewById(R.id.tv_finace_title);
        holder.tvTime = (TextView) view.findViewById(R.id.tv_time);
        view.setTag(holder);
        return view;
    }

    @Override
    protected void initViewData(final int position, View convertView) {
        WidgetHolder holder = (WidgetHolder) convertView.getTag();//获取控件管理实例

        AppFinancialModel model = (AppFinancialModel) entityList.get(position);
        //获取一条信息

        holder.tv_finaceTitle.setText(model.getDetail());
        holder.tvTime.setText(model.getCreateTime());

    }


    public void destroy() {
        imgLoader.clearMemoryCache();
        imgLoader.destroy();
    }

}
