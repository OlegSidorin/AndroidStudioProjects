package ru.siddorin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView myTxtView, myTxtMemo, myTxtZnak;
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
        myTxtZnak = findViewById(R.id.textMemoZnak);
        myTxtView.setText(null);
        myTxtMemo.setText(null);
        myTxtZnak.setText(null);
    }


    public void operation(int znak) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        myTxtZnak = findViewById(R.id.textMemoZnak);

        switch (znak) {
            case 1: {
                if (!flagOfZnak) { // если первый раз нажата
                    myTxtMemo.setText(myTxtView.getText());
                    myTxtZnak.setText("+");
                    myTxtView.setText(null);
                    flagOfEq = false;
                    flagOfZnak = true;
                } else { // если повторное нажатаие
                    myTxtZnak.setText("+");
                    flagOfEq = false;
                    flagOfZnak = true;
                }
            }
            break;
            case 2: {
                if (!flagOfZnak) { // если первый раз нажата
                    myTxtMemo.setText(myTxtView.getText());
                    myTxtZnak.setText("-");
                    myTxtView.setText(null);
                    flagOfEq = false;
                    flagOfZnak = true;
                } else { // если повторное нажатаие
                    myTxtZnak.setText("-");
                    flagOfEq = false;
                    flagOfZnak = true;
                }
            }
            break;
            case 3: {
                if (!flagOfZnak) { // если первый раз нажата
                    myTxtMemo.setText(myTxtView.getText());
                    myTxtZnak.setText("*");
                    myTxtView.setText(null);
                    flagOfEq = false;
                    flagOfZnak = true;
                } else { // если повторное нажатаие
                    myTxtZnak.setText("*");
                    flagOfEq = false;
                    flagOfZnak = true;
                }
            }
            break;
            case 4: {
                if (!flagOfZnak) { // если первый раз нажата
                    myTxtMemo.setText(myTxtView.getText());
                    myTxtZnak.setText("/");
                    myTxtView.setText(null);
                    flagOfEq = false;
                    flagOfZnak = true;
                } else { // если повторное нажатаие
                    myTxtZnak.setText("/");
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
        operation(znakOperation);
    }
    public void pushMinus(View view) {
        znakOperation = 2;
        operation(znakOperation);
    }
    public void pushMulty(View view) {
        znakOperation = 3;
        operation(znakOperation);
    }
    public void pushDivide(View view) {
        znakOperation = 4;
        operation(znakOperation);
    }

    public void addNum(String str) { // прибавляет цифру str на индикаторе к существующему числу
        myTxtView = findViewById(R.id.textView);
        myTxtView.setText(String.format("%s%s", myTxtView.getText(), str));
    }

    public void pushNum(String str_num) {

        if (flagOfEq) {
            // была нажата кнопка =
            myTxtView.setText(null);
            addNum(str_num);
            flagOfEq = false;
            flagOfZnak = false;

        } else {
            // не была нажата =
            addNum(str_num);
            flagOfEq = false;
            flagOfZnak = false;
        }

    }


    public void pushEq(View view) {
        myTxtView = findViewById(R.id.textView);
        myTxtMemo = findViewById(R.id.textMemo);
        switch (znakOperation) {
            case 1: {
                if (flagOfEq) { // если была уже нажата кноика =
                } else { // если нажата = в первый раз
                    if (!flagOfZnak) { // если кнопка знака не была нажата
                        aDouble = Double.parseDouble(myTxtMemo.getText().toString()) +
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
