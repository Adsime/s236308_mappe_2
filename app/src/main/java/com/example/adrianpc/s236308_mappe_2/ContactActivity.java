package com.example.adrianpc.s236308_mappe_2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ContactActivity extends AppCompatActivity implements EditContactFragment.EditListener{

    EditContactFragment editContactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        editContactFragment = new EditContactFragment(this);
        getSupportFragmentManager().beginTransaction().add(R.id.edit_contact_info_container, editContactFragment, "").commit();
    }

    @Override
    public void onEditRequest() {
        editContactFragment.changeEditMode();
    }
}
