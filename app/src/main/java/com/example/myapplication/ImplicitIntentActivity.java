package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class ImplicitIntentActivity extends AppCompatActivity {
    private EditText txtInput;
    private Button btnVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Intent Implicit - Hafidz");
        }

        init();
    }

    private void init() {
        txtInput = findViewById(R.id.textInput_Implicit);
        btnVisit = findViewById(R.id.btnVisit_Implicit);

        btnVisit.setOnClickListener(v-> {
            String url = txtInput.getText().toString();
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            startActivity(intent);
        });
    }
}