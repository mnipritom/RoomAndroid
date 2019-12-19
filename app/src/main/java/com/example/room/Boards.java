package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class Boards extends AppCompatActivity {

    private ListView boardListView;
    private String[] boardListData;
    private int[] icons = {R.drawable.boards,R.drawable.boards};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.boards);

        boardListView = (ListView) findViewById(R.id.boardsList);
        boardListData = getResources().getStringArray(R.array.boradListArray);

        BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
        boardListView.setAdapter(boardBridge);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(Boards.this,Walls.class);
        startActivity(intent);
    }
}
