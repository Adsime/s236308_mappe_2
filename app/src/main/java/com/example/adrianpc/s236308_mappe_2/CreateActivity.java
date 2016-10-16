package com.example.adrianpc.s236308_mappe_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateActivity extends AppCompatActivity implements MenuFragment.MenuListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
    }

    @Override
    public void onInteraction(int interactionID) {

    }
}
