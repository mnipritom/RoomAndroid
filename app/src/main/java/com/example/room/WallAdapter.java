package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WallAdapter extends BaseAdapter {

    int[] wallAdapterIcons;
    String[] wallListData;
    Context wall;

    private LayoutInflater WallGridViewInflater;

    WallAdapter(Context wall, String[] wallListData, int[] wallAdapterIcons){
        this.wall = wall;
        this.wallListData = wallListData;
        this.wallAdapterIcons = wallAdapterIcons;
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
            WallGridViewInflater = (LayoutInflater) wall.getSystemService(wall.LAYOUT_INFLATER_SERVICE);
            CreatedGridView = WallGridViewInflater.inflate(R.layout.bride_walls,parent,false);
        }

        ImageView icon =  (ImageView) CreatedGridView.findViewById(R.id.wallIcon);
        TextView wallName = (TextView) CreatedGridView.findViewById(R.id.wallName);

        icon.setImageResource(wallAdapterIcons[position]);
        wallName.setText(wallListData[position]);

        return CreatedGridView;
    }
}
