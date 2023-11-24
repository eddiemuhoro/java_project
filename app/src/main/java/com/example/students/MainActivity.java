package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class   MainActivity extends AppCompatActivity {

TextView signup;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] socialMedia = {"Facebook", "Instagram", "Wee Chat", "Tiktok"};
        ListView listView = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, socialMedia);

        listView.setAdapter(adapter);
        EditText kshEditText = findViewById(R.id.ksh);


        Button   dollarButton = findViewById(R.id.dollar);
        Button euroButton = findViewById(R.id.euro);
        Button poundButton = findViewById(R.id.pound);

        TextView resultTextView = findViewById(R.id.result);

        dollarButton.setOnClickListener(v -> {
            double  dollaramount = Double.parseDouble(kshEditText.getText().toString())/129;
           resultTextView.setText("dolla"+dollaramount);
            double newAmount = dollaramount/130;
            Toast.makeText(this, String.valueOf(newAmount), Toast.LENGTH_SHORT).show();
        });
        euroButton.setOnClickListener(v->{
            String course = kshEditText.getText().toString();

            Stude stude = new Stude(course, "67676", "tygvgh");
            String message = stude.getName();

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity3.class);
            intent.putExtra("key", course);
            startActivity(intent);
        });
    }

}

