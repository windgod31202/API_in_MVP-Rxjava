package com.example.mvp_training.contract;


public interface MainContract {

    interface IView {
        /**
         * 敘述
         * @param string
         */
        void setString(String string);
    }

    interface IPresenter {

        void onButtonClick(String Password,String Account);
    }

    interface Model{
        interface FinishListener {
            void OnFinished(String string);
        }

        void OnNext(MainContract.Model.FinishListener OnFinished);
    }
}
