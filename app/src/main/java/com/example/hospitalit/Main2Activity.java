package com.example.hospitalit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main2Activity extends AppCompatActivity {
Intent myintent;

    Bundle b;
    int i=0;
    int j=0;
    EditText[] idarray;
    String[] straray;
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

        idarray= new EditText[]{findViewById(R.id.editText3),findViewById(R.id.editText4),findViewById(R.id.editText7),findViewById(R.id.editText5),findViewById(R.id.editText6),findViewById(R.id.editText8)};
        myintent=new Intent(this,Main3Activity.class);
        b=new Bundle();
        straray=new String[5];

        for(i=0;i<5;i++){
            straray[i]=idarray[i].getText().toString();
        }

        for(j=0;j<5;j++){

            if (straray[j].getBytes().length==0){
                idarray[j].setError(getString(R.string.item)+" "+idarray[j].getHint().toString()+getString(R.string.item2));
                idarray[j].requestFocus();
                return;
            }
        }



//validation email
        String email = idarray[3].getText().toString();
        if(!(isValidEmail(email)))
        {
            idarray[3].setError(getString(R.string.email2));
            idarray[3].requestFocus();
            return;
        }


//validation phone

        String phone = idarray[2].getText().toString();
        if(!(isValidPhone(phone))) {
            idarray[2].setError(getString(R.string.phone));
            idarray[2].requestFocus();
            return;
        }

//comparing password
        String pass1=idarray[4].getText().toString();
        String pass2=idarray[5].getText().toString();
        if(!(pass2.equals(pass1))){

            idarray[4].setError(getString(R.string.confirmpassword));
            idarray[4].requestFocus();
            return;
        }


        b.putString("firstname",idarray[0].getText().toString());
        b.putString("lastname",idarray[1].getText().toString());
        myintent.putExtras(b);
        startActivity(myintent);

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

    //function for validation phone
    public static boolean isValidPhone(String phone)
    {
        String expression = "^([0-9\\+]|\\(\\d{1,3}\\))[0-9\\-\\. ]{3,15}$";
        CharSequence inputString = phone;
        Pattern pattern = Pattern.compile(expression);
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
