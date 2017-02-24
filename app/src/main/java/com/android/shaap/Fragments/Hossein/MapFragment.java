package com.android.shaap.Fragments.Hossein;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.shaap.Activitys.Hossein.NearActivity;
import com.android.shaap.R;
import com.android.shaap.Tools.Hossein.TrackGPS;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


//Created by Hossein

public class MapFragment extends Fragment implements OnMapReadyCallback {
    public static GoogleMap mMap;

    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    ArrayList<LatLng> locations;
    SupportMapFragment mapFragment;
    Marker currLocationMarker;
    public static TrackGPS gps;
    static LatLng latLng;
    boolean userLocationRequest = false;
    View view;

    ProgressDialog progress;

    public MapFragment(ArrayList<LatLng> locations) {
        this.locations = locations;
        userLocationRequest = false;
    }

    public MapFragment() {
        Log.d("ll", "lolo");
        userLocationRequest = true;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        progress = new ProgressDialog(getActivity());
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_map, container, false);
        }

        progress.setMessage("لطفا صبر کنید");
        //progress.show();

        mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        // Inflate the layout for this fragment
        return view;


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;





          //  buildGoogleApiClient();

            //mGoogleApiClient.connect();



        if (locations.get(0).latitude == 0 && locations.get(0).longitude == 0) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(35.700443, 51.337359)));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(35.700443, 51.337359)).zoom(16).build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        } else {
            for (LatLng location : locations) {
                mMap.addMarker(new MarkerOptions()
                        .position(location)
                        .title("رستوران"));
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(locations.get(0)));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(locations.get(0)).zoom(16).build();

            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        }


        }









    public static void onChangeLoc(double lat, double lng) {


        if (lat == 0 && lng == 0) {
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(35.700443, 51.337359)));
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(35.700443, 51.337359)).zoom(16).build();
            mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        } else {
            latLng = new LatLng(lat,lng);
            NearActivity.progress.dismiss();
            MarkerOptions markerOptions = new MarkerOptions();
            Log.d("latLangpo" , String.valueOf(latLng));
            if (latLng != null) {
                Log.d("lll",String.valueOf(latLng));
                markerOptions.position(latLng);
                markerOptions.title("مکان شما");
                Log.d("onLocation changed", "opop");
                CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(16).build();
                // mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            } else {
                Log.d("kjkj","klk");
            }
        }




}




}

