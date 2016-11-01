package com.example.administrator.helloworldapplication;

import android.app.Application;

/**
 * project_name:HelloWorldApplication
 * Date: 2016/10/31 12:04
 * Email: xiaoxilong5201314@163.com
 * Author: Aaron Empire
 * Description: TODO
 */
public class BaseApplication extends Application {
   private static BaseApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();

    }

    /**
     * get a context
     * @return
     */
    public BaseApplication getApplicationContext(){
        instance = this;

        return instance;
    }
}
