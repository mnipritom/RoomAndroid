package com.example.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BoardAdapter extends BaseAdapter {

    int[] icons;
    String[] boardsListData;
    Context board;

    private LayoutInflater BoardListViewInflater;

    BoardAdapter(Context board, String[] boardsListData, int[] icons)
    {
        this.board = board;
        this.boardsListData = boardsListData;
        this.icons = icons;
    }

    @Override
    public int getCount() { return boardsListData.length; }

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
            BoardListViewInflater = (LayoutInflater) board.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            CreatedListView = BoardListViewInflater.inflate(R.layout.bridge_boards,parent,false);
        }

        ImageView icon = (ImageView) CreatedListView.findViewById(R.id.boardIcon);
        TextView boardName = CreatedListView.findViewById(R.id.boardName);

        icon.setImageResource(icons[position]);
        boardName.setText(boardsListData[position]);

        return CreatedListView;
    }
}
