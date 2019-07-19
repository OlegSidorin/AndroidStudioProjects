package com.sidorin.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView myTextView, my2TextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        my2TextView = findViewById(R.id.textView4);
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                String str = bundle.getString("sum", "no txt");
                my2TextView.setText(str);
            }
        }
    }

    public void back_home (View view) {
        Intent intent_home = new Intent(Main2Activity.this,MainActivity.class);
        startActivity(intent_home);
    }
}
