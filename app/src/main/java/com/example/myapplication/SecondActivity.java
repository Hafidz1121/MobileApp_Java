package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView txtNamePerson;
    private String nama;
    private String KEY_NAME = "NAMA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Second Activity Intent Explicit - Hafidz");
        }

        init();
    }

    private void init() {
        txtNamePerson = findViewById(R.id.txtPersonName);

        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        txtNamePerson.setText("Hello, " + nama + " !");
    }
}
