package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.helpers.SqlHelper;

public class LihatBiodataActivity extends AppCompatActivity {
    protected Cursor cursor;
    private SqlHelper sqlHelper;
    private TextView txtNo, txtNama, txtTglLahir, txtJK, txtAlamat;
    private Button btnKembali;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_biodata);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Lihat Biodata Diri");
        }

        init();
    }

    private void init() {
        sqlHelper = new SqlHelper(this);
        txtNo = findViewById(R.id.txt_Nomor);
        txtNama = findViewById(R.id.txt_Nama);
        txtTglLahir = findViewById(R.id.txt_TglLahir);
        txtJK = findViewById(R.id.txt_JK);
        txtAlamat = findViewById(R.id.txt_Alamat);

        btnKembali = findViewById(R.id.btn_Kembali);

        SQLiteDatabase database = sqlHelper.getReadableDatabase();
        String selectedData = getIntent().getStringExtra("nama");
        String[] parts = selectedData.split("\n");
        String nama = parts[0];

        cursor = database.rawQuery("SELECT * FROM biodata WHERE nama = '"+ nama +"'", null);
        cursor.moveToFirst();

        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            txtNo.setText(cursor.getString(0));
            txtNama.setText(cursor.getString(1));
            txtTglLahir.setText(cursor.getString(2));
            txtJK.setText(cursor.getString(3));
            txtAlamat.setText(cursor.getString(4));
        }

        btnKembali.setOnClickListener(v-> {
            finish();
        });
    }
}