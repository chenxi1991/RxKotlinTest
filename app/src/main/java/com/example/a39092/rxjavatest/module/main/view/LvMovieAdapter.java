package com.example.a39092.rxjavatest.module.main.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.a39092.rxjavatest.R;
import com.example.a39092.rxjavatest.model.bean.ResponseBody;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

/**
 * @author chenxi
 * @title RxJavaTest
 * @date 2017/4/13
 * @description
 */

public class LvMovieAdapter extends BaseAdapter {
    private List<ResponseBody.SubjectsBean> list;
    private Context context;

    public LvMovieAdapter(List<ResponseBody.SubjectsBean> list, Context context) {
        this.list = list;
        this.context = context;
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.lv_movie_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.lvMovieItemName.setText(list.get(position).getTitle());
        holder.lvMovieItemStar.setText(list.get(position).getRating().getStars());
        Glide.with(context).load(list.get(position).getImages().getMedium()).into(holder.lvMovieItemPic);
        RxView.clicks(convertView).throttleFirst(1, TimeUnit.SECONDS).subscribe(new Consumer<Object>() {
            @Override
            public void accept(Object o) throws Exception {
                Toast.makeText(context, position, Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

    class ViewHolder {
        @BindView(R.id.lv_movie_item_pic)
        ImageView lvMovieItemPic;
        @BindView(R.id.lv_movie_item_name)
        TextView lvMovieItemName;
        @BindView(R.id.lv_movie_item_star)
        TextView lvMovieItemStar;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
