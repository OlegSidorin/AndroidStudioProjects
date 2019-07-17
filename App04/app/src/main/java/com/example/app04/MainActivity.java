package com.example.app04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // вводим переменные
    static final String KEY_NAME = "name user";
    Button myBtnShowName;
    Button myBtnOk;
    TextView myTxtView01;
    EditText myEditText;
    String name;
    int anInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtnOk = findViewById(R.id.btn_ok);
        myEditText = findViewById(R.id.editText);
        myBtnShowName = findViewById(R.id.btn_showname);
        myTxtView01 = findViewById(R.id.myTextView01);
        Log.d("tag","Вызван метод onCreate" );

        findViewById(R.id.myButtonPush).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anInt++;
                if (anInt<2) myTxtView01.setText("Ты нажал(а) " + anInt + " раз");
                if (anInt<5 & anInt>=2) myTxtView01.setText("Ты нажал(а) " + anInt + " раза");
                if (anInt>=5) myTxtView01.setText("Ты нажал(а) " + anInt + " раз");
                if (anInt>=10) myTxtView01.setText("Ты большая умничка");
                Log.d("tag", "Вызван метод onClick");
            }
        });

        myBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                name = myEditText.getText().toString();
            }
        });

        myBtnShowName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "your name " + name, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View view){
        Intent intent = new Intent(MainActivity.this, BActivity.class);
        intent.putExtra("name", name);
        startActivity(intent);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag", "Вызван метод onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "Вызван метод onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "Вызван метод onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag", "Вызван метод onStop");
    }
}
