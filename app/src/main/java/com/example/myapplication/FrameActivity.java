package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class FrameActivity extends AppCompatActivity {
    private Button btnFrame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Frame Layout - Hafidz");
        }

        init();
    }

    private void init() {
        btnFrame = findViewById(R.id.btnFrame);

        btnFrame.setOnClickListener(v-> {
            Toast.makeText(getApplicationContext(), "Awwwww!", Toast.LENGTH_SHORT).show();
        });
    }
}