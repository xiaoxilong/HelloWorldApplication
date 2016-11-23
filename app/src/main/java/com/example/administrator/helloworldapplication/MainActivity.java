package com.example.administrator.helloworldapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.administrator.helloworldapplication.base.BaseActivity;
import com.example.administrator.helloworldapplication.ui.CallViewActivity;
import com.example.administrator.helloworldapplication.ui.WebActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @InjectView(R.id.main_return)
    TextView mainReturn;
    @InjectView(R.id.first_page)
    TextView firstPage;
    @InjectView(R.id.main_personal)
    TextView mainPersonal;
    @InjectView(R.id.gotocall)
    Button gotoCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick({R.id.main_return,R.id.main_personal,R.id.gotocall})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_return:
                finish();
                break;
            case R.id.main_personal:
                //跳转到TestActivity
                Intent intent = new Intent(this, WebActivity.class);
                startActivity(intent);
                break;
            case R.id.gotocall:
                //跳转到gotoCall
                startActivity(new Intent(this, CallViewActivity.class));
                break;
        }
    }


}
