package com.sidorin.contactlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MyListActivity extends AppCompatActivity implements MyAdapter.OnMyDataEditListener {
ArrayList<MyData> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        RecyclerView recyclerView = findViewById(R.id.rc_view);
        data = MyData.dataGenerator(this, 50);
        MyAdapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }


    @Override
    public void OnEditData(ArrayList<MyData> data, int position) {

    }
}
