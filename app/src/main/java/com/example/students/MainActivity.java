package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class   MainActivity extends AppCompatActivity {

EditText nameEditText;
EditText genderEditText;
EditText regEditText;
Button button;
TextView name21,gender2,regNo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //finding xml elements
        button = findViewById(R.id.button);
        nameEditText = findViewById(R.id.name);
        genderEditText = findViewById(R.id.gender);
        regEditText = findViewById(R.id.reg);
    button.setOnClickListener((v)->{
        String nameToBeDisplayed = nameEditText.getText().toString();
        Intent intent = new Intent(MainActivity.this, NewActivity.class);
        intent.putExtra("key", nameToBeDisplayed);

        startActivity(intent);
    });

    }

}