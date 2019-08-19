package com.sidorin.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity implements MyAdapter.OnMyDataEditListener {
    ArrayList<MyData> data;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        final ImageView iv_add = findViewById(R.id.iv_add);
        iv_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onAddData(data, 1);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.rc_view);
        data = MyData.dataGenerator(this);
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnMyDataEditListener(this);


    }


    @Override
    public void onEditData(ArrayList<MyData> data, int position) {
        // Toast.makeText(this,"Edit",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, EditActivity.class);
        MyData item = data.get(position);
        intent.putExtra("name", item.name);
        intent.putExtra("surname", item.surname);
        intent.putExtra("gender", item.gender);
        intent.putExtra("type", item.type);
        intent.putExtra("who", item.who);
        intent.putExtra("position", position);
        startActivityForResult(intent, 1111);
        //startActivity(intent);
    }


    public void onAddData(ArrayList<MyData> data, int position) {
        Intent intent = new Intent(this, EditActivity.class);
        startActivityForResult(intent, 2222);
    }


    @Override
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
