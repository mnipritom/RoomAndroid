package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WallAdapter extends BaseAdapter {

    int[] icons;
    String[] wallListData;
    Context wall;

    private LayoutInflater WallGridViewInflater;

    WallAdapter(Context wall, String[] wallListData, int[] icons ){
        this.wall = wall;
        this.wallListData = wallListData;
        this.icons= icons;
    }

    @Override
    public int getCount() { return wallListData.length; }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View CreatedGridView, ViewGroup parent) {

        if(CreatedGridView==null){
            WallGridViewInflater =  (LayoutInflater) wall.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            CreatedGridView = WallGridViewInflater.inflate(R.layout.bridge_walls,parent,false);
        }

        ImageView icon = (ImageView) CreatedGridView.findViewById(R.id.wallIcon);
        TextView roomName = CreatedGridView.findViewById(R.id.wallName);

        icon.setImageResource(icons[position]);
        roomName.setText(wallListData[position]);

        return CreatedGridView;
    }
}
