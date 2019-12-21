package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import maes.tech.intentanim.CustomIntent;

public class ProjectInfo extends AppCompatActivity {

    private static int ProjectInfoDisplayTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_info);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent WelcomeScreen = new Intent(ProjectInfo.this,Rooms.class);
                startActivity(WelcomeScreen);
                finish();
                CustomIntent.customType(ProjectInfo.this, "left-to-right");
            }
        },ProjectInfoDisplayTime);
    }
}
