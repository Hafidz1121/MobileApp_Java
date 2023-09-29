package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity_2 extends AppCompatActivity {
    private EditText showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file2);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("External Storage Show - Hafidz");
        }

        showText = findViewById(R.id.showText);
    }

    public void getPrivate(View view) {
        File folder = getExternalFilesDir("hafidz");
        File myFile = new File(folder, "myDataPrivate.txt");
        String text = getData(myFile);

        if (text != null) {
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }
    }

    public void getPublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myDataPublic.txt");
        String text = getData(myFile);

        if (text != null) {
            showText.setText(text);
        } else {
            showText.setText("No Data");
        }
    }

    public void back(View view) {
        Intent intent = new Intent(FileActivity_2.this, FileActivity_1.class);
        startActivity(intent);
    }

    private String getData(File myFile) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(myFile);
            StringBuffer buffer = new StringBuffer();

            int i = -1;
            while((i = fileInputStream.read()) != -1) {
                buffer.append((char) i);
            }

            return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}