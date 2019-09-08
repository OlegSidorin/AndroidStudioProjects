package com.sidorin.contactlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener {
    static ArrayList<DataItem> data;
    static AdapterForRV adapter;
    static RecyclerView myRecyclerView;
    private Toolbar toolbar;
    static DataItem selectedItem;
    String selectedSurname, selectedName;

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_edit:
                FragmentForEditContact fragment = new FragmentForEditContact();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.go_up,
                        R.anim.go_down);
                fragmentTransaction.add(R.id.fragment_main_container, fragment);
                // fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragment.setDataItem(data.get(adapter.selected_position));
                fragment.setPosition(adapter.selected_position);
                TextView textView= findViewById(R.id.info_text_2);
                textView.setText("Контакт "+adapter.selected_position + " (" + data.get(adapter.selected_position).surname + ") : редактирование");

                return true;
        }
        return false;
    }


    @Override // запуск прииложения
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);
        initToolbar();

        myRecyclerView = findViewById(R.id.rc_view);
        data = DataItem.dataGenerator(this);
        adapter = new AdapterForRV(data);
        myRecyclerView.setAdapter(adapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView tv_info = findViewById(R.id.tv_info_one);
        tv_info.setText("" + adapter.getItemCount());

    }

    private void initToolbar() {
        setSupportActionBar(toolbar);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        toolbar.setOnMenuItemClickListener(this);
        toolbar.inflateMenu(R.menu.menu);
    }

    @Override // возврат в активность с интентом
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (true) {
            // adapter.notifyItemChanged(pos);
        } else {
            if (true) {

               // adapter.notifyItemInserted(adapter.getItemCount() - 1);
                       // adapter.notifyItemInserted(1);
               // adapter.notifyItemRangeChanged(adapter.getItemCount() - 1, adapter.getItemCount());
            }
        }
    }


}
