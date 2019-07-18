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
    TextView myTxtView01, myTxtView02;
    EditText myEditText;
    String name;
    int anInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtnOk = findViewById(R.id.btn_ok);
        myEditText = findViewById(R.id.myEditText01);
        myBtnShowName = findViewById(R.id.btn_showname);
        myTxtView01 = findViewById(R.id.myTextView01);
        myTxtView02 = findViewById(R.id.myTextView02);
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

    public void change_in_myTextView02(String str){
        myTxtView02.append(str);
    }

    public void push_1 (View veiw){
        change_in_myTextView02("1");
    }
    public void push_2 (View veiw){
        change_in_myTextView02("2");
    }
    public void push_3 (View veiw){
        change_in_myTextView02("3");
    }
    public void push_4 (View veiw){
        change_in_myTextView02("4");
    }
    public void push_5 (View veiw){
        change_in_myTextView02("5");
    }
    public void push_6 (View veiw){
        change_in_myTextView02("6");
    }
    public void push_7 (View veiw){
        change_in_myTextView02("7");
    }
    public void push_8 (View veiw){
        change_in_myTextView02("8");
    }
    public void push_9 (View veiw){
        change_in_myTextView02("9");
    }
    public void push_0 (View veiw){
        change_in_myTextView02("0");
    }
    public void push_plus (View veiw){
        change_in_myTextView02("+");
    }
    public void push_minus (View veiw){
        change_in_myTextView02("-");
    }
    public void push_multy (View veiw){
        change_in_myTextView02("*");
    }
    public void push_div (View veiw){
        change_in_myTextView02("-");
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
