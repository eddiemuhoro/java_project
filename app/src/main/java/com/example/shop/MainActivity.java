package com.example.shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView getStarted = findViewById(R.id.started);

        getStarted.setOnClickListener(v->{
            Intent intent = new Intent(this, NewActivity.class);
            startActivity(intent);
        });

    }
}