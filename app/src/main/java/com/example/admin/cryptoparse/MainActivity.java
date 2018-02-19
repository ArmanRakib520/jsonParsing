package com.example.admin.cryptoparse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    List<Item>list=new ArrayList<>();
    RecyclerView recyclerView;
    ProgressBar progressBar;
    MyAdapter myAdapter;
    List<Item>dummy=new ArrayList<>();
    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getProductData();
        initListener();

    }

    private void initListener() {

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, Details.class);
                intent.putExtra("data", list.get(position));
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
    }

    public void initView(){

        recyclerView=findViewById(R.id.recyclerview);
        progressBar=findViewById(R.id.progress);
    }
    public void getProductData(){

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coinmarketcap.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        Observable<List<Item>> observable = apiService.getproductdata().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(new Observer <List<Item>>() {
            @Override
            public void onCompleted() {
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("Error", e.toString());
            }

            @Override
            public void onNext(List<Item> items) {
                list = new ArrayList<>();
                for (int i =0;i<items.size();i++){

                    Item item = new Item();
                    item.setId(items.get(i).getId());
                    Log.d("id", item.getId());
                    item.setName(items.get(i).getName());
                    item.setRank(items.get(i).getRank());
                    item.set24h_volume_usd(items.get(i).get24h_volume_usd());
                    item.setAvailable_supply(items.get(i).getAvailable_supply());
                    item.setLast_updated(items.get(i).getLast_updated());
                    item.setMarket_cap_usd(items.get(i).getMarket_cap_usd());
                    item.setPrice_usd(items.get(i).getPrice_usd());
                    item.setPrice_btc(items.get(i).getPrice_btc());
                    list.add(item);
                }
                //loadFirstTen();
                //myAdapter=new MyAdapter(getApplicationContext(), list);
                recyclerViewAdapter=new RecyclerViewAdapter(list, recyclerView, getApplicationContext());
//                myAdapter.setLoadMoreListener(new MyAdapter.OnLoadMoreListener() {
//                    @Override
//                    public void onLoadMore() {
//                        recyclerView.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                int index = list.size() - 1;
//                                loadMore(index);
//                            }
//                        });
//                    }
//                });
                Log.d("size", list.size()+"");
                RecyclerView.LayoutManager recyce = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(recyce);
                recyclerView.setAdapter(recyclerViewAdapter);


            }
        });
    }
    public List<Item> loadMore(int position){
        for (int i=position; i<position; i++){
            dummy.add(list.get(i));
        }
        return dummy;

    }

    public List<Item> loadFirstTen(){


        for (int i=0; i<10; i++){
            dummy.add(list.get(i));
        }
        return dummy;
    }
}
