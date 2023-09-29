package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Button;

public class FragmentActivity extends AppCompatActivity {
    private Button btnFragment1, btnFragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Fragment Layout - Hafidz");
        }

        btnFragment1 = findViewById(R.id.btnFragment_1);
        btnFragment2 = findViewById(R.id.btnFragment_2);

        btnFragment1.setOnClickListener(v-> {
            loadFragment(new FragmentKe_1());
        });

        btnFragment2.setOnClickListener(v-> {
            loadFragment(new FragmentKe_2());
        });
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout_view, fragment);
        fragmentTransaction.commit();
    }
}