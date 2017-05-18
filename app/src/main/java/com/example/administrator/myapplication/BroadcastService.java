package com.example.administrator.myapplication;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Administrator on 2017/5/18.
 */

public class BroadcastService extends IntentService {
    public static final String ACTION="com.example.administrator.myapplication";
    public BroadcastService(){
        super("broadcast");
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        if ((intent!=null)){
            String str=intent.getStringExtra("myKey");
            try{
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Intent myIntent=new Intent(ACTION);
            myIntent.putExtra("resultCode",0x110);
            myIntent.putExtra("myBroadcast","这是从service发出的广播："+str);
            sendBroadcast(myIntent);
        }

    }
}
