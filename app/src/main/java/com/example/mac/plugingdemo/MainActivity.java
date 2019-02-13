package com.example.mac.plugingdemo;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void load(View view) {
        PluginManager.getInstance().loadPath( "/sdcard/plugin-debug.apk",this);
    }

    public void go(View view) {
        Intent intent = new Intent(this,ProxyActivity.class);
        intent.putExtra("className",PluginManager.getInstance().getEntryActivityName());
        startActivity(intent);
    }
}
