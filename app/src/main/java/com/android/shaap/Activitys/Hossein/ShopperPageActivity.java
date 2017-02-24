package com.android.shaap.Activitys.Hossein;


import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;


import com.android.shaap.DataBase.DBHelper;
import com.android.shaap.Fragments.Hossein.MapFragment;
import com.android.shaap.Fragments.Hossein.ShopperPageFragments.CommentFragment;
import com.android.shaap.Fragments.Hossein.ShopperPageFragments.DetailFragment;
import com.android.shaap.Fragments.Hossein.ShopperPageFragments.FriendsFragment;
import com.android.shaap.GetersAndSeters.Hossein.NearShoppersItems;
import com.android.shaap.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

// Created By Hossein
public class ShopperPageActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private DBHelper myDBHelper;
    private SQLiteDatabase newDB;
    private Cursor c = null;
    private Handler handler;
    ProgressDialog progress;
    NearShoppersItems nearShoppersItems;

    TextView nameTX, addressTX;
    ImageView shopperLogoIMG;
    RatingBar ratingBar;

    String name,address;
    int img;
    float stars;
    double lat,lng;
    ArrayList<LatLng> location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper);
        Bundle extras = getIntent().getExtras();
        name = extras.getString("name");
        address = extras.getString("address");
        img = extras.getInt("img");
        stars = extras.getFloat("stars");
        lat = extras.getDouble("lat");
        lng = extras.getDouble("lng");

        location = new ArrayList<>();
        location.add(new LatLng(lat, lng));

        nameTX = (TextView) findViewById(R.id.name);
        addressTX = (TextView) findViewById(R.id.address);
        shopperLogoIMG = (ImageView) findViewById(R.id.shopperLogo);
        ratingBar = (RatingBar) findViewById(R.id.rating);

        progress = ProgressDialog.show(ShopperPageActivity.this, "",
                "لطفا صبر کنید", true);
        handler = new Handler();

        new Thread(new Task()).start();
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);


        //myDBHelper = new DBHelper(this);
        //try{
          //  myDBHelper.createDataBase();
        //}
        //catch (IOException e){
          //  throw new Error("Unable To Create DataBase ");
        //}
        //try {
          //  myDBHelper.OpenDataBase();
        //}
        //catch (SQLException sql){
          //  try {
            //    throw  sql;
            //} catch (SQLException e) {
              //  e.printStackTrace();
            //}
        //}
        //openAndQueryDataBase();





    }

    private void setupViewPager(ViewPager viewPager) {

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new MapFragment(location), "اطلاعات");
        adapter.addFragment(new CommentFragment(), "نظرات");
        adapter.addFragment(new FriendsFragment(), "دوستان");


        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }



    private void openAndQueryDataBase() {

        try {
            myDBHelper = new DBHelper(this);
            newDB = myDBHelper.getWritableDatabase();


            c = newDB.rawQuery("SELECT * FROM shoppers", null );

            if (c != null && c.moveToFirst()) {

                do {

                    String newName = c.getString(c.getColumnIndex("name"));
                    String oldName = c.getString(c.getColumnIndex("address"));
                    Log.d("newname is:" , newName);
                    Log.d("address is:" , oldName);

                } while (c.moveToNext());
                c.close();
            }
            else
            {


            }
        } catch (SQLiteException e) {

            Log.e("Database", "Could not create or Open the database");

        }


    }


    class Task implements Runnable {
        @Override
        public void run() {


                try {

                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {



                        nameTX.setText(name);
                        addressTX.setText(address);
                        shopperLogoIMG.setImageResource(img);
                        ratingBar.setRating(stars);


                        tabLayout.setupWithViewPager(viewPager);
                        setupViewPager(viewPager);
                        progress.dismiss();
                    }
                });
            }

    }

}