package com.example.myapplication;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentKe_2 extends Fragment {
    private View view;
    private Button btnFragment2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ke_2, container, false);
        btnFragment2 = view.findViewById(R.id.btnKeFragment2);

        btnFragment2.setOnClickListener(v-> {
            Toast.makeText(getActivity(), "Ini Adalah Fragment Ke - 2", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}