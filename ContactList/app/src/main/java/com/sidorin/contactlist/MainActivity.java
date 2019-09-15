package com.sidorin.contactlist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.os.PersistableBundle;
import android.view.MenuItem;

import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
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
    private SQLiteDatabase db;
    private Cursor cursor;

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
                TextView textView = findViewById(R.id.info_text_2);
                textView.setText("Контакт " + adapter.selected_position + " (" + data.get(adapter.selected_position).surname + ") : редактирование");

                return true;
        }
        return false;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("string", "перевернулись и сохранились");

    }

    @Override // запуск прииложения
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            selectedName = savedInstanceState.getString("string");
        }
        setContentView(R.layout.main_activity_layout);
        initToolbar();

        ContactsDBHelper contactsDBHelper = new ContactsDBHelper(this);
        try {
            SQLiteDatabase db = contactsDBHelper.getReadableDatabase();
            // db.execSQL("DROP TABLE CONTACTS");

            Cursor cursor = db.query("CONTACTS", new String[]{"NAME", "SURNAME", "GENDER", "WHO",
                    "TYPE", "SRC"}, null, null, null, null, null);
            String name, surname, gender, who;
            int type, src;
            DataItem dataItem;

            data = new ArrayList<>();

            if (cursor.moveToFirst()) {
                name = cursor.getString(0);
                surname = cursor.getString(1);
                gender = cursor.getString(2);
                who = cursor.getString(3);
                type = cursor.getInt(4);
                src = cursor.getInt(5);
                dataItem = new DataItem(name, surname, gender, who, type, src);
                data.add(dataItem);
            }
            while (cursor.moveToNext()) {
                name = cursor.getString(0);
                surname = cursor.getString(1);
                gender = cursor.getString(2);
                who = cursor.getString(3);
                type = cursor.getInt(4);
                src = cursor.getInt(5);
                dataItem = new DataItem(name, surname, gender, who, type, src);
                data.add(dataItem);
            }
        } catch (SQLException e) {
            Toast.makeText(this, "DB недоступна", Toast.LENGTH_SHORT).show();
        }

        myRecyclerView = findViewById(R.id.rc_view);
        //data = DataItem.dataGenerator(this);
        adapter = new AdapterForRV(data);
        myRecyclerView.setAdapter(adapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        TextView tv_info = findViewById(R.id.tv_info_one);
        TextView tv_onSave = findViewById(R.id.textOnSave);
        tv_info.setText("" + adapter.getItemCount());
        if (selectedName != null) tv_onSave.setText(selectedName);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        cursor.close();
        db.close();


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
