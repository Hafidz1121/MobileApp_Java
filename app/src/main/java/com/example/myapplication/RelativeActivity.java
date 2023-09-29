package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class RelativeActivity extends AppCompatActivity {
    DatePickerDialog pickerDialog;
    private TextView txtDateShow;
    private EditText txtDateInput;
    private Button btnGetDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Relative Layout - Hafidz");
        }

        init();
    }

    private void init() {
        txtDateShow = findViewById(R.id.txtDateShow);
        txtDateInput = findViewById(R.id.txtDate);
        btnGetDate = findViewById(R.id.btnGetDate);

        txtDateInput.setInputType(InputType.TYPE_NULL);

        txtDateInput.setOnClickListener(v-> {
            final Calendar calendar = Calendar.getInstance();
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            int month = calendar.get(Calendar.MONTH);
            int year = calendar.get(Calendar.YEAR);

            pickerDialog = new DatePickerDialog(RelativeActivity.this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                    txtDateInput.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year );
                }
            }, year, month, day);

            pickerDialog.show();
        });

        btnGetDate.setOnClickListener(v-> {
            txtDateShow.setText("Selected Date : " + txtDateInput.getText());
        });
    }
}

