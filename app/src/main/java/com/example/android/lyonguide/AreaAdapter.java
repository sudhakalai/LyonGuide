package com.example.android.lyonguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sudha on 24-May-17.
 */

public class AreaAdapter extends ArrayAdapter<Area> {

    //Global variable declaration
    private int mColorResourceId;

    //Constructor declaration
    public AreaAdapter(Context context, int resource, ArrayList<Area> area) {
        super(context, 0, area);
        mColorResourceId = resource;
    }

    //Overriding the getView method
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.item_structure, parent, false);
        }

        //Getting the object in this position of the list
        Area currentArea = getItem(position);

        //Finding the view and setting the area name to it
        TextView areaName = (TextView) listItemView.findViewById(R.id.text1);

        areaName.setText(currentArea.getAreaName());

        //Finding the view and setting the description to it
        TextView areaDescription = (TextView) listItemView.findViewById(R.id.text2);

        areaDescription.setText(currentArea.getAreaDescription());

        //Finding the view and setting the image to it
        ImageView areaImage = (ImageView) listItemView.findViewById(R.id.image1);

        areaImage.setImageResource(currentArea.getImageResourceId());

        //Setting the color
        View textContainer = listItemView.findViewById(R.id.list_container);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
