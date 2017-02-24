package com.android.shaap.Adapters.Hossein;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.shaap.GetersAndSeters.Hossein.BottomSheetItems;
import com.android.shaap.GetersAndSeters.Hossein.TarakoneshItems;
import com.android.shaap.R;

import java.util.ArrayList;
import java.util.List;

//created by hossein
public class BottomSheetRecAdapter extends RecyclerView.Adapter<BottomSheetRecAdapter.ViewHolder> {

    Context context;
    List<BottomSheetItems> bottomSheetItemsList = new ArrayList<>();


    public BottomSheetRecAdapter(Context context, List<BottomSheetItems> bottomSheetItemsList)
    {
        this.context = context;
        this.bottomSheetItemsList = bottomSheetItemsList;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView catIMG;
        TextView catTX;

        public ViewHolder(View v) {
            super(v);
            catIMG = (ImageView) v.findViewById(R.id.catLogo);
            catTX = (TextView) v.findViewById(R.id.catName);
        }
    }



    @Override
    public BottomSheetRecAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bottom_sheet_rec_item_row, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        BottomSheetItems bottomSheetItems = bottomSheetItemsList.get(position);

        holder.catIMG.setImageResource(bottomSheetItems.getImage());
        holder.catTX.setText(bottomSheetItems.getName());


    }

    @Override
    public int getItemCount() {
        return bottomSheetItemsList.size();
    }

}
