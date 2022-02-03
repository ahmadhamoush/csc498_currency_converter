package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private CheckBox lbp;
    private CheckBox dollar;
    private TextView converted_text;
    private int CURRENCY_RATE;
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (EditText) findViewById(R.id.number);
        lbp = findViewById(R.id.lbp);
        dollar = findViewById(R.id.dollar);
        converted_text = (TextView) findViewById(R.id.converted_text);
        CURRENCY_RATE = 22000;
    }
    public void LBPtoDollar(){
        double input_number = Double.parseDouble(number.getText().toString());
        input_number /= CURRENCY_RATE;
        converted_text.setText("Converted: " +String.valueOf(df.format(input_number)) +"$");
    }
    public void DollarToLBP(){
        double input_number = Double.parseDouble(number.getText().toString());
        input_number*= CURRENCY_RATE;
        converted_text.setText("Converted: " +String.valueOf(df.format(input_number)) +"LBP");
    }
    public void convert(View v){
        if(dollar.isChecked() && lbp.isChecked()){
            Toast.makeText(getBaseContext(), "Please check only one currency", Toast.LENGTH_LONG).show();
        }
        else if(lbp.isChecked()){
            LBPtoDollar();
        }
        else if(dollar.isChecked()){
            DollarToLBP();
        }
        else{
            Toast.makeText(getBaseContext(), "Please check a currency", Toast.LENGTH_LONG).show();
        }
    }
}