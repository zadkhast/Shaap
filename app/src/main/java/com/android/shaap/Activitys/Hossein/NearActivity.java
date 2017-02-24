package com.android.shaap.Activitys.Hossein;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.shaap.Adapters.Hossein.BottomSheetRecAdapter;

import com.android.shaap.Fragments.Hossein.MapFragment;
import com.android.shaap.Fragments.Hossein.NearPageFragments.NearListViewFragment;
import com.android.shaap.GetersAndSeters.Hossein.BottomSheetItems;
import com.android.shaap.R;
import com.android.shaap.Tools.Hossein.CheckNetworkConnectivity;
import com.android.shaap.Tools.Hossein.RecyclerItemClickListener;
import com.android.shaap.Tools.Hossein.TrackGPS;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;


// Created By Hossein
public class NearActivity extends AppCompatActivity  {


    LinearLayout lin;
    Toolbar toolbar;
    String fabState = null;
    private BottomSheetBehavior bottomSheetBehavior;
    FloatingActionButton fab;
    TextView text;

    private TrackGPS gps;
    double longitude = 0;
    double latitude = 0;

    CheckNetworkConnectivity checkNetworkConnectivity;

    private Handler handler;
    static LatLng latLng;

    Dialog noConnectionDialogBox;

    Button retryDialogBTN;

    boolean shouldExecuteOnResume,shouldExecuteOnStart;

    List<BottomSheetItems> bottomSheetItemsList ;
    public static ProgressDialog progress;



    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    ArrayList<LatLng> resturanLocationsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);
        shouldExecuteOnResume = false;
        shouldExecuteOnStart = false;


        text = (TextView) findViewById(R.id.text);
        lin = (LinearLayout) findViewById(R.id.lin); // define for expand cats
        fab = (FloatingActionButton) findViewById(R.id.fab);
        final View bottomSheet = findViewById(R.id.bottom_sheet2);




        setupContentOfBottomSheet();
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);


        adapter = new BottomSheetRecAdapter(this, bottomSheetItemsList);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {

                        resturanLocationsList = new ArrayList();
                        resturanLocationsList.add(new LatLng(35.687540, 51.373677));
                        resturanLocationsList.add(new LatLng(35.689126, 51.374814));
                        resturanLocationsList.add(new LatLng(35.687470, 51.372411));
                        resturanLocationsList.add(new LatLng(35.686450, 51.373527));

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.your_placeholder, new NearListViewFragment());

                    ft.commit(); // show list of near restuarant
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    text.setText("نزدیک ترین رستوران ها");
                    fab.setImageResource(R.drawable.ic_location_on_white_18dp); // set fab icon to show all of this list to map
                    fabState = "mapClick";
                    fab.show();
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );



        fabState = "userLocation";


        // start for check network connection
        checkNetworkConnectivity = new CheckNetworkConnectivity(this);
        // if user is online the func is call
        if (checkNetworkConnectivity.isOnline()) {

            // this method is for setup map fragment by thread
            func(0);
        } else {
            func(0);// if user is not online show the dialog for retry
            noConnectionDialogBox = new Dialog(this);

            noConnectionDialogBox.setContentView(R.layout.dialog_for_no_connection);
            noConnectionDialogBox.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    // this is for when the user try to cancel dialog box
                    if (checkNetworkConnectivity.isOnline()) {
                        func(0);
                        noConnectionDialogBox.dismiss();
                    } else  {
                        func(0);
                        NearActivity.this.finish();
                    }
                }
            });

            //show the no connection dialog box
            noConnectionDialogBox.show();

            // this is for the retry button in no connection dialog box
            retryDialogBTN = (Button) noConnectionDialogBox.findViewById(R.id.button);
            retryDialogBTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // if the retry click :
                    if (checkNetworkConnectivity.isOnline()) {

                        // this method is for setup map fragment by thread
                        func(0);
                        noConnectionDialogBox.dismiss();
                    } else {
                        func(0);
                        noConnectionDialogBox.show();
                    }
                }
            });

        }// end of check network connection










            //setup toolbar
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);




            //this 4 line for setup bottom sheet
            bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
            bottomSheetBehavior.setHideable(true);
            bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            bottomSheetBehavior.setPeekHeight(getResources().getDimensionPixelSize(R.dimen.test));

            //for expand cats
            lin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) { // if bottom sheet collapsed expand it
                        //and close fab
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                        fab.animate().scaleX(0).scaleY(0).setDuration(300).start();
                        fab.hide();
                    }
                    if (bottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {// if bottom sheet expanded collapse it
                        //and open fab
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                        fab.show();
                    }
                }
            });



            // if fab clicked this action will acure
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fabState == "userLocation") {
                        func(1);
                    } else if (fabState == "listClick") {
                        Log.d("stateis", fabState);
                        fab.setImageResource(R.drawable.ic_location_on_white_18dp);

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.your_placeholder, new NearListViewFragment());
                        ft.commit();

                        fabState = "mapClick";
                    } else if (fabState == "mapClick") {
                        Log.d("stateis", fabState);
                        fab.setImageResource(R.drawable.ic_list_white_18dp);

                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.your_placeholder, new MapFragment(resturanLocationsList));
                        ft.commit();


                        fabState = "listClick";
                    } else {
                        Toast.makeText(NearActivity.this, "you have problem", Toast.LENGTH_SHORT).show();
                    }

                }
            });


            bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {

                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }

                    // if bottom sheet dragging the fab will be close
                    if (BottomSheetBehavior.STATE_DRAGGING == newState) {
                        fab.animate().scaleX(0).scaleY(0).setDuration(300).start();
                        // if bottom sheet collapse the fab will be open
                    } else if (BottomSheetBehavior.STATE_COLLAPSED == newState) {
                        fab.animate().scaleX(1).scaleY(1).setDuration(300).start();
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                }
            });
        }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public void getUserLocation() {

        Log.d("getUserLocation" , "F");
        gps = new TrackGPS(NearActivity.this);
        if (gps.canGetLocation()) {

            func(0);
            fab.setImageResource(R.drawable.ic_my_location_white_36dp);

        } else {
          //  gps.showSettingsAlert();
            fab.setImageResource(R.drawable.ic_location_disabled_white_18dp);
        }

    }

    public void getUserLocationWithClickUpdate() {

        gps = new TrackGPS(NearActivity.this);
        if (gps.canGetLocation()) {

            func(0);
            fab.setImageResource(R.drawable.ic_my_location_white_36dp);


        } else {
            gps.showSettingsAlert();
            fab.setImageResource(R.drawable.ic_location_disabled_white_18dp);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(shouldExecuteOnResume){
            Log.d("resume" , "ok");
            Log.d("getUserLocation" , "R");
            func(2);
        } else{
            shouldExecuteOnResume = true;
        }

    }



    private void setupContentOfBottomSheet() {
        bottomSheetItemsList = new ArrayList<>();
        BottomSheetItems bottomSheetItems = new BottomSheetItems();
        bottomSheetItems = new BottomSheetItems("رستوران" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("خوراکی" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("سلامت" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("درسی" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);
        bottomSheetItems = new BottomSheetItems("پوشاک" ,R.mipmap.ic_launcher);
        bottomSheetItemsList.add(bottomSheetItems);


    }

    private void func(int i) {
        progress = new ProgressDialog(this);
        gps = new TrackGPS(NearActivity.this);
        if (gps.canGetLocation()) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            if (i == 0) {
                ft.replace(R.id.your_placeholder, new MapFragment(resturanLocationsList));
                ft.commit();
            }

            if (i == 2) {

                progress.setMessage("لطفا صبر کنید");
                progress.show();
                fab.setImageResource(R.drawable.ic_my_location_white_36dp);
            }
        } else {
            if (i == 1) {
                gps.showSettingsAlert();
            }
            fab.setImageResource(R.drawable.ic_location_disabled_white_18dp);
        }

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        gps = new TrackGPS(this);
        latLng = new LatLng(gps.getLatitude(), gps.getLongitude());

        resturanLocationsList = new ArrayList<>();
        resturanLocationsList.add(latLng);


        text.setText("مکان شما"); // set toolbar text
        fabState = "userLocation";
        if (i == 0) {
            ft.replace(R.id.your_placeholder, new MapFragment(resturanLocationsList));
            ft.commit();
        }else MapFragment.onChangeLoc(gps.getLatitude(), gps.getLongitude());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.finish();
    }


}
