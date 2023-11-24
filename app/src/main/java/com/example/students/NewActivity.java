package com.example.students;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {

 TextView milkPrice, vat, actual;
 Button milk;
    double initialPrice = 20;
    int count = 1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        milkPrice = findViewById(R.id.milkPrice);
        vat = findViewById(R.id.vat);
        actual = findViewById(R.id.actual);
        milk= findViewById(R.id.milk);

        updateUI();

        milk.setOnClickListener((v)->{
            if(count < 5) {
                double showedPrice = initialPrice * count;
                milkPrice.setText(String.valueOf(showedPrice));

                double taxDeducted = (initialPrice * count) * 16/100;

                vat.setText(String.valueOf(taxDeducted));

                double actualPrice = (initialPrice * count) - taxDeducted;
                actual.setText(String.valueOf(actualPrice));
                updateUI();
            } else{
                Toast.makeText(NewActivity.this, "You can't buy more than 4 items :(", Toast.LENGTH_LONG).show();
            }
        });


    }
    private void updateUI(){


    }
}
