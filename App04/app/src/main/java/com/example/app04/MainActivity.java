package com.example.app04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // вводим переменные
    Button myBtn;
    TextView myTxtBlock;
    int anInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn = findViewById(R.id.myButton);
        myTxtBlock = findViewById(R.id.myTtextView);
        Log.d("tag","Вызван метод onCreate" );

        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                anInt++;
                if (anInt<2) myTxtBlock.setText("Ты нажал(а) " + anInt + " раз");
                if (anInt<5 & anInt>=2) myTxtBlock.setText("Ты нажал(а) " + anInt + " раза");
                if (anInt>=5) myTxtBlock.setText("Ты нажал(а) " + anInt + " раз");
                if (anInt>=10) myTxtBlock.setText("Ты умничка, больше не надо жать");
                Log.d("tag", "Вызван метод onClick");
            }
        });

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
