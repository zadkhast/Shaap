package com.android.shaap.Adapters.Sorush;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.shaap.GetersAndSeters.Sorush.Category;
import com.android.shaap.R;
import com.bumptech.glide.Glide;
import com.hookedonplay.decoviewlib.DecoView;
import com.hookedonplay.decoviewlib.charts.SeriesItem;
import com.hookedonplay.decoviewlib.events.DecoEvent;

import java.util.List;

//created by sorush
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private Context context;
    private List<Category> categoryList;
    private int position_num = 0;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, my_percent, friend_percent, all_percent;
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.text_cat);
            my_percent = (TextView) view.findViewById(R.id.text_percent_cat);
            friend_percent = (TextView) view.findViewById(R.id.text_friend_percent);
            all_percent = (TextView) view.findViewById(R.id.text_all_percent);
            image = (ImageView) view.findViewById(R.id.image_cat);
        }
    }

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_main, parent, false);
        DecoView decoView = (DecoView) itemView.findViewById(R.id.dynamicArcView);

        Category category = categoryList.get(position_num);

        final SeriesItem series_my = new SeriesItem.Builder(Color.parseColor("#673AB7"))//
                .setRange(0, 100, 0)
                .build();

        final SeriesItem series_friend = new SeriesItem.Builder(Color.parseColor("#D1C4E9"))
                .setRange(0, 100, 0)
                .build();

        final SeriesItem series_all = new SeriesItem.Builder(Color.parseColor("#757575"))
                .setRange(0, 100, 0)
                .build();

        float percent_my = category.getMy_percent(), percent_friend = category.getMyFriend_percent()
                , percent_all = category.getAll_percent();

        int Index_friend, Index_all, Index_my, delay_my, delay_friend, delay_all;

        if (percent_my > percent_friend){
            if (percent_my > percent_all){
                if (percent_friend > percent_all){
                    Index_my = decoView.addSeries(series_my);
                    Index_friend = decoView.addSeries(series_friend);
                    Index_all = decoView.addSeries(series_all);

                    delay_my = 50;
                    delay_friend = 500;
                    delay_all = 1000;
                } else {
                    Index_my = decoView.addSeries(series_my);
                    Index_all = decoView.addSeries(series_all);
                    Index_friend = decoView.addSeries(series_friend);

                    delay_my = 50;
                    delay_friend = 1000;
                    delay_all = 500;
                }
            } else {
                Index_friend = decoView.addSeries(series_friend);
                Index_my = decoView.addSeries(series_my);
                Index_all = decoView.addSeries(series_all);

                delay_my = 500;
                delay_friend = 50;
                delay_all = 1000;
            }
        } else if (percent_my > percent_all){
            Index_friend = decoView.addSeries(series_friend);
            Index_my = decoView.addSeries(series_my);
            Index_all = decoView.addSeries(series_all);

            delay_my = 500;
            delay_friend = 50;
            delay_all = 1000;
        } else if (percent_friend > percent_all){
            Index_friend = decoView.addSeries(series_friend);
            Index_all = decoView.addSeries(series_all);
            Index_my = decoView.addSeries(series_my);

            delay_my = 1000;
            delay_friend = 50;
            delay_all = 500;
        } else {
            Index_all = decoView.addSeries(series_all);
            Index_friend = decoView.addSeries(series_friend);
            Index_my = decoView.addSeries(series_my);

            delay_my = 1000;
            delay_friend = 500;
            delay_all = 50;
        }

        decoView.addEvent(new DecoEvent.Builder(percent_my)
                .setIndex(Index_my)
                .setDelay(delay_my)
                .build());

        decoView.addEvent(new DecoEvent.Builder(percent_friend)
                .setIndex(Index_friend)
                .setDelay(delay_friend)
                .build());

        decoView.addEvent(new DecoEvent.Builder(percent_all)
                .setIndex(Index_all)
                .setDelay(delay_all)
                .build());

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Category category = categoryList.get(position);

        position_num = position + 1;

        holder.title.setText(category.getCat());
        holder.my_percent.setText("%"+category.getMy_percent());
        holder.friend_percent.setText("%"+category.getMyFriend_percent());
        holder.all_percent.setText("%"+category.getAll_percent());

        Glide.with(context).load(category.getImage()).into(holder.image);

        /*DecoView decoView = (DecoView) view.findViewById(R.id.dynamicArcView);

        final SeriesItem seriesItem1 = new SeriesItem.Builder(Color.parseColor("#303F9F"))
                .setRange(0, 100, 0)
                .build();*/

        //int series1Index = decoView.addSeries(seriesItem1);
        /*int series1Index_all = decoView.addSeries(seriesItem3);
        int series1Index_friend = decoView.addSeries(seriesItem2);*/

        /*decoView.addEvent(new DecoEvent.Builder(75)
                .setIndex(series1Index)
                .setDelay(100)
                .build());*/

        /*decoView.addEvent(new DecoEvent.Builder(10)
                .setIndex(series1Index_friend)
                .setDelay(1500)
                .build());

        decoView.addEvent(new DecoEvent.Builder(25)
                .setIndex(series1Index_all)
                .setDelay(1000)
                .build());*/

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}


