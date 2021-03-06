package com.example.quadraticequationsolverbykm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result;
    Button go;
    EditText ed1, ed2, ed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go = findViewById(R.id.go);
        result = findViewById(R.id.result);
        ed1 = findViewById(R.id.num1);
        ed2 = findViewById(R.id.num2);
        ed3 = findViewById(R.id.num3);

        go.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String t1 = ed1.getText().toString();
        String t2 = ed2.getText().toString();
        String t3 = ed3.getText().toString();
//        Log.d("MyDebug", "t1: " + t1 + "; t2: " + t2 + "; t3: " + t3.equals(""));
        double a, b, c;
        if (t1.equals("")) {
            a = 0;
        } else {
            a = Double.parseDouble(t1);
        }
        if (t2.equals("")) {
            b = 0;
        } else {
            b = Double.parseDouble(t2);
        }
        if (t3.equals("")) {
            c = 0;
        } else {
            c = Double.parseDouble(t3);
        }

        if (a == 0) {
            result.setText("a = 0 !!!");
        } else {
            double D = b * b - 4 * a * c;
            if (D < 0) {
                result.setText("no solution");
            } else if (D == 0) {
                double x1 = (-1 * b + Math.sqrt(D)) / (2 * a);
//                result.setText(String.valueOf(x1));
                result.setText(String.format(Locale.US, "%.3f", x1));
            } else {
                double x1 = (-1 * b + Math.sqrt(D)) / (2 * a);
                double x2 = (-1 * b - Math.sqrt(D)) / (2 * a);
                result.setText(String.format(Locale.US, "%.3f\n%.3f", x1, x2));
            }
        }
    }
}