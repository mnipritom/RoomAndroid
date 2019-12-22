package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.r0adkll.slidr.Slidr;

public class DoorLogin extends AppCompatActivity {

    UserDBHelper logAuthentication;


    private TextView logStatus;
    private ImageView logKey;

    private String username;
    private String password;

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
        SQLiteDatabase record = logAuthentication.getReadableDatabase();

        username = user.getText().toString();
        password = pass.getText().toString();

    }
    public void checkLogin(View view){

        int timeout = 2000;

        Boolean result = false;

        if(username.trim().equals("") || username.isEmpty() || password.trim().equals("") || password.isEmpty())//trim ignores spaces in front of strings
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
            result = logAuthentication.findKey(username,password);
            if(result==true ){
                //Intent finishRegAndLog = new Intent(DoorLogin.this,Rooms.class);
                //finishRegAndLog.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//destroys reg and log activities and clears stack
                //finishRegAndLog.putExtra("whoToReceive",username);
                //startActivity(finishRegAndLog);
                logStatus.setText("logged in");
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
        }

    }



}
