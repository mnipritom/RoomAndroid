package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class Rooms extends AppCompatActivity {

    private ListView roomsListView;
    private String[] roomsListData;
    private int[] icons = {R.drawable.door,R.drawable.curriculum,R.drawable.shop,R.drawable.friends};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rooms);

        roomsListView = (ListView)findViewById(R.id.roomsList);
        roomsListData = getResources().getStringArray(R.array.roomsListArray);

        RoomAdapter roomBridge = new RoomAdapter(this,roomsListData,icons);
        roomsListView.setAdapter(roomBridge);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(Rooms.this,Notes.class);
        startActivity(intent);
    }
}
