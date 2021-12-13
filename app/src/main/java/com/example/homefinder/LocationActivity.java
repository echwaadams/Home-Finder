package com.example.homefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocationActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.locationTextView)
    TextView mLocationTextView;
    @BindView(R.id.locationEditText)
    EditText mLocationEditText;
    @BindView(R.id.findHomesButton)
    Button mFindHomesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        //binding views
        ButterKnife.bind(this);

        //setting clicklistener
        mFindHomesButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        // user input
        String homes = mLocationEditText.getText().toString();
        Intent intent = new Intent(LocationActivity.this, VenuesActivity.class);
        intent.putExtra("homes",homes);
        startActivity(intent);
    }

}