package com.example.administrator.helloworldapplication.utils;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.view.View;

import java.util.regex.Pattern;

/**
 * project_name:HelloWorldApplication
 * Date: 2016/11/9 12:33
 * Email: xiaoxilong5201314@163.com
 * Author: Aaron Empire
 * Description: TODO
 */
public class UtilsNtWorkConnect {
    /**
     * 获取自己手机号，已经不行了，获取不到了
     *
     * @param mContext
     * @return
     */
    public static String getPhoneNum(Context mContext) {
        String phoneNum = "";
        TelephonyManager telephonyManager;
        try {
            telephonyManager = (TelephonyManager) mContext
                    .getSystemService(Context.TELEPHONY_SERVICE);
            phoneNum = telephonyManager.getLine1Number();
        } catch (Exception e) {
            e.getMessage();
        }
        return phoneNum;
    }


    /**
     * 判断当前网络是否可用
     *
     * @return
     */
    public boolean isNetWorkAvailable(Context mContext) {
        ConnectivityManager manager = (ConnectivityManager) (mContext)
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager != null) {
            NetworkInfo info = manager.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                return true;
            } else {
                openNetworkSettings(mContext);
                return false;
            }
        } else {
            return false;
        }
    }
    private void openNetworkSettings(final Context context) {
        new AlertDialog.Builder(context)
                .setTitle("开启网络服务")
                .setMessage("需要使用网络资源，是否开启WiFi网络？")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Go to the activity of settings of wireless
                        Intent intentToNetwork;
                        if (Build.VERSION.SDK_INT > 10) {
                            // intentToNetwork = new Intent("/");
                            //   intentToNetwork = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS);
                            intentToNetwork = new Intent(Settings.ACTION_WIFI_SETTINGS);
                        } else {
                            intentToNetwork = new Intent();
                            ComponentName componentName = new ComponentName(
                                    "com.android.settings",
                                    "com.android.settings.WirelessSettings"
                            );
                            intentToNetwork.setComponent(componentName);
                            intentToNetwork.setAction("android.intent.action.VIEW");
                        }
                        context.startActivity(intentToNetwork);
                        dialog.cancel();
                    }
                })
                .setNegativeButton("否", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }

    private void gotoSystemCall(View v, Context context) {
        //调用系统的
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + v.getTag()));
        context.startActivity(intent);
    }



//                    //添加判断，一种是回拨，一种是直接调用系统
//                    final AlertDialog.Builder builder = new AlertDialog.Builder(CustomerDetailActivity.this);
//                    builder.setIcon(R.drawable.logo);
//                    builder.setTitle(R.string.choice_call_mode);
//
//                    final String[] mode = {getString(R.string.systemCall), getString(R.string.app_name) + getString(R.string.app_name_call)};
//
//                    final int[] callMode = {1};
//                    builder.setSingleChoiceItems(mode, 1, new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            callMode[0] = which;
//                        }
//                    });
//
//                    builder.setPositiveButton(getString(R.string.position_call), new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                            if (callMode[0] == 0) {
//                                gotoSystemCall(v);
//                            } else {
//                                gotoPalmCall();
//
//                            }
//
//                        }
//                    });
//
//                    builder.setNegativeButton(getString(R.string.nagative_call), new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    });
//
//                    builder.show();

    public static boolean isPhoneNumberValid(String phoneNumber) {
        boolean isValid ;
        if (null == phoneNumber || "".equals(phoneNumber)) {
            return false;
        }
        Pattern pattern = Pattern
                .compile("^0([0-9][0-9]|13[0-9]|14[0-9]|15[0-9]|17[0-9]|18[0-9])[0-9]{8}$");
        if (phoneNumber.substring(0, 1).equals("0")) {
            pattern = Pattern.compile("^(0[0-9][0-9])[0-9]{8,9}$");
        }
        isValid = pattern.matcher(phoneNumber).matches();
        //   return pattern.matcher(phoneNumber).matches();
        // String expression = ""
//        String expression ="((^(13|15|18)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
//        CharSequence inputStr = phoneNumber;
//        Pattern pattern = Pattern.compile(expression);
//        Matcher matcher = pattern.matcher(inputStr);
//        if (matcher.matches()) {
//            isValid = true;
//        }
        return isValid;
    }
}
