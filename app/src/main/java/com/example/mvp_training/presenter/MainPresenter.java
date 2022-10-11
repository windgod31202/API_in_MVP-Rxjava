package com.example.mvp_training.presenter;

import android.util.Log;

import com.example.mvp_training.contract.MainContract;

public class MainPresenter implements MainContract.IPresenter, MainContract.Model.FinishListener{

    private MainContract.IView mainIView;
    private MainContract.Model model;
    private static String TAG = "Presenter";
    private String password,account;

    public MainPresenter(MainContract.IView mainIView, MainContract.Model model) {
        this.mainIView = mainIView;
        this.model = model;
    }

    @Override
    public void OnFinished(String string) {
        if(mainIView != null){
            Log.e(TAG, "OnFinished: ");
            mainIView.setString(string);
        }
    }

    @Override
    public void onButtonClick(String Password,String Account) {
        account = Account;
        password = Password;
        Log.e(TAG, "onButtonClick: "+password+"  "+account );
        if(account.equals("jay") && password.equals("jay")){
            Log.e(TAG, "Account is Correct: ");
            model.OnNext(this);
        }else{
            Log.e(TAG, "Account is Error: ");
        }
    }

}
