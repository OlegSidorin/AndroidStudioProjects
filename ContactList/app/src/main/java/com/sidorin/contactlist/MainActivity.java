package com.sidorin.contactlist;

import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

import android.view.View;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    static ArrayList<DataItem> data;
    static AdapterForRV adapter;
    static RecyclerView myRecyclerView;
    private Toolbar toolbar;
    static DataItem selectedItem;
    String selectedSurname, selectedName;

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_add:
                FragmentForEditContact fragment = new FragmentForEditContact();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.setCustomAnimations(R.anim.fade_in,
                        R.anim.fade_out);
                fragmentTransaction.add(R.id.fragment_main_container, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                selectedSurname = data.get(adapter.selected_position).surname;
                selectedName = data.get(adapter.selected_position).name;
                fragment.setSelectedSurname(selectedSurname);
                fragment.setSelectedName(selectedName);
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
        if (requestCode == 1111 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String surname = data.getStringExtra("surname");
            String who = data.getStringExtra("who");
            String gender = data.getStringExtra("gender");
            int type = data.getIntExtra("type", 0);
            int pos = data.getIntExtra("position", -1);
            DataItem item = this.data.get(pos);
            item.name = name;
            item.surname = surname;
            item.type = type;
            item.who = who;
            item.gender = "f";
            adapter.notifyItemChanged(pos);
        } else {
            if (requestCode == 2222 && resultCode == RESULT_OK && data != null) {
                String name = data.getStringExtra("name");
                String surname = data.getStringExtra("surname");
                String who = data.getStringExtra("who");
                //String gender = data.getStringExtra("gender");

                int type = data.getIntExtra("type", 0);
                DataItem item = new DataItem(name, surname, "f", who, type);
                MainActivity.this.data.add(item);
                TextView tv_info = findViewById(R.id.tv_info_one);
                tv_info.setText("" + adapter.getItemCount() + name + surname + who);
                adapter.notifyItemInserted(adapter.getItemCount() - 1);
                // adapter.notifyItemInserted(1);
                adapter.notifyItemRangeChanged(adapter.getItemCount() - 1, adapter.getItemCount());
            }
        }
    }


}
