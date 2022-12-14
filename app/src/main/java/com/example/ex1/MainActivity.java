package com.example.ex1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewMain;
    TextView textViewPrev;
    Character action;
    Double num1;
    Double num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.hide();

        textViewMain = findViewById(R.id.textViewMain);
        textViewPrev = findViewById(R.id.textViewPrev);
    }

    public void numberButton(View view) {
        Button button = (Button) view;

        textViewMain.append(button.getText().toString());
    }

    public void actionButton(View view) {
        if (textViewMain.getText().length() != 0) {
            num1 = Double.parseDouble(textViewMain.getText().toString());
            textViewMain.setText("");
            Button button = (Button) view;
            action = button.getText().charAt(0);
            textViewPrev.setText(fmt(num1) + ' ' + action);
        }
    }

    public void deleteButton(View view) {
        textViewMain.setText(textViewMain.getText().toString().replaceFirst(".$", ""));
    }

    public void clearButton(View view) {
        textViewMain.setText("");
        textViewPrev.setText("");
        num1 = Double.valueOf(0);
        num2 = Double.valueOf(0);
        action = ' ';
    }

    public void equalButton(View view) {
        num2 = Double.parseDouble(textViewMain.getText().toString());
        Double result = Double.valueOf(0);
        switch (action) {
            case ('+'):
                result = num1 + num2;
                break;
            case ('-'):
                result = num1 - num2;
                break;
            case ('x'):
                result = num1 * num2;
                break;
            case ('/'):
                result = num1 / num2;
                break;
        }
        clearButton(view);
        textViewMain.setText(fmt(result));
    }

    public static String fmt(double d) {
        if (d == (long) d)
            return String.format("%d", (long) d);
        else
            return String.format("%s", d);
    }
}