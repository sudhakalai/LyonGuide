package com.example.android.lyonguide;

import android.widget.ArrayAdapter;

/**
 * Created by Sudha on 24-May-17.
 */

public class Area {

    //Global variable declaration

    private String mAreaName;
    private String mAreaDescription;
    private int mImageResourceId;
    private String mWebLink;

    //Constructor declaration

    public Area(String areaName, String areaDescription, int imageResourceId, String webLink) {
        mAreaName = areaName;
        mAreaDescription = areaDescription;
        mImageResourceId = imageResourceId;
        mWebLink = webLink;
    }

    //Getter Methods

    public String getAreaName() {
        return mAreaName;
    }

    public String getAreaDescription() {
        return mAreaDescription;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public String getWebLink() {
        return mWebLink;
    }
}
