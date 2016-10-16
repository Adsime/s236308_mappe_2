package com.example.adrianpc.s236308_mappe_2;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.adrianpc.s236308_mappe_2.database.Contact;
import com.example.adrianpc.s236308_mappe_2.utilities.Converter;
import com.example.adrianpc.s236308_mappe_2.utilities.Validator;

import java.util.Calendar;

public class CreateContactFragment extends Fragment {

    private CreateContactListener listener;
    private View view;
    private EditText name, phonenumber, birthday;
    private ImageButton save, camera;

    public CreateContactFragment(CreateContactListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_create_contact, container, false);
        name = (EditText) view.findViewById(R.id.create_fragment_name);
        phonenumber = (EditText) view.findViewById(R.id.create_fragment_phone);
        birthday = (EditText) view.findViewById(R.id.create_fragment_birthday);
        save = (ImageButton) view.findViewById(R.id.create_save);
        camera = (ImageButton) view.findViewById(R.id.create_camera);
        setSaveListener();
        setDatePickerListener();
        return view;
    }

    private void setSaveListener() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onSaveClicked(new Contact(name.getText().toString(),
                        birthday.getText().toString(),
                        null, Integer.parseInt(phonenumber.getText().toString())));
            }
        });
    }

    private void setDatePickerListener() {
        birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    boolean fired = false;
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        if(!fired) {
                            StringBuilder stringBuilder = new StringBuilder().append(Converter.convertToDateString(day, month, year));
                            int[] d = Converter.convertDateString(stringBuilder.toString());
                            if (Validator.validateBirthdate(d[2], d[1], d[0])) {
                                new AlertDialog.Builder(getActivity()).setNeutralButton(android.R.string.ok, null)
                                        .setMessage("yoyoyoyo").show();
                                fired = true;
                            } else {
                                birthday.setText(stringBuilder.toString());
                            }
                        }
                    }
                }, Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DATE)).show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public interface CreateContactListener {
        void onSaveClicked(Contact contact);
    }
}
