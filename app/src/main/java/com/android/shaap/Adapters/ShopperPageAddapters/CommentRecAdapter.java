package com.android.shaap.Adapters.ShopperPageAddapters;

// Created By Hossein
import java.util.ArrayList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.shaap.R;

public class CommentRecAdapter extends RecyclerView.Adapter<CommentRecAdapter.ViewHolder> {
    private ArrayList<String> dataArray;


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtHeader;
        public TextView txtFooter;

        public ViewHolder(View v) {
            super(v);
            txtHeader = (TextView) v.findViewById(R.id.name);
            txtFooter = (TextView) v.findViewById(R.id.date);
        }
    }

    public CommentRecAdapter(ArrayList<String> dataArray) {

        this.dataArray = dataArray;
    }

    @Override
    public CommentRecAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
        // create a new view
        View v;
             v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_items_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.txtHeader.setText(dataArray.get(position));
        //holder.txtFooter.setText("22 بهمن");

    }

    @Override
    public int getItemCount() {
        return dataArray.size();
    }

}
