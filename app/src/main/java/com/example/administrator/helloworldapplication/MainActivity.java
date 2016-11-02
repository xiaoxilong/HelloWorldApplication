package com.example.administrator.helloworldapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.helloworldapplication.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_return)
    TextView mainReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.main_return)
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.main_return:
                finish();
                break;
        }
    }
}
