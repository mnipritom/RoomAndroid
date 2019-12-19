package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Walls extends AppCompatActivity {

    private GridView wallsGridView;
    private String[] wallsGridData;
    private int[] icons = {R.drawable.walls,R.drawable.walls,R.drawable.walls,R.drawable.walls};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walls);

        wallsGridView = (GridView) findViewById(R.id.wallsGrid);
        wallsGridData = getResources().getStringArray(R.array.wallsGridArray);

        WallAdapter wallBridge = new WallAdapter(this, wallsGridData,icons);
        wallsGridView.setAdapter(wallBridge);
    }
}
