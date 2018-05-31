package com.bwie.test.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.bean.DataBean;
import com.bwie.test.mymoni_yuekao.R;

import java.util.List;

public class SearchViewGreenDaoAdapter extends BaseAdapter {
    private Context context;
    private List<DataBean> list;

    public SearchViewGreenDaoAdapter(Context context, List<DataBean> list) {
        this.context = context;
        this.list=list;
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
        final DataBean tv = (DataBean) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.search_page_flowlayout_tv, null);
            viewHolder = new ViewHolder();
            viewHolder.flowlayout_tv = (TextView) convertView.findViewById(R.id.flowlayout_tv);
            viewHolder.flowlayout_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context,tv.getTitle()+"", Toast.LENGTH_SHORT).show();
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.flowlayout_tv.setText(tv.getTitle());
        return convertView;
    }

    //创建ViewHolder类
    class ViewHolder {
        TextView flowlayout_tv;
    }
}
