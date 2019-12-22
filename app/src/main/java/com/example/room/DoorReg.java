package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import maes.tech.intentanim.CustomIntent;


public class DoorReg extends AppCompatActivity {

    UserDBHelper authentication;

    UserData entry;

    private EditText user, pass;

    ImageView logButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        entry = new UserData();

        Intent backToLogin = new Intent(DoorReg.this,DoorLogin.class);
        startActivity(backToLogin);
        CustomIntent.customType(DoorReg.this,"left-to-right");

        setContentView(R.layout.door_reg);

        user = (EditText) findViewById(R.id.username);
        pass = (EditText) findViewById(R.id.password);

        logButton = (ImageView) findViewById(R.id.logStatus);//for logRoom function to work


        authentication = new UserDBHelper(DoorReg.this);
        SQLiteDatabase record = authentication.getWritableDatabase();

    }

    public void regRoom(View view){
        final TextView regStatus = (TextView) findViewById(R.id.regStatus);

        String username = user.getText().toString();
        String password = pass.getText().toString();

        if(username.trim().equals("") || username.isEmpty() || password.trim().equals("") || password.isEmpty())//trim ignores spaces in front of strings
        {
            regStatus.setText("\uD83D\uDE1E Failed to register");
        }
        else{
            entry.setName(username);
            entry.setKey(password);

            long id = authentication.insertData(entry);
            if(id>0)//to ensure unique user entry
            {
                logButton.setImageResource(R.drawable.tick);
                regStatus.setText("User created");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logButton.setImageResource(R.drawable.door);
                        regStatus.setText("⬅️ Touch to log in");
                    }
                },2000);

            }
            else
            {
                logButton.setImageResource(R.drawable.exist);
                regStatus.setText("User exists");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        logButton.setImageResource(R.drawable.door);
                        regStatus.setText("⬅️ Touch to log back in");
                    }
                },2000);
            }

        }
    }

    public void logRoom(View view){

        Intent backToLogin = new Intent(DoorReg.this,DoorLogin.class);
        startActivity(backToLogin);
        CustomIntent.customType(DoorReg.this,"left-to-right");

    }
}
