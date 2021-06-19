package com.example.gmphonebook;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewholder> {
    ArrayList<model> dataholder;


    public MyAdapter(ArrayList<model> dataholder) {

        this.dataholder = dataholder;

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
       return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        final model temp=dataholder.get(position);


        holder.fname.setText(dataholder.get(position).getFname());
        holder.lname.setText(dataholder.get(position).getLname());
        holder.ph.setText(dataholder.get(position).getPh());
        holder.em.setText(dataholder.get(position).getEm());

       holder.itemView.setTag(dataholder.get(position).getId());

            }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }


    class myviewholder extends RecyclerView.ViewHolder{
TextView fname,lname,ph,em;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            fname = itemView.findViewById(R.id.s_fname);
            lname = itemView.findViewById(R.id.s_lname);
            ph = itemView.findViewById(R.id.s_phone);
            em = itemView.findViewById(R.id.s_email);
        }
    }
}
