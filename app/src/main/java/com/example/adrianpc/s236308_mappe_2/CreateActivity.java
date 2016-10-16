package com.example.adrianpc.s236308_mappe_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CreateActivity extends AppCompatActivity implements MenuFragment.MenuListener{

    private MenuFragment menuFragment;
    private CreateContactFragment createContactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuFragment = new MenuFragment(this);
        createContactFragment = new CreateContactFragment();
        setContentView(R.layout.activity_create);
        getSupportFragmentManager().beginTransaction().add(R.id.create_menu_container, menuFragment, "")
                .add(R.id.create_contact_container, createContactFragment, "").commit();
    }

    @Override
    public void onInteraction(int interactionID) {
        switch (interactionID) {
            case MenuFragment.EXIT_ID: {
                onBackPressed();
            }
        }
    }
}
