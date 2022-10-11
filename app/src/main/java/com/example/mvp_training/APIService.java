package com.example.mvp_training;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;

public interface APIService {

    @GET("posts")
    Call<List<APIResponse>> response();

    @GET("posts")
    Observable<Response<List<APIResponse>>> observableResponse();
}
