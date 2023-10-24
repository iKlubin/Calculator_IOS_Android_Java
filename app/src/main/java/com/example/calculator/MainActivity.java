package com.example.calculator;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private String symbol;
    private Double num1 = 0D;
    private Double num2 = 0D;

    private int ind = 0;

    private boolean queueNum = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.textView);
        text.setText("0");
        symbol = "";
        num1 = 0D;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black, this.getTheme()));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.black));
        }
    }

    public void clickAC(View v){
        text.setText("0");
        Toast.makeText(this, "Для удаления одной цифры нажмите на поле чисел", Toast.LENGTH_SHORT).show();
    }

    public void clickRemove(View v){
        text.setText(text.getText().subSequence(0, text.length() - 1));
        if (text.length() == 0 || text.getText().toString().equals("-")) {
            text.setText("0");
        }
    }

    public void clickPlusMinus(View v){
        if (text.getText() != "0" && text.getText().charAt(0) != '-') {
            text.setText("-" + text.getText());
        } else {
            text.setText(text.getText().toString().substring(1));
        }
    }

    public void clickPercent(View v){
        text.setText(String.valueOf(Double.parseDouble(text.getText().toString()) / 100));
    }

    public void setNum(){
        Log.d("Test", "Queue: " + queueNum + " Num1: " + num1 + " Num2: " + num2 + " Ind: " + ind);
        try {
            if (!queueNum){
                num1 = Double.parseDouble(text.getText().toString());
            } else {
                num2 = Double.parseDouble(text.getText().toString().substring(ind, text.length()));
            }
        } catch (Exception e){
            Log.d("Ex: ", e.toString());
        }
    }

    public void click0(View v){
        if (text.getText().charAt(text.length() - 1) != '0') {
            text.setText(text.getText() + "0");
        }
        setNum();
    }

    public void click1(View v){
        if (text.getText() == "0") {
            text.setText("1");
        } else {
            text.setText(text.getText() + "1");
        }
        setNum();
    }

    public void click2(View v){
        if (text.getText() == "0") {
            text.setText("2");
        } else {
            text.setText(text.getText() + "2");
        }
        setNum();
    }

    public void click3(View v){
        if (text.getText() == "0") {
            text.setText("3");
        } else {
            text.setText(text.getText() + "3");
        }
        setNum();
    }

    public void click4(View v){
        if (text.getText() == "0") {
            text.setText("4");
        } else {
            text.setText(text.getText() + "4");
        }
        setNum();
    }

    public void click5(View v){
        if (text.getText() == "0") {
            text.setText("5");
        } else {
            text.setText(text.getText() + "5");
        }
        setNum();
    }

    public void click6(View v){
        if (text.getText() == "0") {
            text.setText("6");
        } else {
            text.setText(text.getText() + "6");
        }
        setNum();
    }

    public void click7(View v){
        if (text.getText() == "0") {
            text.setText("7");
        } else {
            text.setText(text.getText() + "7");
        }
        setNum();
    }

    public void click8(View v){
        if (text.getText() == "0") {
            text.setText("8");
        } else {
            text.setText(text.getText() + "8");
        }
        setNum();
    }

    public void click9(View v){
        if (text.getText() == "0") {
            text.setText("9");
        } else {
            text.setText(text.getText() + "9");
        }
        setNum();
    }

    public void clickPoint(View v){
        if (text.getText().charAt(text.length() - 1) != '.'){
            text.setText(text.getText() + ".");
        }
    }

    public void clickEqual(View v){
        switch (symbol){
            case "+":
                text.setText(String.valueOf(num1 + num2));
                break;
            case "-":
                text.setText(String.valueOf(num1 - num2));
                break;
            case "*":
                text.setText(String.valueOf(num1 * num2));
                break;
            case "/":
                text.setText(String.valueOf(num1 / num2));
                break;
        }
        queueNum = false;
        setNum();
    }

    public void clickDiv(View v){
        queueNum = true;
        num1 = Double.parseDouble(text.getText().toString());
        symbol = "/";
        text.setText(text.getText() + "÷");
        ind = text.length();
    }

    public void clickMult(View v){
        queueNum = true;
        num1 = Double.parseDouble(text.getText().toString());
        symbol = "*";
        text.setText(text.getText() + "×");
        ind = text.length();
    }

    public void clickPlus(View v){
        queueNum = true;
        num1 = Double.parseDouble(text.getText().toString());
        symbol = "+";
        text.setText(text.getText() + "+");
        ind = text.length();
    }

    public void clickMinus(View v){
        queueNum = true;
        num1 = Double.parseDouble(text.getText().toString());
        symbol = "-";
        text.setText(text.getText() + "-");
        ind = text.length();
    }
}