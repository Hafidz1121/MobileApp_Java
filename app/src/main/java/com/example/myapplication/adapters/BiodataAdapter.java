package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.myapplication.R;

public class BiodataAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;

    public BiodataAdapter(Context context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.card_item, parent, false);

        TextView txt_Nama = rowView.findViewById(R.id.txt_nama_mahasiswa);
        TextView txt_TglLahir = rowView.findViewById(R.id.txt_npm_mahasiswa);
        TextView txt_JK = rowView.findViewById(R.id.txt_noHp_mahasiswa);

        String[] parts = values[position].split("\n");
        txt_Nama.setText(parts[0]);
        txt_TglLahir.setText(parts[1]);
        txt_JK.setText(parts[2]);

        return rowView;
    }
}
