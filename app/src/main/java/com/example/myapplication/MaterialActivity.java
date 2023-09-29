package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MaterialActivity extends AppCompatActivity {
    private Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Material Design - Hafidz");
        }

        init();
    }

    private void init() {
        btnShow = findViewById(R.id.text_button);

        btnShow.setOnClickListener(v-> {
            Toast.makeText(getApplicationContext(), "Awwww!", Toast.LENGTH_SHORT).show();
        });
    }
}