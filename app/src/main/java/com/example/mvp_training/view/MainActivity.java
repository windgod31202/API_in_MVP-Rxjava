package com.example.mvp_training.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvp_training.Model;
import com.example.mvp_training.R;
import com.example.mvp_training.contract.MainContract;
import com.example.mvp_training.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainContract.IView {
    private TextView showText;
    private Button button;
    private EditText account,password;
    private MainContract.IPresenter IPresenter;
    private static String TAG = "View";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.EnterButton);
        showText = findViewById(R.id.showStatus);
        account = findViewById(R.id.ETaccount);
        password = findViewById(R.id.ETpassword);
        IPresenter = new MainPresenter(this,new Model());


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, "onClick: ");
                IPresenter.onButtonClick(account.getText().toString(),password.getText().toString());
            }
        });
    }

    @Override
    public void setString(String string) {
        Log.e(TAG, "setString: ");
        showText.setText(string);
    }
}