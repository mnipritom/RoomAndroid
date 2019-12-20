package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class Walls extends AppCompatActivity {

    private GridView wallsGridView;
    private String[] wallsGridData;
    private int[] icons = {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle receivedData = getIntent().getExtras();

        int roomNumber = receivedData.getInt("selectedRoomNumber");

        if(roomNumber == 0){

            setContentView(R.layout.walls);

            wallsGridView = (GridView) findViewById(R.id.wallsGrid);
            wallsGridData = getResources().getStringArray(R.array.wallsGridArray);

            icons = new int[]{R.drawable.walls, R.drawable.walls, R.drawable.walls, R.drawable.walls};

            WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
            wallsGridView.setAdapter(wallBridge);

        }
        else if(roomNumber == 1){

            setContentView(R.layout.walls_diary_chapters);

            wallsGridView = (GridView) findViewById(R.id.wallsGrid);
            wallsGridData = getResources().getStringArray(R.array.wallsGridArray_Diary);

            icons = new int[]{R.drawable.friends, R.drawable.family, R.drawable.depression, R.drawable.feather};

            WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
            wallsGridView.setAdapter(wallBridge);

        }
        else{

            setContentView(R.layout.walls_diary_chapters);

            wallsGridView = (GridView) findViewById(R.id.wallsGrid);
            wallsGridData = getResources().getStringArray(R.array.wallsGridArray);

            icons = new int[]{R.drawable.friends, R.drawable.family, R.drawable.depression, R.drawable.feather};

            WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
            wallsGridView.setAdapter(wallBridge);

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(Walls.this,Rooms.class);
        startActivity(intent);
    }
}
