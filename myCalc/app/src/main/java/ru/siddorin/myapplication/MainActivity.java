package ru.siddorin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTxtView, myTxtMemo, myTxtZnak;
    String stringValue, stringValueMemo, stringValueHistory;
    Double value, valueMemo, valueResult;
    Double aDouble;
    Long aLong;
    int znakOperation; // 1 - plus, 2 - minus, 3 multy, 4 - divide
    Boolean flagOfEq, flagOfZnak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flagOfEq = false;
        flagOfZnak = false;
    }

    public void clickC(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        myTxtView.setText(null);
        myTxtMemo.setText(null);
        myTxtZnak.setText(null);
        flagOfZnak = false;
        flagOfEq = false;
    }


    public void pushZnak(int znak) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);

        switch (znak) {
            case 1: {
                if (!flagOfZnak && !flagOfEq) { // если не были до этого нажаты + и =
                    stringValueMemo = stringValue;
                    myTxtMemo.setText(String.format("%s +", stringValueMemo));
                    flagOfEq = false;
                    flagOfZnak = true;
                }
            }
            break;

        }
    }

    public void push1(View view) {
        pushNum("1");
    }

    public void push2(View view) {
        pushNum("2");
    }

    public void push3(View view) {
        pushNum("3");
    }

    public void push4(View view) {
        pushNum("4");
    }

    public void push5(View view) {
        pushNum("5");
    }

    public void push6(View view) {
        pushNum("6");
    }

    public void push7(View view) {
        pushNum("7");
    }

    public void push8(View view) {
        pushNum("8");
    }

    public void push9(View view) {
        pushNum("9");
    }

    public void pushPoint(View view) {
        pushNum(".");
    }

    public void push0(View view) {
        pushNum("0");
    }

    public void pushPlus(View view) {
        znakOperation = 1;
        pushZnak(znakOperation);
    }

    public void pushMinus(View view) {
        znakOperation = 2;
        pushZnak(znakOperation);
    }

    public void pushMulty(View view) {
        znakOperation = 3;
        pushZnak(znakOperation);
    }

    public void pushDivide(View view) {
        znakOperation = 4;
        pushZnak(znakOperation);
    }


    public void pushNum(String str_num) {

        if (!flagOfEq && !flagOfZnak) { // не была нажата = и не была нажата +
            myTxtView = findViewById(R.id.textView);
            if (stringValue == null) {
                stringValue = str_num;
            } else {
                stringValue = String.format("%s%s", stringValue, str_num);
            }
            myTxtView.setText(stringValue);
            flagOfEq = false;
            flagOfZnak = false;
        }

    }


    public void pushEq(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        switch (znakOperation) {
            case 1: {
                if (flagOfZnak && !flagOfEq) { // если кнопка знака была нажата и = еще не было
                    value = Double.parseDouble(stringValue);
                    valueMemo = Double.parseDouble(stringValueMemo);
                    valueResult = value + valueMemo;
                    stringValueMemo = String.format("%s + %s =",stringValueMemo, stringValue);
                    myTxtMemo.setText(stringValueMemo);
                    myTxtView.setText(valueResult.toString());
                    flagOfEq = true;
                    flagOfZnak = false;
                }
            }
            break;
            case 2: {
                if (flagOfEq) { // если была уже нажата кноика =
                } else { // если нажата = в первый раз
                    if (!flagOfZnak) { // если кнопка знака не была нажата
                        aDouble = Double.parseDouble(myTxtMemo.getText().toString()) -
                                Double.parseDouble(myTxtView.getText().toString());
                        myTxtView.setText(aDouble.toString());
                        myTxtZnak.setText(null);
                        myTxtMemo.setText(null);
                        flagOfEq = true;
                        flagOfZnak = false;
                    } else {

                    }
                }
            }
            break;
            case 3: {
                if (flagOfEq) { // если была уже нажата кноика =
                } else { // если нажата = в первый раз
                    if (!flagOfZnak) { // если кнопка знака не была нажата
                        aDouble = Double.parseDouble(myTxtMemo.getText().toString()) *
                                Double.parseDouble(myTxtView.getText().toString());
                        myTxtView.setText(aDouble.toString());
                        myTxtZnak.setText(null);
                        myTxtMemo.setText(null);
                        flagOfEq = true;
                        flagOfZnak = false;
                    } else {

                    }
                }
            }
            break;
            case 4: {
                if (flagOfEq) { // если была уже нажата кноика =
                } else { // если нажата = в первый раз
                    if (!flagOfZnak) { // если кнопка знака не была нажата
                        aDouble = Double.parseDouble(myTxtMemo.getText().toString()) /
                                Double.parseDouble(myTxtView.getText().toString());
                        myTxtView.setText(aDouble.toString());
                        myTxtZnak.setText(null);
                        myTxtMemo.setText(null);
                        flagOfEq = true;
                        flagOfZnak = false;
                    } else {

                    }
                }
            }
            break;
        }
    }


}
