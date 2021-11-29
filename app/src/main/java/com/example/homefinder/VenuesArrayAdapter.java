package com.example.homefinder;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class HomesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mVenues;
    private String[] mCapacity;


    public HomesArrayAdapter( Context mContext, int resource, String[] mVenues, String[] mCapacity) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mVenues = mVenues;
        this.mCapacity= mCapacity;

    }
    @Override
    public Object getItem(int position){
        String venues = mVenues[position];
        String capacity = mCapacity[position];
        return  String.format("%s \n Best suited for: %s", venues,capacity);
    }
    @Override
    public int getCount(){
        return mVenues.length;
    }
}
