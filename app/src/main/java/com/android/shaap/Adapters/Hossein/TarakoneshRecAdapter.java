package com.android.shaap.Adapters.Hossein;

// Created By Hossein
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.shaap.GetersAndSeters.Hossein.TarakoneshItems;
import com.android.shaap.R;

import java.util.ArrayList;
import java.util.List;

public class TarakoneshRecAdapter extends RecyclerView.Adapter<TarakoneshRecAdapter.ViewHolder> {

    Context context;
    List<TarakoneshItems> tarakoneshItemsList = new ArrayList<>();


    public TarakoneshRecAdapter(Context context, List<TarakoneshItems> tarakoneshItemsList)
    {
        this.tarakoneshItemsList = tarakoneshItemsList;
        this.context = context;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout commentLin;
        private ImageView catIV,howPayIV, bankIV, isSuccess;
        private TextView costTX,nameOfShopperTX ,dateTX, sendCommentTX;

        public ViewHolder(View v) {
            super(v);
           // linMain = (LinearLayout) v.findViewById(R.id.lin_main);
            commentLin = (LinearLayout) v.findViewById(R.id.sendCommentLIN);
          //  linNoMain = (LinearLayout) v.findViewById(R.id.linNoMain);

            catIV = (ImageView) v.findViewById(R.id.catImageView);
            howPayIV = (ImageView) v.findViewById(R.id.howPayImageView);
            bankIV = (ImageView) v.findViewById(R.id.bankLogo);
            isSuccess = (ImageView) v.findViewById(R.id.isSuccess);

            costTX = (TextView) v.findViewById(R.id.costTX);
            nameOfShopperTX = (TextView) v.findViewById(R.id.nameOfShopperTX);
            dateTX = (TextView) v.findViewById(R.id.dateTX);
            sendCommentTX = (TextView) v.findViewById(R.id.sendCommentTX);

        }
    }



    @Override
    public TarakoneshRecAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                              int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarakonesh_item_row, parent, false);

        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        TarakoneshItems tarakoneshItems = new TarakoneshItems();
        tarakoneshItems = tarakoneshItemsList.get(position);

        if (tarakoneshItems.getCat() == 3) {
            holder.catIV.setImageResource(R.drawable.ic_local_dining_black_18dp);
        }

        if (tarakoneshItems.getNameBank() == 2) {
            holder.bankIV.setImageResource(R.drawable.bank_logo);
        }
        if (tarakoneshItems.getNameBank() == 3) {
            holder.bankIV.setImageResource(R.drawable.bank_logo2);
        }
        if (tarakoneshItems.getNameBank() == 1) {
            holder.bankIV.setImageResource(R.drawable.bank_logo3);
        }
        if (tarakoneshItems.getNameBank() == 4) {
            holder.bankIV.setImageResource(R.drawable.bank_logo4);
        }

        if (tarakoneshItems.getHowPay() == 2) {
            holder.howPayIV.setImageResource(R.drawable.ic_smartphone_black_18dp);
        }

        if (tarakoneshItems.getIsSuccess() == 1) {
            // tarakonesh movafagh
        } else {
            holder.isSuccess.setBackgroundResource(R.drawable.circle_shape4);
            holder.sendCommentTX.setText(R.string.tarakonesh_not_success);
        }

        holder.dateTX.setText(tarakoneshItems.getDate());
        holder.nameOfShopperTX.setText(tarakoneshItems.getShopperName());
        holder.costTX.setText(String.valueOf(tarakoneshItems.getCost()));





        holder.commentLin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(context);

                //tell the Dialog to use the dialog.xml as it's layout description
                dialog.setContentView(R.layout.comment_dialog_for_tarakonesh);


                Button dialogButton = (Button) dialog.findViewById(R.id.dialogButton);

                dialogButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });




    }

    @Override
    public int getItemCount() {
        return tarakoneshItemsList.size();
    }

}
