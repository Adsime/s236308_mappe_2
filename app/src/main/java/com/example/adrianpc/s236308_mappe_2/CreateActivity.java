package com.example.adrianpc.s236308_mappe_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adrianpc.s236308_mappe_2.database.Contact;
import com.example.adrianpc.s236308_mappe_2.utilities.Validator;

public class CreateActivity extends AppCompatActivity implements MenuFragment.MenuListener, CreateContactFragment.CreateContactListener{

    private MenuFragment menuFragment;
    private CreateContactFragment createContactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        menuFragment = new MenuFragment(this);
        createContactFragment = new CreateContactFragment(this);
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

    @Override
    public void onSaveClicked(Contact contact) {
        System.out.println(Validator.validateContact(contact));
    }
}
