package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileActivity_1 extends AppCompatActivity {
    private EditText inputTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file1);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("External Storage Input - Hafidz");
        }

        inputTxt = findViewById(R.id.inputText);
    }

    public void savePrivate(View view) {
        String info = inputTxt.getText().toString();
        File folder = getExternalFilesDir("hafidz");
        File myFile = new File(folder, "myDataPrivate.txt");

        if (!info.isEmpty()) {
            writeData(myFile, info);
            inputTxt.setText("");
        } else {
            Toast.makeText(this, "Mohon Isi Pesan !", Toast.LENGTH_SHORT).show();
        }
    }

    public void savePublic(View view) {
        String info = inputTxt.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder, "myDataPublic.txt");

        if (!info.isEmpty()) {
            writeData(myFile, info);
            inputTxt.setText("");
        } else {
            Toast.makeText(this, "Mohon Isi Pesan !", Toast.LENGTH_SHORT).show();
        }
    }

    public void next(View view) {
        Intent intent = new Intent(FileActivity_1.this, FileActivity_2.class);
        startActivity(intent);
    }

    public void deletePrivate(View view) {
        File folder = getExternalFilesDir("hafidz");

        if (folder != null) {
            deleteFiles(folder);
            Toast.makeText(this, "Private File Di Hapus", Toast.LENGTH_SHORT).show();
        }
    }

    public void deletePublic(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        if (folder != null) {
            deleteFiles(folder);
            Toast.makeText(this, "Public File Di Hapus", Toast.LENGTH_SHORT).show();
        }
    }

    private void writeData(File myFile, String data) {
        FileOutputStream fileOutputStream = null;

        try {
            System.out.println("TES");
            fileOutputStream = new FileOutputStream(myFile);
            fileOutputStream.write(data.getBytes());
            Toast.makeText(this, "File Tersimpan Pada " + myFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void deleteFiles(File folder) {
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    Boolean deleted = file.delete();
                }
            }
        }
    }
}