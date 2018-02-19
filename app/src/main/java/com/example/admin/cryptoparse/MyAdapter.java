package com.example.admin.cryptoparse;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

public final int TYPE_MOVIE = 0;
public final int TYPE_LOAD = 1;

static Context context;
        List<Item> movies;
        OnLoadMoreListener loadMoreListener;
        boolean isLoading = false, isMoreDataAvailable = true;




public MyAdapter(Context context, List<Item> movies) {
        this.context = context;
        this.movies = movies;
        }

@Override
public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType==TYPE_MOVIE){
        return new CoinHolder(inflater.inflate(R.layout.recycler_item,parent,false));
        }else{
        return new LoadHolder(inflater.inflate(R.layout.progress_item,parent,false));
        }
        }

@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(position>=getItemCount()-1 && isMoreDataAvailable && !isLoading && loadMoreListener!=null){
        isLoading = true;
        loadMoreListener.onLoadMore();
        }

        if(getItemViewType(position)==TYPE_MOVIE){
        ((CoinHolder)holder).bindData(movies.get(position));
        }
        //No else part needed as load holder doesn't bind any data
        }

@Override
public int getItemViewType(int position) {
        if(position%10!=0){
        return TYPE_MOVIE;
        }else{
        return TYPE_LOAD;
        }
        }

@Override
public int getItemCount() {
        return movies.size();
        }

    /* VIEW HOLDERS */

static class CoinHolder extends RecyclerView.ViewHolder{
    TextView name;
    TextView ranking;
    public CoinHolder(View itemView) {
        super(itemView);
        name=(TextView)itemView.findViewById(R.id.name);
        ranking=(TextView)itemView.findViewById(R.id.ranking);
    }

    void bindData(Item movieModel){
        name.setText(movieModel.getName());
        ranking.setText(movieModel.getRank());
    }
}

static class LoadHolder extends RecyclerView.ViewHolder{
    public LoadHolder(View itemView) {
        super(itemView);
    }
}

    public void setMoreDataAvailable(boolean moreDataAvailable) {
        isMoreDataAvailable = moreDataAvailable;
    }

    /* notifyDataSetChanged is final method so we can't override it
         call adapter.notifyDataChanged(); after update the list
         */
    public void notifyDataChanged(){
        notifyDataSetChanged();
        isLoading = false;
    }


interface OnLoadMoreListener{
    void onLoadMore();
}

    public void setLoadMoreListener(OnLoadMoreListener loadMoreListener) {
        this.loadMoreListener = loadMoreListener;
    }
}