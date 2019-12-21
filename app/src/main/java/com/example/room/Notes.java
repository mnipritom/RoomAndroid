package com.example.room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;

import com.r0adkll.slidr.Slidr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import maes.tech.intentanim.CustomIntent;

public class Notes extends AppCompatActivity {

    private ExpandableListView noteXView;

    private NotesAdapter noteBridge;

    List <String> notesHeadersData;
    HashMap <String,List<String>> notesContentData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Slidr.attach(this);

        Bundle receivedData = getIntent().getExtras();

        int currentRoomNumber = receivedData.getInt("currentRoomNumber");
        int currentWallNumber = receivedData.getInt("currentWallNumber");
        int currentBoardNumber = receivedData.getInt("selectedBoardNumber");

        if(currentRoomNumber == 0){
            if(currentWallNumber == 0 || currentWallNumber == 2 || currentWallNumber == 3){
                if(currentBoardNumber == 0 || currentBoardNumber == 1){
                    setContentView(R.layout.no_content_view);
                }
            }
            else{
                if(currentBoardNumber == 1){
                    setContentView(R.layout.notes);

                    populateNotes();

                    noteXView =(ExpandableListView) findViewById(R.id.notesXList);

                    noteBridge = new NotesAdapter(this,notesHeadersData,notesContentData);
                    noteXView.setAdapter(noteBridge);
                }

            }
        }
        if(currentRoomNumber == 1){
            //Dear Diary note view
        }
        else{
            //Shop note view
        }




    }

    public void populateNotes(){

        String[] notesHeaders = getResources().getStringArray(R.array.notesHeadings);
        String[] noteContent = getResources().getStringArray(R.array.notesParagraphs);

        notesHeadersData = new ArrayList<>();
        notesContentData = new HashMap<>();

        for(int i=0; i<notesHeaders.length; i++){

            notesHeadersData.add(notesHeaders[i]);

            List <String> Content = new ArrayList<>();
            Content.add(noteContent[i]);

            notesContentData.put(notesHeadersData.get(i),Content);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        CustomIntent.customType(Notes.this,"right-to-left");
    }

}
