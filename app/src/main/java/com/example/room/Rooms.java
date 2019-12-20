package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Rooms extends AppCompatActivity {

    private ListView roomsListView;
    private String[] roomsListData;
    private int[] icons = {R.drawable.rooms,R.drawable.diary,R.drawable.shop};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rooms);

        roomsListView = (ListView)findViewById(R.id.roomsList);
        roomsListData = getResources().getStringArray(R.array.roomsListArray);

        RoomAdapter roomBridge = new RoomAdapter(this,roomsListData,icons);
        roomsListView.setAdapter(roomBridge);

        roomsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                finish();

                Intent enterRoom = new Intent(Rooms.this,Walls.class);
                enterRoom.putExtra("selectedRoomNumber",position);

                startActivity(enterRoom);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent intent = new Intent(Rooms.this,Notes.class);
        startActivity(intent);
    }
}
