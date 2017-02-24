package com.android.shaap.Adapters.Sorush;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.android.shaap.Activitys.Hossein.ShopperPageActivity;
import com.android.shaap.Activitys.Sorush.TestActivity;
import com.android.shaap.GetersAndSeters.Sorush.Payment;
import com.android.shaap.R;
import com.bumptech.glide.Glide;

import java.util.List;

// created by sorush
public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.MyViewHolder>{

    private Context context;
    private List<Payment> paymentList;

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;

        public MyViewHolder(View view) {
            super(view);
            image = (ImageView) view.findViewById(R.id.image_payment);
        }
    }

    public PaymentAdapter (Context context, List<Payment> paymentList) {
        this.context = context;
        this.paymentList = paymentList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.payment_main, parent, false);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TestActivity.class);
                context.startActivity(intent);
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Payment payment = paymentList.get(position);

        Glide.with(context).load(payment.getImage()).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return paymentList.size();
    }
}
