package com.example.admin.cryptoparse;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;



class RecyclerViewAdapter extends RecyclerView.Adapter<CommonViewHolder>{
    List<Item>list;
    Context context;
    public RecyclerViewAdapter(List<Item> list, RecyclerView recyclerView, Context applicationContext) {
        this.list=list;
        context=applicationContext;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return new CommonViewHolder(inflater.inflate(R.layout.recycler_item,parent,false));

    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.rank.setText(list.get(position).getRank());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
