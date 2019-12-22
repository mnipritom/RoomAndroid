package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import maes.tech.intentanim.CustomIntent;

public class ProjectInfo extends AppCompatActivity {

    private static int ProjectInfoDisplayTime = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_info);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent WelcomeScreen = new Intent(ProjectInfo.this,DoorReg.class);
                startActivity(WelcomeScreen);
                CustomIntent.customType(ProjectInfo.this, "left-to-right");
            }
        },ProjectInfoDisplayTime);
    }
}
