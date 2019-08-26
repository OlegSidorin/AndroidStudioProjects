package com.sidorin.contactlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity {
    ArrayList<MyData> data;
    MyAdapter adapter;



    @Override  // создание меню
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override  // выбор действия по пункту меню
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add: // запускает активность редактирования с нулевыми параметрами
                Intent intent_add = new Intent(this, EditActivity.class);
                // нечего передавать
                intent_add.putExtra("type", 8);
                intent_add.putExtra("position", -1);
                startActivityForResult(intent_add, 2222);
                return true;
            case R.id.action_edit: // запускает активность редактирования с передачей параметров в нее
                if (adapter.selected_position > -1) {
                    Intent intent_edit = new Intent(this, EditActivity.class);
                    MyData data_item = data.get(adapter.selected_position);
                    intent_edit.putExtra("name", data_item.name);
                    intent_edit.putExtra("surname", data_item.surname);
                    intent_edit.putExtra("gender", data_item.gender);
                    intent_edit.putExtra("type", data_item.type);
                    intent_edit.putExtra("who", data_item.who);
                    intent_edit.putExtra("position", adapter.selected_position);
                    startActivityForResult(intent_edit, 1111);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override // запуск прииложения
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);


        final RecyclerView myRecyclerView = findViewById(R.id.rc_view);
        data = MyData.dataGenerator(this);
        adapter = new MyAdapter(data);
        myRecyclerView.setAdapter(adapter);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    @Override // возврат в активность с интентом
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1111 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String surname = data.getStringExtra("surname");
            String who = data.getStringExtra("who");
            int type = data.getIntExtra("type", 0);
            int pos = data.getIntExtra("position", -1);
            MyData item = this.data.get(pos);
            item.name = name;
            item.surname = surname;
            item.type = type;
            item.who = who;
            adapter.notifyItemChanged(pos);
        } else {
            if (requestCode == 2222 && resultCode == RESULT_OK && data != null) {
                TextView tv_name = findViewById(R.id.inputFirstName);
                String name = tv_name.getText().toString();
                int pos = 0;
                MyData itemNew = new MyData(name, "sd", "m", "fuck", 2);
                MyListActivity.this.data.add(pos, itemNew);
                adapter.notifyItemInserted(pos);
                adapter.notifyItemRangeChanged(0, adapter.getItemCount());
            }
        }
    }

}
