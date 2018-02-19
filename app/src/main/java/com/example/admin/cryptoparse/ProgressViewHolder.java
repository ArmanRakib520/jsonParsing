package com.example.admin.cryptoparse;

import android.view.View;
import android.widget.ProgressBar;
public class ProgressViewHolder extends MyViewHolder{
    public ProgressBar progressBar;
    public ProgressViewHolder(View itemView) {
        super(itemView);
        progressBar = (ProgressBar)itemView.findViewById(R.id.progressBar);
    }
}