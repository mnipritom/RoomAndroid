package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

import maes.tech.intentanim.CustomIntent;

public class DoorLogin extends AppCompatActivity {

    UserDBHelper logAuthentication;

    private TextView logStatus;
    private ImageView logKey;

    private EditText user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Slidr.attach(this);

        setContentView(R.layout.door_login);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        logStatus = (TextView) findViewById(R.id.logStatus);
        logKey = (ImageView) findViewById(R.id.logKey);

        logAuthentication = new UserDBHelper(DoorLogin.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logKey.setImageResource(R.drawable.right_arrow);
                logStatus.setText("Slide to register");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logKey.setImageResource(R.drawable.door);
                        logStatus.setText("Login to enter");
                    }
                },2000);
            }
        },2000);


    }
    public void checkLogin(View view){

        int timeout = 2000;

        String username = user.getText().toString();//these two mafakin lines got me stuck for two fakin days
        String password = pass.getText().toString();//always declaring strings whenever needed from now on, never using global variable

        SQLiteDatabase record = logAuthentication.getReadableDatabase();
        Cursor cursor = record.rawQuery("SELECT * FROM users WHERE username=? and password=?", new String[]{username,password});
        //Boolean result = false;

        if( username.trim().equals(" ") || username.isEmpty() || password.trim().isEmpty() || password.isEmpty() )//trim ignores spaces in front of strings
        {
            logStatus.setText("\uD83D\uDE1EFailed to login");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    logKey.setImageResource(R.drawable.right_arrow);
                    logStatus.setText("Slide to register");
                }
            },timeout);
        }
        else{
            if(cursor.getCount()!=0){
                //finish();
                Intent finishLog = new Intent(DoorLogin.this,Rooms.class);
                finishLog.putExtra("whoToReceive",username);
                this.finishAffinity();
                startActivity(finishLog);
                CustomIntent.customType(DoorLogin.this,"left-to-right");
            }
            else{
                logStatus.setText("\uD83D\uDE1EFailed to login");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logKey.setImageResource(R.drawable.right_arrow);
                        logStatus.setText("Slide to register");
                    }
                },timeout);
            }
        }

        /*else{
            result = logAuthentication.findKey(username,password);
                if(result==true ){
                    Intent finishRegAndLog = new Intent(DoorLogin.this,Rooms.class);
                    finishRegAndLog.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//destroys reg and log activities and clears stack
                    finishRegAndLog.putExtra("whoToReceive",username);
                    startActivity(finishRegAndLog);
                }
                else{
                    logStatus.setText("Failed");

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            logKey.setImageResource(R.drawable.right_arrow);
                            logStatus.setText("Slide to register");
                        }
                    },timeout);

                }


        }*/

    }

}
