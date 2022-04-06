package com.hafidz99.sqlite_20160140049.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hafidz99.sqlite_20160140049.R;
import com.hafidz99.sqlite_20160140049.database.Teman;

import java.util.ArrayList;

public class TemanAdapter extends RecyclerView.Adapter<TemanAdapter.TemanViewHolder> {

    private ArrayList<Teman> listdata;

    public TemanAdapter(ArrayList<Teman>listdata){
        this.listdata = listdata;
    }

    @Override
    public TemanAdapter.TemanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.row_data_teman,parent,false);

        return new TemanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemanAdapter.TemanViewHolder holder, int position) {
        String nm,tlp;
        nm = listdata.get(position).getNama();
        tlp = listdata.get(position).getTelpon();

        holder.namaTxt.setText(nm);
        holder.namaTxt.setTextColor(Color.BLUE);
        holder.namaTxt.setTextSize(20);
        holder.telponTxt.setText(tlp);
    }

    @Override
    public int getItemCount() {
        return (listdata != null)?listdata.size() : 0;
    }

    public class TemanViewHolder extends RecyclerView.ViewHolder {

        private CardView cardView;
        private TextView namaTxt,telponTxt;
        public TemanViewHolder(View view){
            super(view);
            cardView = (CardView) view.findViewById(R.id.kartuku);
            namaTxt = (TextView) view.findViewById(R.id.textNama);
            telponTxt = (TextView) view.findViewById(R.id.textTelpon);
        }
    }
}
