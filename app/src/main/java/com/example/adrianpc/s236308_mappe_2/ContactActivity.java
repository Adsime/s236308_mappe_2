package com.example.adrianpc.s236308_mappe_2;

import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adrianpc.s236308_mappe_2.database.Contact;
import com.example.adrianpc.s236308_mappe_2.database.Database;

public class ContactActivity extends AppCompatActivity implements EditContactFragment.EditListener, MenuFragment.MenuListener{

    private EditContactFragment editContactFragment;
    private MenuFragment menuFragment;
    private Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Contact contact = (Contact)getIntent().getSerializableExtra("contact");
        setContentView(R.layout.activity_edit_contact);
        menuFragment = new MenuFragment(this);
        editContactFragment = new EditContactFragment(this, contact);
        getSupportFragmentManager().beginTransaction().add(R.id.edit_contact_info_container, editContactFragment, "").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.edit_menu_container, menuFragment, "").commit();
    }

    @Override
    public void onEditRequest() {
        editContactFragment.changeEditMode();
    }

    @Override
    public void onInteraction(int interactionID) {
        switch (interactionID) {
            case MenuFragment.EXIT_ID :{
                onBackPressed();
            }
        }
    }
}
