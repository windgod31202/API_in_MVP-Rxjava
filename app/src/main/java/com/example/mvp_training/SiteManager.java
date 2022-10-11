package com.example.mvp_training;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SiteManager {
    // 以Singleton模式建立
    private static SiteManager mInstance;

    private APIService myAPIService;

    private SiteManager () {

        // 設置baseUrl即要連的網站，addConverterFactory用Gson作為資料處理Converter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        myAPIService = retrofit.create(APIService.class);

    }

    public static SiteManager getInstance() {
        if (mInstance == null) {
            mInstance = new SiteManager ();
        }
        return mInstance;
    }

    public APIService getAPI() {
        return myAPIService;
    }
}