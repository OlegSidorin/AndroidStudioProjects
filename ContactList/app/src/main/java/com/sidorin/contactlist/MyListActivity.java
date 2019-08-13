package com.sidorin.contactlist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity implements MyAdapter.OnMyDataEditListener {
ArrayList<MyData> data;
MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        RecyclerView recyclerView = findViewById(R.id.rc_view);
        data = MyData.dataGenerator(this, 50);
        adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setOnMyDataEditListener(this);

    }


    @Override
    public void OnEditData(ArrayList<MyData> data, int position) {
       // Toast.makeText(this,"Edit",Toast.LENGTH_SHORT).show();
        Intent intent  = new Intent(this,EditActivity.class);
        MyData item = data.get(position);
        intent.putExtra("name",item.name);
        intent.putExtra("surname",item.surname);
        intent.putExtra("type",item.type);
        intent.putExtra("position", position);
        startActivityForResult(intent,1111);
        //startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1111 && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String surname = data.getStringExtra("surname");
            int type = data.getIntExtra("type",0);
            int pos = data.getIntExtra("position",-1);
            MyData item = this.data.get(pos);
            item.name = name;
            item.surname = surname;
            item.type = type;
            adapter.notifyItemChanged(pos);


        }
    }
}
