package com.sidorin.contactlist;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static com.sidorin.contactlist.MainActivity.adapter;


public class FragmentForEditContact extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters


    public FragmentForEditContact() {
        // Required empty public constructor
    }

    static DataItem dataItem;
    static int position;

    public void setDataItem(DataItem dataItem) {
        this.dataItem = dataItem;
    }

    public void setPosition(int position){
        this.position = position;
    }

    public DataItem getDataItem() {
        return dataItem;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_for_edit_contact_layout, container, false);
        if (view != null) {
            // из активности мы устанавливаем DataItem методом setDataItem в и далее берем из нее данные
            TextView tv_surname = view.findViewById(R.id.inputSecondName);
            TextView tv_name = view.findViewById(R.id.inputFirstName);
            ImageView imageView = view.findViewById(R.id.contactPhoto);
            Spinner spinner = view.findViewById(R.id.spinner_of_types);
            tv_surname.setText(dataItem.surname);
            tv_name.setText(dataItem.name);
            imageView.setImageResource(dataItem.src);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getActivity().getBaseContext(),
                    android.R.layout.simple_spinner_item,
                    getResources().getStringArray(R.array.types));
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);
            spinner.setSelection(dataItem.type);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();
        final Button button = view.findViewById(R.id.btn_save_contact);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        View viewRoot = getView().getRootView();
        TextView textView = viewRoot.findViewById(R.id.info_text_2);

        View viewOfFragment = getView();
        TextView tv_surname = viewOfFragment.findViewById(R.id.inputSecondName);
        TextView tv_name = viewOfFragment.findViewById(R.id.inputFirstName);
        Spinner spinner = viewOfFragment.findViewById(R.id.spinner_of_types);
        ImageView iv_picOfAccount = viewOfFragment.findViewById(R.id.contactPhoto);



        dataItem.name = tv_name.getText().toString();
        dataItem.surname = tv_surname.getText().toString();
        //dataItem.gender = "f";
        dataItem.who = spinner.getSelectedItem().toString();
        dataItem.type = spinner.getSelectedItemPosition();
        //dataItem.src = 0;

        BlankFragment fragment = new BlankFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.fade_in,
                R.anim.fade_out);
        fragmentTransaction.replace(R.id.fragment_main_container, fragment);
        // fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        MainActivity.data.set(position,dataItem);
        MainActivity.adapter.notifyItemChanged(position);
        textView.setText("Контакт " + dataItem.surname
                + " сохранен в позицию " + (position+1) + " списка");

        //view1.animate().rotation(100);
    }
/**
    public static void hideKeyboard(Context context) {

        try {
            ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            if ((((Activity) context).getCurrentFocus() != null) && (((Activity) context).getCurrentFocus().getWindowToken() != null)) {
                ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showKeyboard(Context context) {
        ((InputMethodManager) (context).getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
*/

}
