package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class NotesAdapter extends BaseExpandableListAdapter {

    private Context note;

    List<String> notesHeadersData;
    HashMap<String,List<String>> notesContentData;

    NotesAdapter(Context note, List <String> notesHeadersData, HashMap <String,List<String>> notesContentData) {
        this.note = note;
        this.notesHeadersData = notesHeadersData;
        this.notesContentData = notesContentData;
    }

    @Override
    public int getGroupCount() { return notesHeadersData.size(); }

    @Override
    public int getChildrenCount(int i) {
        return notesContentData.get(notesHeadersData.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return notesHeadersData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return notesContentData.get(notesHeadersData.get(i)).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {

        String noteName = (String) getGroup(i);

        if(view==null){

            LayoutInflater noteNameInflater = (LayoutInflater) note.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = noteNameInflater.inflate(R.layout.bridge_notes_header,null);

        }

        TextView noteHeader = view.findViewById(R.id.noteName);
        noteHeader.setText(noteName);

        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {

        String noteData = (String) getChild(i,i1);

        if(view==null){

            LayoutInflater noteContentInflater = (LayoutInflater) note.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = noteContentInflater.inflate(R.layout.bridge_notes_content,null);

        }

        TextView noteContent = view.findViewById(R.id.noteContent);
        noteContent.setText(noteData);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
