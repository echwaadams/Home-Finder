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

public class HomesActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.listView)
    ListView mListView;

    private String[] homes = new String[] {"Apartment","Bungalow","Cabin", "Chalet House",
            "Condominium","Condor", "Cottage", "Flat","Mansion","Multi-family House"
            , "Ranch-style house","Single-family","Tower","Tiny Home", "Townhome" };
    private String[] description = new String[] {"Vegan Food", "Breakfast", "Fishs Dishs",
            "Scandinavian", "Coffee", "English Food", "Burgers", "Fast Food", "Noodle Soups",
            "Mexican", "BBQ", "Cuban", "Bar Food", "Sports Bar", "Breakfast", "Mexican" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homes);
        //Binding views
        ButterKnife.bind(this);

        //Arraydapter
        HomesArrayAdapter adapter = new HomesArrayAdapter(this,android.R.layout.simple_list_item_1,homes,description);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String homes = ((TextView)view).getText().toString();
                Toast.makeText(HomesActivity.this, homes, Toast.LENGTH_LONG).show();
            }
        });
        //Generating data from intent Extras
        Intent intent = getIntent();
        String homes = intent.getStringExtra("homes");
        mLocationTextView.setText("Her are all the homes near: " + homes );
    }
}