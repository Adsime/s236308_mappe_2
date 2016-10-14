package com.example.adrianpc.s236308_mappe_2;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adrianpc.s236308_mappe_2.database.Contact;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactHolder> {

    private List<Contact> contacts;
    private ContactFragment.OnListFragmentInteractionListener mListener;

    public ContactAdapter(List<Contact> contacts, ContactFragment.OnListFragmentInteractionListener listener) {
        this.contacts = contacts;
        mListener = listener;
    }

    @Override
    public ContactHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_contact, parent, false);
        return new ContactHolder(view);
    }

    @Override
    public void onBindViewHolder(ContactHolder holder, int position) {
        Contact current = contacts.get(position);
        holder.name.setText(current.getFirstname() + " " + current.getLastname());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ContactHolder extends RecyclerView.ViewHolder {
        CardView card;
        ImageView contactImage;
        TextView name;
        ImageButton delete;
        public ContactHolder(View view) {
            super(view);
            card = (CardView) view.findViewById(R.id.card);
            contactImage = (ImageView) view.findViewById(R.id.card_image);
            name = (TextView) view.findViewById(R.id.card_name);
            delete = (ImageButton) view.findViewById(R.id.card_delete);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
