package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private LinearLayout btnRelative, btnLinear,
            btnConstraint, btnFrame,
            btnTable, btnMaterial,
            btnScroll, btnScrollHorizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Tugas Mobile Application");
        }

        init();
    }

    private void init() {
        btnLinear = findViewById(R.id.btnLinearLayout);
        btnRelative = findViewById(R.id.btnRelativeLayout);
        btnConstraint = findViewById(R.id.btnConstraintLayout);
        btnFrame = findViewById(R.id.btnFrame);
        btnTable = findViewById(R.id.btnTableLayout);
        btnMaterial = findViewById(R.id.btnMaterialDesign);
        btnScroll = findViewById(R.id.btnScrollView);
        btnScrollHorizontal = findViewById(R.id.btnScrollViewHorizontal);

        btnLinear.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, LinearActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Linear Layout", Toast.LENGTH_SHORT).show();
        });

        btnRelative.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, RelativeActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Relative Layout", Toast.LENGTH_SHORT).show();
        });

        btnConstraint.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, ConstraintActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Constraint Layout", Toast.LENGTH_SHORT).show();
        });

        btnFrame.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, FrameActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Frame Layout", Toast.LENGTH_SHORT).show();
        });

        btnTable.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, TableActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Table Layout", Toast.LENGTH_SHORT).show();
        });

        btnMaterial.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, MaterialActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Material Design", Toast.LENGTH_SHORT).show();
        });

        btnScroll.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, ScrollActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Scroll View", Toast.LENGTH_SHORT).show();
        });

        btnScrollHorizontal.setOnClickListener(v-> {
            startActivity(new Intent(MainActivity.this, ScrollHorizoActivity.class));

            Toast.makeText(getApplicationContext(), "Pindah Halaman Ke Scroll View Horizontal", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.listView) {
            startActivity(new Intent(MainActivity.this, ListViewActivity.class));
        } else if (item.getItemId() == R.id.recyclerView) {
            startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
        } else if (item.getItemId() == R.id.fragmentView) {
            startActivity(new Intent(MainActivity.this, FragmentActivity.class));
        } else if (item.getItemId() == R.id.implicitIntent) {
            startActivity(new Intent(MainActivity.this, ImplicitIntentActivity.class));
        } else if (item.getItemId() == R.id.implicitExplicit) {
            startActivity(new Intent(MainActivity.this, ExplicitIntentActivity.class));
        } else if (item.getItemId() == R.id.sqlLite_txt) {
            startActivity(new Intent(MainActivity.this, FileActivity_1.class));
        } else if (item.getItemId() == R.id.sqlLite_db) {
            startActivity(new Intent(MainActivity.this, SQLActivity.class));
        }

        return true;
    }
}