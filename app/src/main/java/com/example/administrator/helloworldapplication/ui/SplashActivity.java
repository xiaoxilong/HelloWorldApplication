package com.example.administrator.helloworldapplication.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.helloworldapplication.MainActivity;
import com.example.administrator.helloworldapplication.R;

public class SplashActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private Context mContent;
    private Button button;
    private ViewStub viewStub;
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContent = this;

        button = (Button) findViewById(R.id.btn);
        //20秒之后，跳转到主页
        gotoMain();

        button.setOnClickListener(this);


    }

    private void gotoMain() {
        //开个线程，延迟20秒
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent intent = new Intent(mContent, MainActivity.class);
                startActivity(intent);

                finish();//不能再返回，是一条单线
            }
        }).start();


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:

                if (flag) {
                    Log.i(TAG, "onClick: ");
                    viewStub = (ViewStub) findViewById(R.id.viewStub);
                    viewStub.inflate();//只能被使用一次
                    flag = false;
                }else {
                    Toast.makeText(SplashActivity.this, "not to clicked!!!", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
