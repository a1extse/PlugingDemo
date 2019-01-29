package com.example.plugin;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.library.PluginLifeCycleCallback;

public class BaseActivity extends Activity implements PluginLifeCycleCallback {

    private Activity activity;


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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void attach(Activity activity) {
        this.activity = activity;
    }
}
