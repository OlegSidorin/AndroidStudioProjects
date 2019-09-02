package com.sidorin.contactlist;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class FragmentForEditContact extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters


    public FragmentForEditContact()  {
        // Required empty public constructor
    }
    String selectedSurname, selectedName;
    DataItem dataItem;

    public void setDataItem(DataItem dataItem) {
        this.dataItem = dataItem;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for_edit_contact_layout, container, false);
        if (view != null) {
            TextView surname = view.findViewById(R.id.inputSecondName);
            TextView name = view.findViewById(R.id.inputFirstName);
            ImageView imageView = view.findViewById(R.id.contactPhoto);
            Spinner spinner = view.findViewById(R.id.spinner_of_types);
            surname.setText(dataItem.surname);
            name.setText(dataItem.name);
            imageView.setImageResource(dataItem.src);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getBaseContext(),
                    android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.types));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setSelection(dataItem.type);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

    }
}
