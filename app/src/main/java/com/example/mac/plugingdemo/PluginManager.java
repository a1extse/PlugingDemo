package com.example.mac.plugingdemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.Log;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class PluginManager {
    private static final PluginManager ourInstance = new PluginManager();
    private DexClassLoader dexClassLoader;
    private Resources resources;
    private String entryActivityName;

    public static PluginManager getInstance() {
        return ourInstance;
    }

    private PluginManager() {
    }

    public void loadPath(String path, Context context) {
        Log.d("xzq","path = " + path + " ,exits = " + new File(path).exists());
        File dexOut = context.getDir("dex", Context.MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(path, dexOut.getAbsolutePath(), null, context.getClassLoader());

        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = packageManager.getPackageArchiveInfo(path,PackageManager.GET_ACTIVITIES);
        Log.d("xzq","packageInfo = " + packageInfo + " , activitys = " + packageInfo.activities.length);
        entryActivityName = packageInfo.activities[0].name;


        //实例化Resource对像
        AssetManager assetManager;
        try {
            assetManager = AssetManager.class.newInstance();
            Method method = AssetManager.class.getMethod("addAssetPath",String.class);
            method.invoke(assetManager,path);
        resources = new Resources(assetManager,
                context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public String getEntryActivityName(){
        return entryActivityName;
    }
}
