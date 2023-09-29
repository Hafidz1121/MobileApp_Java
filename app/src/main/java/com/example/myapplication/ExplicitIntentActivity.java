package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ExplicitIntentActivity extends AppCompatActivity {
    private EditText txtInputName;
    private Button btnSend;
    private String KEY_NAME = "NAMA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Intent Explicit - Hafidz");
        }

        init();
    }

    private void init() {
        txtInputName = findViewById(R.id.inputTxt_PersonName);
        btnSend = findViewById(R.id.btnSubmit_Explicit);

        btnSend.setOnClickListener(v-> {
            try {
                String nama = txtInputName.getText().toString();

                if (!nama.isEmpty()) {
                    Intent intent = new Intent(ExplicitIntentActivity.this, SecondActivity.class);
                    intent.putExtra(KEY_NAME, nama);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "ANDA HARUS MENGISI NAMA!", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "ERROR, MOHON COBA LAGI!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
