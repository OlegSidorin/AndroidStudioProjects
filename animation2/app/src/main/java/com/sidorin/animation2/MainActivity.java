package com.sidorin.animation2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.util.AttributeSet;
import android.widget.TextView;

import static android.text.Html.fromHtml;

public class MainActivity extends AppCompatActivity {

    public static final  String H2O = "H<sub><small>2</small></sub>O";
    int textViewLineCount = Integer.MAX_VALUE;
    private String getPattern() {

        String pattern = "\\b[a-zA-Z]+\\b"; // регулярные выражения изучить
        return pattern;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.textView2)).setText(fromHtml(H2O));
        // можно использовать CDATA при задании строк с html
    }
}