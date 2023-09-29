package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.adapters.MahasiswaAdapter;
import com.example.myapplication.models.Mahasiswa;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MahasiswaAdapter adapter;
    private ArrayList<Mahasiswa> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Recycler View - Hafidz");
        }

        addData();

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MahasiswaAdapter(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecyclerActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void addData() {
        arrayList = new ArrayList<>();
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
        arrayList.add(new Mahasiswa("Budiono Siregar", "E41223789", "085123456789"));
        arrayList.add(new Mahasiswa("Dimas Maulana", "E41221234", "085156442347"));
    }
}