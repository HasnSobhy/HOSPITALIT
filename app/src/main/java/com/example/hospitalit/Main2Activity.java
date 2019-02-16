package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {
Intent myintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void signinback(View view) {
        myintent=new Intent(this,MainActivity.class);
        startActivity(myintent);
    }



    public void signupsubmit(View view) {
        myintent=new Intent(this,Main3Activity.class);
        startActivity(myintent);
    }
}
