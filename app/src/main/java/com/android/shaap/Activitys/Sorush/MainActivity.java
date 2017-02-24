package com.android.shaap.Activitys.Sorush;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.android.shaap.Activitys.Hossein.LoginActivity;
import com.android.shaap.Activitys.Mehrdad.CategoryActivity;
import com.android.shaap.Activitys.Mehrdad.HesabdariActivity;
import com.android.shaap.Activitys.Hossein.NearActivity;
import com.android.shaap.Activitys.Hossein.TarakoneshActivity;
import com.android.shaap.Adapters.Sorush.CategoryAdapter;
import com.android.shaap.Adapters.Sorush.PaymentAdapter;
import com.android.shaap.GetersAndSeters.Sorush.Category;
import com.android.shaap.GetersAndSeters.Sorush.Payment;
import com.android.shaap.R;

import java.util.ArrayList;
import java.util.List;

//created by sorush
public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView, recyclerView_payment;
    private CategoryAdapter adapter;
    private PaymentAdapter adapter_payment;
    private List<Category> categoryList;
    private List<Payment> paymentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.bringToFront();
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView_payment = (RecyclerView) findViewById(R.id.recycler_view_payment);

        categoryList = new ArrayList<>();
        adapter = new CategoryAdapter(this, categoryList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

        paymentList = new ArrayList<>();
        adapter_payment = new PaymentAdapter(this, paymentList);

        recyclerView_payment.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView_payment.setAdapter(adapter_payment);

        prepareCategory();
        preparePayment();
    }

    private void prepareCategory() {

        int[] catPic = new int[]{

                R.drawable.ic_food_black_36dp,
                R.mipmap.ic_launcher,
                R.drawable.ic_food_black_36dp,
                R.mipmap.ic_launcher,
                R.drawable.ic_food_black_36dp,
                R.mipmap.ic_launcher,
                R.drawable.ic_food_black_36dp,
                R.mipmap.ic_launcher
        };

        Category cat = new Category("غذا", catPic[0], 50, 10, 30);
        categoryList.add(cat);

        cat = new Category("غذا", catPic[1], 30, 80, 10);
        categoryList.add(cat);

        cat = new Category("غذا", catPic[0], 50, 40, 20);
        categoryList.add(cat);

/*        cat = new Category("پوشاک", catPic[1]);
        categoryList.add(cat);

        cat = new Category("دارو", catPic[2]);
        categoryList.add(cat);

        cat = new Category("ماشین", catPic[3]);
        categoryList.add(cat);

        cat = new Category("ماشین", catPic[4]);
        categoryList.add(cat);

        cat = new Category("ماشین", catPic[5]);
        categoryList.add(cat);

        cat = new Category("ماشین", catPic[6]);
        categoryList.add(cat);

        cat = new Category("ماشین", catPic[7]);
        categoryList.add(cat);*/

        adapter.notifyDataSetChanged();
    }

    private void preparePayment() {

        int[] payPic = new int[]{

                R.drawable.belit_cinama,
                R.drawable.belit_ghatar,
                R.drawable.belit_hava_peyma,
                R.drawable.belit_otobos,
                R.drawable.bime_aghsat,
                R.drawable.bime_mashin,
                R.drawable.emtiazgiri,
                R.drawable.ghabz_khadamati,
                R.drawable.jarime_khodro,
                R.drawable.nikokari,
                R.drawable.sharjh_internet,
                R.drawable.sharjh_simcard,
                R.drawable.tarh_terafic,
                R.drawable.tele_pardaz


        };

        Payment pay = new Payment(payPic[0]);
        paymentList.add(pay);

        pay = new Payment(payPic[1]);
        paymentList.add(pay);

        pay = new Payment(payPic[2]);
        paymentList.add(pay);

        pay = new Payment(payPic[3]);
        paymentList.add(pay);

        pay = new Payment(payPic[4]);
        paymentList.add(pay);

        pay = new Payment(payPic[5]);
        paymentList.add(pay);

        pay = new Payment(payPic[6]);
        paymentList.add(pay);

        pay = new Payment(payPic[7]);
        paymentList.add(pay);

        pay = new Payment(payPic[8]);
        paymentList.add(pay);

        pay = new Payment(payPic[9]);
        paymentList.add(pay);

        pay = new Payment(payPic[10]);
        paymentList.add(pay);

        pay = new Payment(payPic[11]);
        paymentList.add(pay);

        pay = new Payment(payPic[12]);
        paymentList.add(pay);

        pay = new Payment(payPic[13]);
        paymentList.add(pay);



        adapter_payment.notifyDataSetChanged();

    }

    public void taraKoneshClick(View view) {
        //created by hossein
        Intent intent = new Intent(this , TarakoneshActivity.class);
        startActivity(intent);
    }

    public void nearMeClick(View view) {// created by hossein

        if (checkLocationPermission()) {
            Intent intent = new Intent(this, NearActivity.class);
            startActivity(intent);
        } else {

            new AlertDialog.Builder(this)

                    .setMessage(R.string.ask_location_permission_message)
                    .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        }
                    })
                    .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // do nothing
                        }
                    })
                    .show();
           
        }

    }

    public void hesabdariClick(View view) {
        //created by mehrdad
        Intent intent = new Intent(this , HesabdariActivity.class);
        startActivity(intent);
    }

    public void categoryClick(View view) {
        //created by mehrdad
        Intent intent = new Intent(this , CategoryActivity.class);
        startActivity(intent);
    }

    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {
                Log.d("havij" , "d");
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Log.d("havij" , "z");
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public boolean checkLocationPermission()
    {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    public void profileClick(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}
