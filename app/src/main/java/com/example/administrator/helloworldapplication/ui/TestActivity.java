package com.example.administrator.helloworldapplication.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.helloworldapplication.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        String data = intent.getDataString();
        Toast.makeText(TestActivity.this, data, Toast.LENGTH_SHORT).show();
    }
}
