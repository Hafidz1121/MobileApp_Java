package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class FragmentKe_1 extends Fragment {
    private View view;
    private Button btnFragment1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ke_1, container, false);
        btnFragment1 = view.findViewById(R.id.btnKeFragment1);

        btnFragment1.setOnClickListener(v-> {
            Toast.makeText(getActivity(), "Ini Adalah Fragment Ke - 1", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
