package com.suhel.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView txtResult;
        EditText edtWeight;
        EditText edtHeightFt;
        EditText edtHeightIn;
        Button btnCalculate;

        txtResult=findViewById(R.id.txtResult);
        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnCalculate=findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               int wt=Integer.parseInt(edtWeight.getText().toString());
               int ft=Integer.parseInt(edtHeightFt.getText().toString());
               int in=Integer.parseInt(edtHeightIn.getText().toString());

               int totalIn=ft*12+in;
               double totalCm=totalIn*2.53;
               double totalM=totalCm/100;

               double bmi=wt/(totalM*totalM);

               if (bmi>25){
                   txtResult.setText("You are Overweight");
                   txtResult.setTextColor(getResources().getColor(R.color.colorOw));
               } else if (bmi<18) {
                   txtResult.setText("You are Underweight");
                   txtResult.setTextColor(getResources().getColor(R.color.colorUw));

               }else {
                   txtResult.setText("You are Healthy");
                   txtResult.setTextColor(getResources().getColor(R.color.colorH));

               }
            }
        });
    }
}