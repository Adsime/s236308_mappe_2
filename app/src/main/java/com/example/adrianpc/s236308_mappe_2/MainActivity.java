package com.example.adrianpc.s236308_mappe_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.adrianpc.s236308_mappe_2.database.Contact;
import com.example.adrianpc.s236308_mappe_2.database.Database;

public class MainActivity extends AppCompatActivity implements ContactFragment.OnListFragmentInteractionListener, MenuFragment.MenuListener {

    private ContactFragment contactFragment;
    private MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactFragment = new ContactFragment(this);
        menuFragment = new MenuFragment(this);
        getSupportFragmentManager().beginTransaction().add(R.id.menu_container, menuFragment, "").commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, contactFragment, "").addToBackStack(null).commit();
    }

    @Override
    public void onDeleteRequest(View view, int id) {
        contactFragment.delete(id);
    }

    @Override
    public void onLongInteraction() {
        if(contactFragment.isInDeleteMode()) {
            menuFragment.setMainMenu();
        } else {
            menuFragment.setDeleteMenu();
        }
        contactFragment.changeDeletable();
    }

    public void startAddActivity(Contact contact) {
        Intent intent = new Intent(this, ContactActivity.class);
        intent.putExtra("contact", contact);
        startActivity(intent);
    }

    @Override
    public void onDelete(int id) {
        contactFragment.delete(id);
    }

    @Override
    public void onInteraction(int id) {
        switch (id) {
            case MenuFragment.EXIT_ID :{
                finish();
                break;
            }case MenuFragment.ACTIVATE_DELETE_ID :{
                contactFragment.changeDeletable();
                menuFragment.setDeleteMenu();
                break;
            } case MenuFragment.DEACTIVATE_DELETE_ID:{
                contactFragment.changeDeletable();
                menuFragment.setMainMenu();
            } case MenuFragment.ADD_ID:{
                startAddActivity(null);
            }
        }
    }
}
