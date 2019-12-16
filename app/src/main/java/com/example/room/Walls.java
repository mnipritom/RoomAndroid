package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

public class Walls extends AppCompatActivity {

    private GridView wallsGridView;
    private String[] wallsListData;
    private int wallIcons[] = {R.drawable.walls};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.walls);

        wallsGridView = (GridView)findViewById(R.id.wallsList);
        wallsListData = getResources().getStringArray(R.array.wallsListArray);

        WallAdapter wallBridge = new WallAdapter(this,wallsListData,wallIcons);
        wallsGridView.setAdapter(wallBridge);
    }
}
