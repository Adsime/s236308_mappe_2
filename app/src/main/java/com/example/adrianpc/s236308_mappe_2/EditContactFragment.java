package com.example.adrianpc.s236308_mappe_2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.adrianpc.s236308_mappe_2.database.Contact;
import com.example.adrianpc.s236308_mappe_2.utilities.Converter;

public class EditContactFragment extends Fragment {

    private Contact current;
    private View view;
    private EditText name, birthday, phonenumber;
    private ImageView contactImage;
    private boolean editMode;
    private ImageButton editButton, cameraButton;
    EditListener listener;

    public EditContactFragment(EditListener listener, Contact current) {
        this.current = current;
        this.listener = listener;
    }

    private void setContact() {
        name.setText(current.getName());
        phonenumber.setText(String.valueOf(current.getPhonenumber()));
        birthday.setText(current.getBirthdate());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        editMode = false;
        view = inflater.inflate(R.layout.fragment_edit_contact, container, false);
        name = (EditText) view.findViewById(R.id.edit_fragment_name);
        birthday = (EditText) view.findViewById(R.id.edit_fragment_birthday);
        phonenumber = (EditText) view.findViewById(R.id.edit_fragment_phone);
        contactImage = (ImageView) view.findViewById(R.id.edit_contact_image);
        cameraButton = (ImageButton) view.findViewById(R.id.edit_camera_button);
        editButton = (ImageButton) view.findViewById(R.id.edit_edit_button);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEditRequest();
            }
        });
        setContact();
        return view;
    }

    public void changeEditMode() {
        editMode = !editMode;
        editButton.setImageResource((editMode)?android.R.drawable.ic_menu_save:android.R.drawable.ic_menu_edit);
        editTextFix(name);
        editTextFix(phonenumber);
        birthday.setOnClickListener((!editMode)?null:new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] date = Converter.convertDateString(current.getBirthdate());
            }
        });
    }

    private void editTextFix(EditText editText) {
        editText.setFocusable(editMode);
        editText.setFocusableInTouchMode(editMode);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }



    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface EditListener {
        void onEditRequest();
    }
}
