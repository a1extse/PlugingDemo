package com.example.plugin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.library.PluginLifeCycleCallback;

public class BaseActivity extends Activity implements PluginLifeCycleCallback {

    private Activity activity;

    @Override
    public PackageManager getPackageManager() {
        if (activity == null) {
            return super.getPackageManager();
        } else {
            return activity.getPackageManager();
        }
    }

    @Override
    public void setContentView(int layoutResID) {
        if (activity == null) {
            super.setContentView(layoutResID);
        } else {
            activity.setContentView(layoutResID);
        }

    }

    @Override
    public <T extends View> T findViewById(int id) {
        if (activity == null) {
            return super.findViewById(id);
        } else {
            return activity.findViewById(id);
        }

    }

    public Activity getActivity() {
        return activity;
    }

    @Override
    public Window getWindow() {
        if (activity == null) {
            return super.getWindow();
        } else {
            return activity.getWindow();
        }
    }

    @Override
    public WindowManager getWindowManager() {
        if (activity == null) {

            return super.getWindowManager();
        } else {
            return activity.getWindowManager();
        }
    }

    @Override
    public LayoutInflater getLayoutInflater() {
        if (activity == null) {
            return super.getLayoutInflater();
        } else {
            return activity.getLayoutInflater();
        }
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onCreate(Bundle savedInstanceState) {
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStart() {

    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onPause() {
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onStop() {
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onDestroy() {

    }

    @Override
    public void attach(Activity activity) {
        this.activity = activity;
    }
}
