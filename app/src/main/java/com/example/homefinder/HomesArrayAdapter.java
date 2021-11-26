package com.example.homefinder;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class HomesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mHomes;
    private String[] mDescription;


    public HomesArrayAdapter( Context mContext, int resource, String[] mHomes, String[] mDescription) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mContext = mContext;
        this.mDescription = mDescription;

    }
    @Override
    public Object getItem(int position){
        String homes = mHomes[position];
        String description = mDescription[position];
        return  String.format("%s \n Description: %s", homes,description);
    }
    @Override
    public int getCount(){
        return mHomes.length;
    }
}
