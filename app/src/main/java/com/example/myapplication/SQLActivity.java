package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.myapplication.adapters.BiodataAdapter;
import com.example.myapplication.helpers.SqlHelper;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class SQLActivity extends AppCompatActivity {
    private String[] daftar;
    private ListView listView;
    private ExtendedFloatingActionButton actionButton;
    private Menu menu;
    private SqlHelper sqlHelper;
    protected Cursor cursor;
    public static SQLActivity sqa1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlactivity);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("SQLite Biodata Diri - Hafidz");
        }

        init();
    }

    private void init() {
        actionButton = findViewById(R.id.btn_AddBio);

        actionButton.setOnClickListener(v-> {
            Intent intent =new Intent(SQLActivity.this, BuatBiodataActivity.class);
            startActivity(intent);
        });

        sqa1 = this;
        sqlHelper = new SqlHelper(this);
        RefreshList();
    }

    public void RefreshList() {
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String nama = cursor.getString(0);
            String tglLahir = cursor.getString(1);
            String jK = cursor.getString(2);
            daftar[i] = tglLahir + "\n" + nama  + "\n" + jK;
        }

        listView = findViewById(R.id.listView_Item);

        // Use a custom adapter with the custom layout
        BiodataAdapter biodataAdapter = new BiodataAdapter(this, daftar);
        listView.setAdapter(biodataAdapter);

        listView.setSelected(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final String selection = daftar[i];
                final CharSequence[] dialogItem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(SQLActivity.this);
                builder.setTitle("Pilih Menu");
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i) {
                            case 0 :
                                Intent intent1 = new Intent(getApplicationContext(), LihatBiodataActivity.class);
                                intent1.putExtra("nama", selection);
                                startActivity(intent1);
                                break;
                            case 1 :
                                Intent intent2 = new Intent(getApplicationContext(), UpdateBiodataActivity.class);
                                intent2.putExtra("nama", selection);
                                startActivity(intent2);
                                break;
                            case 2 :
                                String[] parts = selection.split("\n");
                                String namaToDelete = parts[0];

                                SQLiteDatabase db = sqlHelper.getWritableDatabase();
                                db.execSQL("DELETE FROM biodata WHERE nama = '"+ namaToDelete +"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});
        ((ArrayAdapter<?>)listView.getAdapter()).notifyDataSetChanged();
    }
}