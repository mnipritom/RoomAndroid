package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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

        final int roomNumber = receivedData.getInt("selectedRoomNumber");

        if(roomNumber == 0){

            setContentView(R.layout.walls);

            wallsGridView = (GridView) findViewById(R.id.wallsGrid);
            wallsGridData = getResources().getStringArray(R.array.wallsGridArray);

            icons = new int[]{R.drawable.walls, R.drawable.walls, R.drawable.walls, R.drawable.walls};

            WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
            wallsGridView.setAdapter(wallBridge);

            wallsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    finish();

                    Intent pickWall = new Intent(Walls.this,Boards.class);
                    pickWall.putExtra("selectedWallNumber",position);
                    pickWall.putExtra("currentRoomNumber",roomNumber);

                    startActivity(pickWall);

                }
            });

        }
        else if(roomNumber == 1){

            setContentView(R.layout.walls_diary_chapters);

            wallsGridView = (GridView) findViewById(R.id.wallsGrid);
            wallsGridData = getResources().getStringArray(R.array.wallsGridArray_Diary);

            icons = new int[]{R.drawable.friends, R.drawable.family, R.drawable.depression, R.drawable.feather};

            WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
            wallsGridView.setAdapter(wallBridge);

            wallsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    finish();

                    Intent pickWall = new Intent(Walls.this,Boards.class);
                    pickWall.putExtra("selectedWallNumber",position);
                    pickWall.putExtra("currentRoomNumber",roomNumber);

                    startActivity(pickWall);

                }
            });

        }
        else{

            setContentView(R.layout.walls_shoe_categories);

            wallsGridView = (GridView) findViewById(R.id.wallsGrid);
            wallsGridData = getResources().getStringArray(R.array.wallsGridArray_Shop);

            icons = new int[]{R.drawable.sports, R.drawable.slippers, R.drawable.casual, R.drawable.formal};

            WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
            wallsGridView.setAdapter(wallBridge);

            wallsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                    finish();

                    Intent pickWall = new Intent(Walls.this,Boards.class);
                    pickWall.putExtra("selectedWallNumber",position);
                    pickWall.putExtra("currentRoomNumber",roomNumber);

                    startActivity(pickWall);

                }
            });

        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
