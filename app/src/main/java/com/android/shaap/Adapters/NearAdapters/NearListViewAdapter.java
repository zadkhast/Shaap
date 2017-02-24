package com.android.shaap.Adapters.NearAdapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.android.shaap.Activitys.Hossein.ShopperPageActivity;
import com.android.shaap.GetersAndSeters.Hossein.NearShoppersItems;
import com.android.shaap.R;

import java.io.Serializable;
import java.util.List;

// Created By Hossein
public class NearListViewAdapter extends BaseAdapter{

    Context context;
    Intent intent;
    List<NearShoppersItems> nearShoppersItemsList;
    static NearShoppersItems nearShoppersItems;

    private static LayoutInflater inflater = null;

    public NearListViewAdapter(Context context, List<NearShoppersItems> nearShoppersItemsList) {

        this.context =context;
        this.nearShoppersItemsList = nearShoppersItemsList;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return nearShoppersItemsList.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        nearShoppersItems = new NearShoppersItems();
        nearShoppersItems = nearShoppersItemsList.get(position);

        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.near_listview_item_row, null);


        TextView nameTX,addressTX;
        ImageView shopperLogoIMG;
        RatingBar ratingBar;

        nameTX = (TextView) view.findViewById(R.id.name);
        addressTX = (TextView) view.findViewById(R.id.address);
        shopperLogoIMG = (ImageView) view.findViewById(R.id.shopperLogo);
        ratingBar = (RatingBar) view.findViewById(R.id.rating);

        nameTX.setText(nearShoppersItems.getName());
        addressTX.setText(nearShoppersItems.getAddress());
        shopperLogoIMG.setImageResource(nearShoppersItems.getImageOfShopper());
        ratingBar.setRating(nearShoppersItems.getStars());



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nearShoppersItems = nearShoppersItemsList.get(position);
                // TODO Auto-generated method stub
                intent = new Intent(context , ShopperPageActivity.class);
                intent.putExtra("name" , nearShoppersItems.getName());
                intent.putExtra("address" , nearShoppersItems.getAddress());
                intent.putExtra("img", nearShoppersItems.getImageOfShopper());
                intent.putExtra("stars", nearShoppersItems.getStars());
                intent.putExtra("lat", nearShoppersItems.getLat());
                intent.putExtra("lng", nearShoppersItems.getLng());
                context.startActivity(intent);
            }
        });
        return view;
    }

}
