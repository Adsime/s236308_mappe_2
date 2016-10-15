package com.example.adrianpc.s236308_mappe_2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class MenuFragment extends Fragment {

    public static final int EXIT_ID = 1000;
    public static final int ACTIVATE_DELETE_ID = 1001;
    public static final int DEACTIVATE_DELETE_ID = 1002;

    private ImageButton first_left, second_left, third_left, fourth_left;
    private View view;

    private MenuListener listener;

    public MenuFragment(MenuListener listener) {
        this.listener = listener;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_menu, container, false);
        ((ImageButton)view.findViewById(R.id.menu_exit_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onInteraction(EXIT_ID);
            }
        });
        first_left = (ImageButton) view.findViewById(R.id.menubutton_first_from_left);
        second_left = (ImageButton) view.findViewById(R.id.menubutton_second_from_left);
        third_left = (ImageButton) view.findViewById(R.id.menubutton_third_from_left);
        fourth_left = (ImageButton) view.findViewById(R.id.menubutton_fourth_from_left);
        setMainMenu();
        return view;
    }

    private void clearMenu() {
        first_left.setClickable(false);
        second_left.setClickable(false);
        third_left.setClickable(false);
        fourth_left.setClickable(false);
        first_left.setImageResource(0);
        second_left.setImageResource(0);
        third_left.setImageResource(0);
        fourth_left.setImageResource(0);
    }

    public void setMainMenu() {
        clearMenu();
        fourth_left.setImageResource(android.R.drawable.ic_menu_delete);
        fourth_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onInteraction(ACTIVATE_DELETE_ID);
            }
        });
    }

    public void setDeleteMenu() {
        clearMenu();
        fourth_left.setImageResource(android.R.drawable.ic_menu_save);
        fourth_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onInteraction(DEACTIVATE_DELETE_ID);
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

    public interface MenuListener {
        void onInteraction(int interactionID);
    }
}
