package com.example.admin.cryptoparse;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView rank, name;

    public MyViewHolder(View itemView) {
        super(itemView);

        rank = itemView.findViewById(R.id.ranking);
        name = itemView.findViewById(R.id.name);
    }


}