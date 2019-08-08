package ru.siddorin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String maryCalcText = "MaryCalc <sup><small>V.1</small></sup>";
    String sF = "%.0f", sFs = "%.0f%s";
    TextView myTxtView, myTxtMemo, myTxtZnak;
    String stringValue, stringValueMemo, stringValueHistory;
    double value, valueMemo, valueResult;
    Double aDouble;
    int znak, prevZnak; // 1 - plus, 2 - minus, 3 multy, 4 - divide 0 - =
    Boolean flagOfEq, flagOfZnak, flagOfNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((TextView)findViewById(R.id.textMaryCalc)).setText(Html.fromHtml(maryCalcText));
        flagOfEq = false;
        flagOfZnak = false;
        flagOfNum = false;
        value = 0;
        valueMemo = 0;
        valueResult = 0;
    }

    public void clickC(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        myTxtView.setText(null);
        myTxtMemo.setText(null);
        flagOfZnak = false;
        flagOfEq = false;
        flagOfNum = false;
        value = 0;
        valueMemo = 0;
        valueResult = 0;
    }

    public void pushNum(int num) {
        value = value * 10 + num;
        myTxtView = findViewById(R.id.textView);
        myTxtView.setText(String.format(sF,value));
    }
    public void getValueResult() {
        switch (prevZnak) {
            case 1:  // после +
                valueResult = valueMemo + value;
                break;
            case 2:  // после -
                valueResult = valueMemo - value;
                break;
            case 3:  // после *
                valueResult = valueMemo * value;
                break;
            case 4:  // после /
                if (value != 0) valueResult = valueMemo / value;
                else valueResult = valueMemo;
                break;
            default: // после =
                valueResult = value;
                break;
        }
    }

    public void pushZnak(int znak) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        switch (znak) {
            case 0:  // нажатие =
                getValueResult();
                valueMemo = 0;
                value = 0;
                prevZnak = 0;
                myTxtMemo.setText(null);
                myTxtView.setText(String.format(sF,valueResult));
                break;
            case 1:  // нажатие +
                getValueResult();
                valueMemo = valueResult;
                value = 0;
                prevZnak = 1;
                myTxtMemo.setText(String.format(sFs, valueMemo, " +"));
                myTxtView.setText(String.format(sF,valueResult));
                break;
            case 2:  // нажатие -
                getValueResult();
                valueMemo = valueResult;
                value = 0;
                prevZnak = 2;
                myTxtMemo.setText(String.format(sFs, valueMemo, " -"));
                myTxtView.setText(String.format(sF,valueResult));
                break;
            case 3:  // нажатие *
                getValueResult();
                valueMemo = valueResult;
                value = 0;
                prevZnak = 3;
                myTxtMemo.setText(String.format(sFs, valueMemo, " *"));
                myTxtView.setText(String.format(sF,valueResult));
                break;
            case 4:  // нажатие *
                getValueResult();
                valueMemo = valueResult;
                value = 0;
                prevZnak = 4;
                myTxtMemo.setText(String.format(sFs, valueMemo, " /"));
                myTxtView.setText(String.format(sF,valueResult));
                break;
        }
    }
    void anim_rotate(View view){
        int iview = view.getId();
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.num_animation);
        set.setTarget(findViewById(iview));
        set.start();
    }
    public void push1(View view) {
        //anim_rotate(view);
        pushNum(1);
        anim_rotate(view);
        flagOfNum = true;
        flagOfEq = false;
        flagOfZnak = false;
    }

    public void push2(View view) {
        pushNum(2);
        anim_rotate(view);
        flagOfNum = true;
        flagOfEq = false;
        flagOfZnak = false;
    }

    public void push3(View view) {
        pushNum(3);
        anim_rotate(view);
        flagOfNum = true;
        flagOfEq = false;
        flagOfZnak = false;
    }

    public void push4(View view) {
        pushNum(4);
        anim_rotate(view);
    }

    public void push5(View view) {
        pushNum(5);
        anim_rotate(view);
    }

    public void push6(View view) {
        pushNum(6);
        anim_rotate(view);
    }

    public void push7(View view) {
        pushNum(7);
        anim_rotate(view);
    }

    public void push8(View view) {
        pushNum(8);
        anim_rotate(view);
    }

    public void push9(View view) {
        pushNum(9);
        anim_rotate(view);
    }

    public void pushPoint(View view) {
        pushNum(0);
    }

    public void push0(View view) {
        pushNum(0);
        anim_rotate(view);
        flagOfZnak = false;
        flagOfNum = true;
        flagOfEq = false;
    }

    public void pushPlus(View view) {
        znak = 1;
        pushZnak(znak);
        flagOfZnak = true;
        flagOfNum = false;
        flagOfEq = false;
    }

    public void pushMinus(View view) {
        znak = 2;
        pushZnak(znak);
        flagOfZnak = true;
        flagOfNum = false;
        flagOfEq = false;
    }

    public void pushMulty(View view) {
        znak = 3;
        pushZnak(znak);
        flagOfZnak = true;
        flagOfNum = false;
        flagOfEq = false;
    }

    public void pushDivide(View view) {
        znak = 4;
        pushZnak(znak);
        flagOfZnak = true;
        flagOfNum = false;
        flagOfEq = false;
    }

    public void pushEq(View view) {
        znak = 0;
        pushZnak(znak);
        flagOfZnak = true;
        flagOfNum = false;
        flagOfEq = true;
    }


}
