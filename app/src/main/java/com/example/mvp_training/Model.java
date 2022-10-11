package com.example.mvp_training;

import android.util.Log;

import com.example.mvp_training.contract.MainContract;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Model implements MainContract.Model{
    private static String TAG = "Model";
    private APIService apiService = SiteManager.getInstance().getAPI();

    @Override
    public void OnNext(MainContract.Model.FinishListener OnFinished) {
        Log.e(TAG, "OnNext_Model: ");
//        GetFakeAPI(OnFinished);
        GetObservableResponse(OnFinished);
    }

    public void GetObservableResponse(MainContract.Model.FinishListener OnFinished){
        apiService.observableResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<Response<List<APIResponse>>>() {
                    @Override
                    public void onNext(@NonNull Response<List<APIResponse>> listResponse) {
//                        for(int i = 0;i<listResponse.body().size();i++){
//                            Log.e(TAG, "onNextId: "+listResponse.body().get(i).getId() );
//                            Log.e(TAG, "onNextUserId: "+listResponse.body().get(i).getUserId() );
//                            Log.e(TAG, "onNextTitle: "+listResponse.body().get(i).getTitle() );
//                            Log.e(TAG, "onNextBody: "+listResponse.body().get(i).getBody() );
//                        }
                        Log.e(TAG, "onNext_Observable: ");
                        OnFinished.OnFinished(listResponse.body().toString());
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: "+e );
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "已完成資料接收 ");
                    }
                });
    }

    public void GetFakeAPI(MainContract.Model.FinishListener OnFinished){
        Call<List<APIResponse>> call = apiService.response ();

        call.enqueue (new Callback<List<APIResponse>>() {
            @Override
            public void onResponse (Call<List<APIResponse>> call, Response<List<APIResponse>> response) {
//                for (int i = 0;i<response.body ().size ();i++){
//                    Log.e (TAG, "userid: "+response.body ().get (i).getUserId ());
//                    Log.e (TAG, "ID: "+response.body ().get (i).getId ());
//                    Log.e (TAG, "title: "+response.body ().get (i).getTitle ());
//                    Log.e (TAG, "body: "+response.body ().get (i).getBody ());
//                }
//                Log.e (TAG, "ToString Size = "+response.body().toString());
                OnFinished.OnFinished(response.body().toString());
            }

            @Override
            public void onFailure (Call<List<APIResponse>> call, Throwable t) {
                Log.e (TAG, "onFailure: " );
            }
        });
    }
}
