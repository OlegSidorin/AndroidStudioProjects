package com.sidorin.app05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity {

    TextView myTextView, myTextView2;
    EditText myEdText01, myEdText02;
    public int isum, i1, i2;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void push_the_button(View view){
        myEdText01 = findViewById(R.id.editText);
        myEdText02 = findViewById(R.id.editText2);
        myTextView = findViewById(R.id.textView3);
        myTextView2 = findViewById(R.id.textView4);
        i1 = parseInt(myEdText01.getText().toString());
        i2 = parseInt(myEdText02.getText().toString());
        isum = i1 + i2;
        String str = "сумма равна = " + isum;
        myTextView.setText(str);

        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        intent.putExtra("sum", str);
        startActivity(intent);

    }
}
