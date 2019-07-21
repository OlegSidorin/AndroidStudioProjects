package ru.siddorin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTxtView, myTxtMemo, myTxtZnak;
    Integer i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void push01(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtView.setText(myTxtView.getText()+"1");
    }
    public void pushPlus(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        myTxtZnak = findViewById(R.id.textMemoZnak);
        myTxtMemo.setText(myTxtView.getText());
        myTxtZnak.setText("+");
        myTxtView.setText(null);
    }
    public void pushEq(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        i = Integer.parseInt(myTxtMemo.getText().toString()) +
                Integer.parseInt(myTxtView.getText().toString());
        myTxtView.setText(" " + i + "");
        myTxtMemo.setText(null);
    }


}
