package com.example.adrianpc.s236308_mappe_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.adrianpc.s236308_mappe_2.database.Contact;
import com.example.adrianpc.s236308_mappe_2.database.Database;

public class MainActivity extends AppCompatActivity implements ContactFragment.OnListFragmentInteractionListener {

    private RecyclerView recyclerView;
    private ContactFragment contactFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactFragment = new ContactFragment();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.view_contactlist);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ContactAdapter(Database.getContacts(), this));
        getFragmentManager().beginTransaction().add(R.id.activity_main, contactFragment, "").addToBackStack(null).commit();
    }

    @Override
    public void onListFragmentInteraction(Contact contact) {

    }
}
