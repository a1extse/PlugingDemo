package com.example.mac.plugingdemo;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import com.example.library.PluginLifeCycleCallback;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ProxyActivity extends Activity {
    private String className;
    PluginLifeCycleCallback pluginLifeCycleCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");
        try {
            Class activity = getClassLoader().loadClass(className);
            Constructor constructor;
            constructor = activity.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});

            pluginLifeCycleCallback = (PluginLifeCycleCallback) instance;
            pluginLifeCycleCallback.attach(this);

            pluginLifeCycleCallback.onCreate(new Bundle());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        pluginLifeCycleCallback.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        pluginLifeCycleCallback.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pluginLifeCycleCallback.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        pluginLifeCycleCallback.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        pluginLifeCycleCallback.onDestroy();
    }

    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getDexClassLoader();
    }

    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }
}
