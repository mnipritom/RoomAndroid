package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.r0adkll.slidr.Slidr;

public class Boards extends AppCompatActivity {

    private ListView boardListView;
    private String[] boardListData;
    private int[] icons = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Slidr.attach(this);

        Bundle receivedData = getIntent().getExtras();

        final int currentRoomNumber = receivedData.getInt("currentRoomNumber");
        final int wallNumber = receivedData.getInt("selectedWallNumber");

        if(currentRoomNumber == 0){

            setContentView(R.layout.boards);

            if(wallNumber == 0 || wallNumber == 2 || wallNumber == 3) {

                boardListView = (ListView) findViewById(R.id.boardsList);
                boardListData = getResources().getStringArray(R.array.boardListArray);

                int[] icons = {R.drawable.boards,R.drawable.boards};

                BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
                boardListView.setAdapter(boardBridge);

                boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        //finish();

                        Intent pickBoard = new Intent(Boards.this,Notes.class);
                        pickBoard.putExtra("selectedBoardNumber",position);
                        pickBoard.putExtra("currentWallNumber",wallNumber);
                        pickBoard.putExtra("currentRoomNumber",currentRoomNumber);

                        startActivity(pickBoard);
                    }
                });
            }
            else{

                boardListView = (ListView) findViewById(R.id.boardsList);
                boardListData = getResources().getStringArray(R.array.boardListArray_Room_EastWall);

                int[] icons = {R.drawable.blackboard,R.drawable.confessions};

                BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
                boardListView.setAdapter(boardBridge);

                boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        //finish();

                        Intent pickBoard = new Intent(Boards.this,Notes.class);
                        pickBoard.putExtra("selectedBoardNumber",position);
                        pickBoard.putExtra("currentWallNumber",wallNumber);
                        pickBoard.putExtra("currentRoomNumber",currentRoomNumber);

                        startActivity(pickBoard);
                    }
                });
            }
        }
        else if(currentRoomNumber == 1){

            setContentView(R.layout.boards_author);

            if(wallNumber == 0){

                boardListView = (ListView) findViewById(R.id.boardsList);
                boardListData = getResources().getStringArray(R.array.boardListArray_Author);

                int[] icons = {R.drawable.curriculum,R.drawable.contact};

                BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
                boardListView.setAdapter(boardBridge);

                boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        //finish();

                        Intent pickBoard = new Intent(Boards.this,Notes.class);
                        pickBoard.putExtra("selectedBoardNumber",position);
                        pickBoard.putExtra("currentWallNumber",wallNumber);
                        pickBoard.putExtra("currentRoomNumber",currentRoomNumber);

                        startActivity(pickBoard);
                    }
                });

            }
            else if(wallNumber == 1){

                //setContentView(R.layout.boards);

                boardListView = (ListView) findViewById(R.id.boardsList);
                boardListData = getResources().getStringArray(R.array.boardListArray);

                int[] icons = {R.drawable.boards,R.drawable.boards};

                BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
                boardListView.setAdapter(boardBridge);

                boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        //finish();

                        Intent pickBoard = new Intent(Boards.this,Notes.class);
                        pickBoard.putExtra("selectedBoardNumber",position);
                        pickBoard.putExtra("currentWallNumber",wallNumber);
                        pickBoard.putExtra("currentRoomNumber",currentRoomNumber);

                        startActivity(pickBoard);
                    }
                });

            }
            else if(wallNumber == 2){

                //setContentView(R.layout.boards);

                boardListView = (ListView) findViewById(R.id.boardsList);
                boardListData = getResources().getStringArray(R.array.boardListArray);

                int[] icons = {R.drawable.boards,R.drawable.boards};

                BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
                boardListView.setAdapter(boardBridge);

                boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        //finish();

                        Intent pickBoard = new Intent(Boards.this,Notes.class);
                        pickBoard.putExtra("selectedBoardNumber",position);
                        pickBoard.putExtra("currentWallNumber",wallNumber);
                        pickBoard.putExtra("currentRoomNumber",currentRoomNumber);

                        startActivity(pickBoard);
                    }
                });

            }
            else{

                //setContentView(R.layout.boards);

                boardListView = (ListView) findViewById(R.id.boardsList);
                boardListData = getResources().getStringArray(R.array.boardListArray);

                int[] icons = {R.drawable.boards,R.drawable.boards};

                BoardAdapter boardBridge = new BoardAdapter(this,boardListData,icons);
                boardListView.setAdapter(boardBridge);

                boardListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                        //finish();

                        Intent pickBoard = new Intent(Boards.this,Notes.class);
                        pickBoard.putExtra("selectedBoardNumber",position);
                        pickBoard.putExtra("currentWallNumber",wallNumber);
                        pickBoard.putExtra("currentRoomNumber",currentRoomNumber);

                        startActivity(pickBoard);
                    }
                });

            }


        }







    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
