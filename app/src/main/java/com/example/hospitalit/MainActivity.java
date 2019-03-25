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
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.example.hospitalit.util.Constants.ERROR_DIALOG_REQUEST;
import static com.example.hospitalit.util.Constants.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION;
import static com.example.hospitalit.util.Constants.PERMISSIONS_REQUEST_ENABLE_GPS;

public class MainActivity extends AppCompatActivity {
    Intent myintent;
    SharedPreferences sharedPreferences;
    Boolean firstTime;

    //google play services anf gps
    private static String TAG="MainActivity";
    private boolean mLocationPermissionGranted=false;
    Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        firstTime = sharedPreferences.getBoolean("firstTime", true);

    }



    public void signup(View view) {
        myintent=new Intent(this,Main2Activity.class);
        startActivity(myintent);
    }


    public void signinsubmit(View view) {

        if(firstTime)
        {
            SharedPreferences.Editor editor= sharedPreferences.edit();
            firstTime=false;
            editor.putBoolean("firstTime",firstTime);
            editor.apply();


            EditText txtuser=(EditText)findViewById(R.id.editText);
            EditText txtpass=(EditText)findViewById(R.id.editText2);

            String email = txtuser.getText().toString();
            if(!(isValidEmail(email)))
            {
                txtuser.setError(getString(R.string.email2));
                txtuser.requestFocus();
                return;
            }

            if(txtpass.length()==0){
                txtpass.setError(getString(R.string.item)+" "+txtpass.getHint().toString()+getString(R.string.item2));
                txtpass.requestFocus();
                return;

            }

            myintent=new Intent(this,Main3Activity.class);
            b=new Bundle();
            b.putString("username",txtuser.getText().toString());
            b.putString("password",txtpass.getText().toString());
            myintent.putExtras(b);
            startActivity(myintent);


        }
        else
        {
            myintent=new Intent(this,Main6Activity.class);
            startActivity(myintent);
        }






        }




    //function for valodation email
    public static boolean isValidEmail(String email)
    {
        String expression = "^[\\w\\.]+@([\\w]+\\.)+[A-Z]{2,7}$";
        CharSequence inputString = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.matches())
        {
            return true;
        }
        else{
            return false;
        }
    }







}
