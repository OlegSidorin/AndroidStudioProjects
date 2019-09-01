package com.sidorin.contactlist;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FragmentForEditContact extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters


    public FragmentForEditContact() {
        // Required empty public constructor
    }
    String selectedSurname, selectedName;

    public void setSelectedSurname(String selectedSurname) {
        this.selectedSurname = selectedSurname;
    }
    public void setSelectedName(String selectedName) {
        this.selectedName = selectedName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for_edit_contact_layout, container, false);
        if (view != null) {
            TextView surname = view.findViewById(R.id.inputSecondName);
            surname.setText(selectedSurname);
            TextView name = view.findViewById(R.id.inputFirstName);
            name.setText(selectedName);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
