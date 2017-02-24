package com.android.shaap.Activitys.Hossein;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.android.shaap.Adapters.Hossein.TarakoneshRecAdapter;
import com.android.shaap.GetersAndSeters.Hossein.TarakoneshItems;
import com.android.shaap.R;

import java.util.ArrayList;
import java.util.List;

// Created By Hossein
public class TarakoneshActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    List<TarakoneshItems> tarakonshList ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarakonesh);

        tarakonshList = new ArrayList<>();


        //String date,int nameBank, int howPay, int cat, is success, double cost
        TarakoneshItems ti = new TarakoneshItems("رستوران آرش","1395/11/26" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        //String date,int nameBank, int howPay, int cat, is success, double cost
         ti = new TarakoneshItems("سفره خانه سنتی امیر","1395/11/27" , 1, 2,3,1,20000);
        tarakonshList.add(ti);
         ti = new TarakoneshItems("کافه ویونا","1395/11/27" , 3, 2,3,2,29000);
        tarakonshList.add(ti);
         ti = new TarakoneshItems("کله پاچه عزت","1395/11/28" , 4, 2,3,1,40000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/29" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/30" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/26" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/26" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/26" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/26" , 2, 2,3,1,22000);
        tarakonshList.add(ti);
        ti = new TarakoneshItems("رستوران آرش","1395/11/26" , 2, 2,3,1,22000);
        tarakonshList.add(ti);


        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new TarakoneshRecAdapter(this , tarakonshList);
        recyclerView.setAdapter(adapter);
    }
}
