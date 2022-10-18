package com.example.mvp_training.contract;


public interface MainContract {

    interface IView {
        /**
         * 接收經過Presenter判斷後從Model取得的資料
         * @param string
         */
        void setString(String string);
    }

    interface IPresenter {

        /**
         * 在View按下按鈕後傳入帳號密碼供給Presenter判斷帳密的正確性
         * @param Password
         * @param Account
         */
        void onButtonClick(String Password,String Account);
    }

    interface Model{

        interface FinishListener {
            /**
             * 從Model傳入資料之後可以在Presenter接收到資料再傳給View顯示。
             * @param string
             */
            void OnFinished(String string);
        }

        /**
         * 傳入FinishListener的interface接口供給接取API之後的資料傳入OnFinished函式
         * @param OnFinished
         */
        void OnNext(MainContract.Model.FinishListener OnFinished);
    }
}
