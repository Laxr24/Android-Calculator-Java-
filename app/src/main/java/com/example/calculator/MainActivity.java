package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.charset.CharsetEncoder;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    String d_text = "";
    StringBuffer myArray = new StringBuffer("");
    Integer d_length = 0;
    TextView d_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        d_view = findViewById(R.id.display);

        Button btn_1 = findViewById(R.id.btn1);
        Button btn_2 = findViewById(R.id.btn2);
        Button btn_3 = findViewById(R.id.btn3);
        Button btn_4 = findViewById(R.id.btn4);
        Button btn_5 = findViewById(R.id.btn5);
        Button btn_6 = findViewById(R.id.btn6);
        Button btn_7 = findViewById(R.id.btn7);
        Button btn_8 = findViewById(R.id.btn8);
        Button btn_9 = findViewById(R.id.btn9);
//        Operational buttons
//        Button add = findViewById(R.id.add);
        Button delete = findViewById(R.id.del);



        delete.setOnClickListener(v->{
            if(myArray.length() != 0){
                myArray.deleteCharAt(myArray.length()-1);
                d_view.setText(myArray);
            }
            Log.d("msg", "Delete button working, last char: " + myArray);
        });

//        Initiating buttons at runtime
        btnClick(btn_1);
        btnClick(btn_2);
        btnClick(btn_3);
        btnClick(btn_4);
        btnClick(btn_5);
        btnClick(btn_6);
        btnClick(btn_7);
        btnClick(btn_8);
        btnClick(btn_9);

    }

    public void btnClick (Button isButton){
        isButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d_text += isButton.getText().toString();
                myArray.append(isButton.getText().toString());
//                d_length = d_text.length();
                d_length = myArray.length();
                if(!d_text.equals("")){
//                    d_view.setText(d_text.toString());
                    d_view.setText(myArray);
                    Log.d("msg", myArray + " and the size of the array is : "+ d_length);
                }
            }
        });
    }
}