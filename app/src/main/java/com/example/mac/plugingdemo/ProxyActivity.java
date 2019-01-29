package com.example.mac.plugingdemo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

public class ProxyActivity extends Activity {
    private String className;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getDexClassLoader();
    }

    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }
}
