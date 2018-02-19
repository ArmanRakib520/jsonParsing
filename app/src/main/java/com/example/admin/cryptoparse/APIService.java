package com.example.admin.cryptoparse;



import java.util.List;

import retrofit2.http.GET;
import rx.Observable;


public interface APIService {


    @GET("/v1/ticker")
    Observable<List<Item>> getproductdata();

}