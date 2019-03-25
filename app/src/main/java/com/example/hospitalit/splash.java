package com.example.hospitalit;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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

import static com.example.hospitalit.util.Constants.ERROR_DIALOG_REQUEST;
import static com.example.hospitalit.util.Constants.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION;
import static com.example.hospitalit.util.Constants.PERMISSIONS_REQUEST_ENABLE_GPS;

public class splash extends AppCompatActivity {

    private static String TAG="splash";
    private boolean mLocationPermissionGranted=false;
    Intent myintent;

    SharedPreferences sharedPreferences;
    Boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime", true);

        if (firstTime) {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            firstTime = false;
            editor.putBoolean("firstTime", firstTime);
            editor.apply();

            if (checkMapServices()) {

                if (mLocationPermissionGranted) {

                    setContentView(R.layout.activity_splash);

                    Thread mythread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(0);
                                Intent spintent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(spintent);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    mythread.start();

                } else {

                    getLocationPermission();

                    if (mLocationPermissionGranted) {

                        setContentView(R.layout.activity_splash);

                        Thread mythread = new Thread() {
                            @Override
                            public void run() {
                                try {
                                    sleep(0);
                                    Intent spintent = new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(spintent);
                                    finish();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        mythread.start();

                    }



                }
            }

        }
        else
            {
            splashfunc();

            }
    }






    //function for exit splash and goto activity
    private void splashfunc()
    {
        if(checkMapServices()){

            if(mLocationPermissionGranted)
            {

                setContentView(R.layout.activity_splash);

                Thread mythread=new Thread(){
                    @Override
                    public void run() {
                        try {
                            sleep(0);
                            Intent spintent=new Intent(getApplicationContext(),Main6Activity.class);
                            startActivity(spintent);
                            finish();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                mythread.start();

            }
            else {

                getLocationPermission();

                if (mLocationPermissionGranted) {

                    setContentView(R.layout.activity_splash);

                    Thread mythread = new Thread() {
                        @Override
                        public void run() {
                            try {
                                sleep(0);
                                Intent spintent = new Intent(getApplicationContext(), Main6Activity.class);
                                startActivity(spintent);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    mythread.start();

                }

            }


        }


    }

    //check for google play service and GPS to enable it

    private boolean checkMapServices(){
        if(isServicesOK()){
            if(isMapsEnabled()){
                return true;
            }
        }
        return false;
    }

    //show dialog for enable gps
    private void buildAlertMessageNoGps() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This application requires GPS to work properly, do you want to enable it?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(@SuppressWarnings("unused") final DialogInterface dialog, @SuppressWarnings("unused") final int id) {
                        Intent enableGpsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivityForResult(enableGpsIntent, PERMISSIONS_REQUEST_ENABLE_GPS);
                    }
                });
        final AlertDialog alert = builder.create();
        alert.show();
    }
    //determining is gps enabled on device or not
    public boolean isMapsEnabled(){
        final LocationManager manager = (LocationManager) getSystemService( Context.LOCATION_SERVICE );

        if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
            buildAlertMessageNoGps();
            return false;
        }
        return true;
    }

    private void getLocationPermission() {
        /*
         * Request location permission, so that we can get the location of the
         * device. The result of the permission request is handled by a callback,
         * onRequestPermissionsResult.
         */
        if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLocationPermissionGranted = true;

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

            if (ContextCompat.checkSelfPermission(this.getApplicationContext(),
                    android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mLocationPermissionGranted = true;

            }

        }
    }
    //determine is google play service is enabled or not
    public boolean isServicesOK(){
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(splash.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(splash.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    //check after permission granted or denied

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        mLocationPermissionGranted = false;
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mLocationPermissionGranted = true;
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG, "onActivityResult: called.");
        switch (requestCode) {
            case PERMISSIONS_REQUEST_ENABLE_GPS: {
                if(mLocationPermissionGranted){


                    Thread mythread=new Thread(){
                        @Override
                        public void run() {
                            try {
                                sleep(0);
                                Intent spintent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(spintent);
                                finish();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    mythread.start();

                }
                else{
                    getLocationPermission();
                }
            }
        }

    }


    //function to exit app
    public void exitapp() {
        finish();
        System.exit(0);
    }














}
