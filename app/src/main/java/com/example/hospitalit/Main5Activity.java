package com.example.hospitalit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import static com.example.hospitalit.util.Constants.ERROR_DIALOG_REQUEST;
import static com.example.hospitalit.util.Constants.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION;
import static com.example.hospitalit.util.Constants.PERMISSIONS_REQUEST_ENABLE_GPS;

public class Main5Activity extends AppCompatActivity {
Intent myintent;
GoogleMap mMap;
    private static String TAG="Main5Activity";
    private boolean mLocationPermissionGranted=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
    }

    public void back2(View view) {
        myintent=new Intent(this,Main4Activity.class);
        startActivity(myintent);
    }

    public void start(View view) {

        myintent=new Intent(this,Main6Activity.class);
        startActivity(myintent);

    }




}
