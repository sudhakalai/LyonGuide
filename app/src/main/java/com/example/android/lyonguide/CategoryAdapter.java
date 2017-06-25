package com.example.android.lyonguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Sudha on 23-May-17.
 */

public class CategoryAdapter extends FragmentPagerAdapter {

    //Global variable declaration
    private Context mContext;

    //Constructor declaration
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    //Overriding getPageTitle method
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.parks);
        } else if (position == 1) {
            return mContext.getString(R.string.museums);
        } else if (position == 2) {
            return mContext.getString(R.string.churches);
        } else {
            return mContext.getString(R.string.places);
        }
    }

    //Overriding getItem method
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new ParksFragment();
        } else if (position == 1) {
            return new MuseumsFragment();
        } else if (position == 2) {
            return new ChurchesFragment();
        } else {
            return new PlacesFragment();
        }
    }

    //Overriding getCount method
    @Override
    public int getCount() {
        return 4;
    }
}
