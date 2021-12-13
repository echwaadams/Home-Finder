package com.example.homefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VenuesActivity extends AppCompatActivity{
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;

    private String[] venues = new String[] {"Conference hall","Restaurant","Hotel", "Business centre",
            "Sport Club","Art gallery", "Academic Venues", "Stately home","Arena","Park"
            , "Field"};
    private String[] capacities= new String[] {"networking events, business meetings and presentation: Available",
            "networking events, business meetings and presentation: Not Available", "networking events, business meetings and presentation:Not Available",
            "networking events, business meetings and presentation: Not Available", "networking events, business meetings and presentation: Available",
            "networking events, business meetings and presentation: Available", "networking events, business meetings and presentation: Available",
            "networking events, business meetings and presentation:Available", "networking events, business meetings and presentation: Available",
            "networking events, business meetings and presentation: Available", "networking events, business meetings and presentation: Not available",
            "networking events, business meetings and presentation: Available", "networking events, business meetings and presentation: Not Available"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venues);
        //Binding views
        ButterKnife.bind(this);

        //Arraydapter
        VenuesArrayAdapter adapter = new VenuesArrayAdapter(this, android.R.layout.simple_list_item_1, venues, capacities);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String venues = ((TextView)view).getText().toString();
                Toast.makeText(VenuesActivity.this, venues, Toast.LENGTH_LONG).show();
            }
        });
        Intent intent = getIntent();
        mLocationTextView.setText("Here are all the location available: ");

    }

}