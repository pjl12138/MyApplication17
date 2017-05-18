package com.example.administrator.myapplication;


import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startService(View view){
        Intent intent=new Intent(this,BroadcastService.class);
        intent.putExtra("myKey","testBroadcastService");
        startService(intent);
        startActivity(new Intent(this,BroadcastActivity.class));
    }
    protected void onResume() {
        super.onResume();
        IntentFilter filter=new IntentFilter((BroadcastService.ACTION));
        registerReceiver(receiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
    private BroadcastReceiver receiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent!=null){
                int resultCode=intent.getIntExtra("resultCode",0);
                if(resultCode==0x110){
                    String broadcastValue=intent.getStringExtra("myBroadcast");
                    Toast.makeText(context,broadcastValue,Toast.LENGTH_SHORT).show();
                }
            }
        }
    };
}
