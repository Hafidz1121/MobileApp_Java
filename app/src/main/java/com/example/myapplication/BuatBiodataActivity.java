package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.helpers.SqlHelper;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;

public class BuatBiodataActivity extends AppCompatActivity {
    protected Cursor cursor;
    private EditText nomor, nama, tglLahir, alamat;
    private Button btnKembali, btnSimpan;
    private AutoCompleteTextView jenisKelamin;
    private SqlHelper sqlHelper;
    private final Calendar calendar = Calendar.getInstance();
    private String[] JK = {"Laki-Laki", "Perempuan"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buat_biodata);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Buat Biodata Diri");
        }

        init();
    }

    private void init() {
        sqlHelper = new SqlHelper(this);
        nomor = findViewById(R.id.txt_InputNomor);
        nama = findViewById(R.id.txt_InputNama);
        tglLahir = findViewById(R.id.txt_InputTglLahir);
        jenisKelamin = findViewById(R.id.txt_InputJK);
        alamat = findViewById(R.id.txt_InputAlamat);

        btnKembali = findViewById(R.id.btn_Kembali);
        btnSimpan = findViewById(R.id.btn_Simpan);

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };

        tglLahir.setOnClickListener(v-> {
            new DatePickerDialog(BuatBiodataActivity.this, date,
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)).show();
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, JK);
        jenisKelamin.setThreshold(1);
        jenisKelamin.setAdapter(adapter);

        btnSimpan.setOnClickListener(v-> {
            if (checkData()) {
                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                db.execSQL("INSERT INTO biodata(no, nama, tgl, jk, alamat) VALUES('" +
                        nomor.getText().toString().trim() + "' , '" +
                        nama.getText().toString() + "', '" +
                        tglLahir.getText().toString().trim() + "', '" +
                        jenisKelamin.getText().toString().trim() + "', '" +
                        alamat.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil Menambahkan Data!", Toast.LENGTH_SHORT).show();
                SQLActivity.sqa1.RefreshList();
                finish();
            }
        });

        btnKembali.setOnClickListener(v-> {
            finish();
        });
    }

    private void updateLabel() {
        String format = "dd/MM/yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(format, Locale.US);
        tglLahir.setText(dateFormat.format(calendar.getTime()));
    }

    private boolean checkData() {
        if (nomor.getText().toString().isEmpty() || nama.getText().toString().isEmpty() ||
            tglLahir.getText().toString().isEmpty() || jenisKelamin.getText().toString().isEmpty() ||
            alamat.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Mohon Isi Seluruh Data!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}