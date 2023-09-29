package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TableActivity extends AppCompatActivity {
    private EditText txtUsername, txtPassword;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Table Layout - Hafidz");
        }

        init();
    }

    private void init() {
        txtUsername = findViewById(R.id.username);
        txtPassword = findViewById(R.id.password);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v-> {
            if (txtUsername.getText().toString().isEmpty() || txtPassword.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Mohon masukan username dan password", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "Login Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}