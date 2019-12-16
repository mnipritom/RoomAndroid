package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RoomAdapter extends BaseAdapter {

    int[] roomAdapterIcons;
    String[] roomListData;
    Context room;

    private LayoutInflater RoomListViewInflater;

    RoomAdapter(Context room, String[] roomListData, int[] roomAdapterIcons){
        this.room = room;
        this.roomListData = roomListData;
        this.roomAdapterIcons = roomAdapterIcons;
    }


    @Override
    public int getCount() {
        return roomListData.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View CreatedListView, ViewGroup parent) {

        if(CreatedListView==null){
            RoomListViewInflater =  (LayoutInflater) room.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            CreatedListView = RoomListViewInflater.inflate(R.layout.bridge_rooms,parent,false);
        }

        ImageView icon = (ImageView) CreatedListView.findViewById(R.id.roomIcon);
        TextView roomName = (TextView) CreatedListView.findViewById(R.id.roomName);

        icon.setImageResource(roomAdapterIcons[position]);
        roomName.setText(roomListData[position]);

        return CreatedListView;
    }
    //getView() gets called automatically, no need to make explicit call
}
