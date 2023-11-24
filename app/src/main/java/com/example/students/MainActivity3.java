package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        EditText num1EditText = findViewById(R.id.num1);
        EditText num2EditText = findViewById(R.id.num2);

        Button maximaButton = findViewById(R.id.maxima);
        Button minimaButton = findViewById(R.id.minima);

        maximaButton.setOnClickListener((v)->{
            String num1 = num1EditText.getText().toString();
            String num2 = num2EditText.getText().toString();

                Double num1Int = Double.parseDouble(num1);
                Double num2Int = Double.parseDouble(num2);

                if(num1Int > num2Int){
                    Toast.makeText(this, num1Int.toString(), Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, num2Int.toString(), Toast.LENGTH_LONG).show();
                }

        });

        minimaButton.setOnClickListener(v->{
            String num1String = num1EditText.getText().toString();
            String num2String = num2EditText.getText().toString();

            Integer num1 = Integer.parseInt(num1String);
            Integer num2 = Integer.parseInt(num2String);

            String maximum;
            String minimum = "2";

            if (num1 > num2){
                 maximum = num1.toString();

            }else{
                 maximum = num2.toString();
            }

            Toast.makeText(this, maximum, Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, NewActivity.class);
            intent.putExtra("Maximum", maximum);
            intent.putExtra("Minimum", minimum);
            startActivity(intent);
        });
    }
}